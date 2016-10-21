/*******************************************************************************
 * Copyright 2014 The MITRE Corporation
 *   and the MIT Kerberos and Internet Trust Consortium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
var DynRegClient = Backbone.Model.extend({
    idAttribute: "client_id",

    defaults:{
        client_id:null,
        client_secret:null,
        redirect_uris:[],
        client_name:null,
        client_uri:null,
        logo_uri:null,
        contacts:[],
        tos_uri:null,
        token_endpoint_auth_method:null,
        scope:null,
        grant_types:[],
        response_types:[],
        policy_uri:null,
        jwks_uri:null,
        
        application_type:null,
        sector_identifier_uri:null,
        subject_type:null,
        
        request_object_signing_alg:null,
        
        userinfo_signed_response_alg:null,
        userinfo_encrypted_response_alg:null,
        userinfo_encrypted_response_enc:null,
        
        id_token_signed_response_alg:null,
        id_token_encrypted_response_alg:null,
        id_token_encrypted_response_enc:null,
        
        default_max_age:null,
        require_auth_time:false,
        default_acr_values:null,
        
        initiate_login_uri:null,
        post_logout_redirect_uri:null,
        
        request_uris:[],
        
        registration_access_token:null,
        registration_client_uri:null
    },
    
    sync: function(method, model, options){
    	if (model.get('registration_access_token')) {
    		var headers = options.headers ? options.headers : {};
    		headers['Authorization'] = 'Bearer ' + model.get('registration_access_token');
    		options.headers = headers;
    	}
    	
    	return this.constructor.__super__.sync(method, model, options);
    },

    urlRoot:'register'
    
});

var DynRegRootView = Backbone.View.extend({
	
	tagName: 'span',
	
	initialize:function(options) {
    	this.options = options;
		
	},
	
	events:{
		"click #newreg":"newReg",
		"click #editreg":"editReg"
	},
	
	load:function(callback) {
    	if (this.options.systemScopeList.isFetched) {
    		callback();
    		return;
    	}

    	$('#loadingbox').sheet('show');
    	$('#loading').html('<span class="label" id="loading-scopes">Scopes</span> ');

    	$.when(this.options.systemScopeList.fetchIfNeeded({success:function(e) {$('#loading-scopes').addClass('label-success');}}))
    	.done(function() {
    	    		$('#loadingbox').sheet('hide');
    	    		callback();
    			});    	
	},
    	
	render:function() {
    	$(this.el).html($('#tmpl-dynreg').html());
    	return this;
	},
	
	newReg:function(e) {
    	e.preventDefault();
        this.remove();
        app.navigate('dev/dynreg/new', {trigger: true});		
	},
	
	editReg:function(e) {
    	e.preventDefault();
		var clientId = $('#clientId').val();
		var token = $('#regtoken').val();
		
		var client = new DynRegClient({
			client_id: clientId,
			registration_access_token: token
		});
		
		var self = this;
		
		client.fetch({success: function() {

    		var userInfo = getUserInfo();
    		var contacts = client.get("contacts");
    		if (userInfo != null && userInfo.email != null && ! _.contains(contacts, userInfo.email)) {
    			contacts.push(userInfo.email);
    		}
    		client.set({
    			contacts: contacts
    		}, { silent: true });
			
	    	var view = new DynRegEditView({model: client, systemScopeList: app.systemScopeList}); 
	    	
	    	view.load(function() {
	    		$('#content').html(view.render().el);
	    		view.delegateEvents();
	    		setPageTitle("Edit a Dynamically Registered Client");
	    		app.navigate('dev/dynreg/edit', {trigger: true});	    		
	    		self.remove();
	    	});
		}, error: function() {
    		$('#modalAlert div.modal-body').html("Invalid client or registration access token.");
    		
			 $("#modalAlert").modal({ // wire up the actual modal functionality and show the dialog
				 "backdrop" : "static",
				 "keyboard" : true,
				 "show" : true // ensure the modal is shown immediately
			 });

		}});
	}
	
});

var DynRegEditView = Backbone.View.extend({
	
	tagName: 'span',
	
	initialize:function(options) {
    	this.options = options;
        if (!this.template) {
            this.template = _.template($('#tmpl-dynreg-client-form').html());
        }

        this.redirectUrisCollection = new Backbone.Collection();
        this.scopeCollection = new Backbone.Collection();
        this.contactsCollection = new Backbone.Collection();
        this.defaultAcrValuesCollection = new Backbone.Collection();
        this.requestUrisCollection = new Backbone.Collection();
	},
	
	load:function(callback) {
    	if (this.options.systemScopeList.isFetched) {
    		callback();
    		return;
    	}

    	$('#loadingbox').sheet('show');
    	$('#loading').html('<span class="label" id="loading-scopes">Scopes</span> ');

    	$.when(this.options.systemScopeList.fetchIfNeeded({success:function(e) {$('#loading-scopes').addClass('label-success');}}))
    	.done(function() {
    	    		$('#loadingbox').sheet('hide');
    	    		callback();
    			});    	
	},
    	
	events:{
        "click .btn-save":"saveClient",
        "click .btn-cancel":"cancel",
        "click .btn-delete":"deleteClient",
        "change #logoUri input":"previewLogo",
        "change #tokenEndpointAuthMethod input:radio":"toggleClientCredentials"
    },

    cancel:function(e) {
    	e.preventDefault();
    	app.navigate('dev/dynreg', {trigger: true});
    },
    
    deleteClient:function (e) {
    	e.preventDefault();

        if (confirm("Are you sure sure you would like to delete this client?")) {
            var self = this;

            this.model.destroy({
                success:function () {
                	self.remove();
                	app.navigate('dev/dynreg', {trigger: true});
                },
                error:function (error, response) {
            		console.log("An error occurred when deleting a client");
    
					//Pull out the response text.
					var responseJson = JSON.parse(response.responseText);
            		
            		//Display an alert with an error message
					$('#modalAlert div.modal-header').html(responseJson.error);
	        		$('#modalAlert div.modal-body').html(responseJson.error_description);
            		
        			 $("#modalAlert").modal({ // wire up the actual modal functionality and show the dialog
        				 "backdrop" : "static",
        				 "keyboard" : true,
        				 "show" : true // ensure the modal is shown immediately
        			 });
            	}
            });

        }

        return false;
    },

    previewLogo:function() {
    	if ($('#logoUri input', this.el).val()) {
    		$('#logoPreview', this.el).empty();
    		$('#logoPreview', this.el).attr('src', $('#logoUri input', this.el).val());
    	} else {
    		//$('#logoBlock', this.el).hide();
    		$('#logoPreview', this.el).attr('src', 'resources/images/logo_placeholder.gif');
    	}
    },

    /**
     * Set up the form based on the current state of the tokenEndpointAuthMethod parameter
     * @param event
     */
    toggleClientCredentials:function() {
    	
        var tokenEndpointAuthMethod = $('#tokenEndpointAuthMethod input', this.el).filter(':checked').val();
        
        // show or hide the signing algorithm method depending on what's selected
        if (tokenEndpointAuthMethod == 'private_key_jwt'
        	|| tokenEndpointAuthMethod == 'client_secret_jwt') {
        	$('#tokenEndpointAuthSigningAlg', this.el).show();
        } else {
        	$('#tokenEndpointAuthSigningAlg', this.el).hide();
        }
    },
    
    disableUnsupportedJOSEItems:function(serverSupported, query) {
        var supported = ['default'];
        if (serverSupported) {
        	supported = _.union(supported, serverSupported);
        }
        $(query, this.$el).each(function(idx) {
        	if(_.contains(supported, $(this).val())) {
        		$(this).prop('disabled', false);
        	} else {
        		$(this).prop('disabled', true);
        	}
        });
    	
    },

    // returns "null" if given the value "default" as a string, otherwise returns input value. useful for parsing the JOSE algorithm dropdowns
    defaultToNull:function(value) {
    	if (value == 'default') {
    		return null;
    	} else {
    		return value;
    	}
    },

    // maps from a form-friendly name to the real grant parameter name
    grantMap:{
    	'authorization_code': 'authorization_code',
    	'password': 'password',
    	'implicit': 'implicit',
    	'client_credentials': 'client_credentials',
    	'redelegate': 'urn:ietf:params:oauth:grant_type:redelegate',
    	'refresh_token': 'refresh_token'
    },
    
    // maps from a form-friendly name to the real response type parameter name
    responseMap:{
    	'code': 'code',
    	'token': 'token',
    	'idtoken': 'id_token',
    	'token-idtoken': 'token id_token',
    	'code-idtoken': 'code id_token',
    	'code-token': 'code token',
    	'code-token-idtoken': 'code token id_token'
    },

    saveClient:function (e) {
    	e.preventDefault();

        $('.control-group').removeClass('error');

        // build the scope object
        var scopes = this.scopeCollection.pluck("item").join(" ");
        
        // build the grant type object
        var grantTypes = [];
        $.each(this.grantMap, function(index,type) {
            if ($('#grantTypes-' + index).is(':checked')) {
                grantTypes.push(type);
            }
        });
        
        // build the response type object
        var responseTypes = [];
        $.each(this.responseMap, function(index,type) {
        	if ($('#responseTypes-' + index).is(':checked')) {
        		responseTypes.push(type);
        	}
        });
        
        var contacts = this.contactsCollection.pluck('item');
        var userInfo = getUserInfo();
        if (userInfo && userInfo.email) {
        	if (!_.contains(contacts, userInfo.email)) {
        		contacts.push(userInfo.email);
        	}
        }

        var attrs = {
            client_name:$('#clientName input').val(),
            redirect_uris: this.redirectUrisCollection.pluck("item"),
            logo_uri:$('#logoUri input').val(),
            grant_types: grantTypes,
            scope: scopes,
            client_secret: null, // never send a client secret
            tos_uri: $('#tosUri input').val(),
            policy_uri: $('#policyUri input').val(),
            client_uri: $('#clientUri input').val(),
            application_type: $('#applicationType input').filter(':checked').val(),
            jwks_uri: $('#jwksUri input').val(),
            subject_type: $('#subjectType input').filter(':checked').val(),
            token_endpoint_auth_method: $('#tokenEndpointAuthMethod input').filter(':checked').val(),
            response_types: responseTypes,
            sector_identifier_uri: $('#sectorIdentifierUri input').val(),
            initiate_login_uri: $('#initiateLoginUri input').val(),
            post_logout_redirect_uri: $('#postLogoutRedirectUri input').val(),
            reuse_refresh_token: $('#reuseRefreshToken').is(':checked'),
            require_auth_time: $('#requireAuthTime input').is(':checked'),
            default_max_age: parseInt($('#defaultMaxAge input').val()),
            contacts: contacts,
            request_uris: this.requestUrisCollection.pluck('item'),
            default_acr_values: this.defaultAcrValuesCollection.pluck('item'),
            request_object_signing_alg: this.defaultToNull($('#requestObjectSigningAlg select').val()),
            userinfo_signed_response_alg: this.defaultToNull($('#userInfoSignedResponseAlg select').val()),
            userinfo_encrypted_response_alg: this.defaultToNull($('#userInfoEncryptedResponseAlg select').val()),
            userinfo_encrypted_response_enc: this.defaultToNull($('#userInfoEncryptedResponseEnc select').val()),
            id_token_signed_response_alg: this.defaultToNull($('#idTokenSignedResponseAlg select').val()),
            id_token_encrypted_response_alg: this.defaultToNull($('#idTokenEncryptedResponseAlg select').val()),
            id_token_encrypted_response_enc: this.defaultToNull($('#idTokenEncryptedResponseEnc select').val()),
            token_endpoint_auth_signing_alg: this.defaultToNull($('#tokenEndpointAuthSigningAlg select').val())
        };

        // set all empty strings to nulls
        for (var key in attrs) {
        	if (attrs[key] === "") {
        		attrs[key] = null;
        	}
        }
        
        var _self = this;        
        this.model.save(attrs, {
            success:function () {
            	// switch to an "edit" view
            	app.navigate('dev/dynreg/edit', {trigger: true});
            	_self.remove();

            	var userInfo = getUserInfo();
        		var contacts = _self.model.get("contacts");
        		if (userInfo != null && userInfo.email != null && ! _.contains(contacts, userInfo.email)) {
        			contacts.push(userInfo.email);
        		}
        		_self.model.set({
        			contacts: contacts
        		}, { silent: true });

        		var view = new DynRegEditView({model: _self.model, systemScopeList: _self.options.systemScopeList});
    			
    			view.load(function() {
    				// reload
    				$('#content').html(view.render().el);
    				view.delegateEvents();
    			});
            },
            error:function (error, response) {
        		console.log("An error occurred when deleting from a list widget");

				//Pull out the response text.
				var responseJson = JSON.parse(response.responseText);
        		
        		//Display an alert with an error message
				$('#modalAlert div.modal-header').html(responseJson.error);
        		$('#modalAlert div.modal-body').html(responseJson.error_description);
        		
    			 $("#modalAlert").modal({ // wire up the actual modal functionality and show the dialog
    				 "backdrop" : "static",
    				 "keyboard" : true,
    				 "show" : true // ensure the modal is shown immediately
    			 });
        	}
        });

        return false;
    },

    render:function() {
		$(this.el).html(this.template({client: this.model.toJSON(), userInfo: getUserInfo()}));
		
        var _self = this;

        // build and bind registered redirect URI collection and view
        _.each(this.model.get("redirect_uris"), function (redirectUri) {
            _self.redirectUrisCollection.add(new URIModel({item:redirectUri}));
        });

        $("#redirectUris .controls",this.el).html(new ListWidgetView({
        	type:'uri', 
        	placeholder: 'https://',
        	collection: this.redirectUrisCollection}).render().el);
        
        // build and bind scopes
        var scopes = this.model.get("scope");
        var scopeSet = scopes ? scopes.split(" ") : [];
        _.each(scopeSet, function (scope) {
            _self.scopeCollection.add(new Backbone.Model({item:scope}));
        });

        $("#scope .controls",this.el).html(new ListWidgetView({
        	placeholder: 'new scope', 
        	autocomplete: _.uniq(_.flatten(this.options.systemScopeList.pluck("value"))), 
            collection: this.scopeCollection}).render().el);

        // build and bind contacts
        _.each(this.model.get('contacts'), function (contact) {
        	_self.contactsCollection.add(new Backbone.Model({item:contact}));
        });
        
        $("#contacts .controls div", this.el).html(new ListWidgetView({
        	placeholder: 'new contact',
        	collection: this.contactsCollection}).render().el);
        
        
        // build and bind request URIs
        _.each(this.model.get('request_uris'), function (requestUri) {
        	_self.requestUrisCollection.add(new URIModel({item:requestUri}));
        });
        
        $('#requestUris .controls', this.el).html(new ListWidgetView({
        	type: 'uri',
        	placeholder: 'https://',
        	collection: this.requestUrisCollection}).render().el);
        
        // build and bind default ACR values
        _.each(this.model.get('default_acr_values'), function (defaultAcrValue) {
        	_self.defaultAcrValuesCollection.add(new Backbone.Model({item:defaultAcrValue}));
        });
        
        $('#defaultAcrValues .controls', this.el).html(new ListWidgetView({
        	placeholder: 'new ACR value',
        	// TODO: autocomplete from spec
        	collection: this.defaultAcrValuesCollection}).render().el);

        this.toggleClientCredentials();
        this.previewLogo();
        
        // disable unsupported JOSE algorithms
        this.disableUnsupportedJOSEItems(app.serverConfiguration.request_object_signing_alg_values_supported, '#requestObjectSigningAlg option');
        this.disableUnsupportedJOSEItems(app.serverConfiguration.userinfo_signing_alg_values_supported, '#userInfoSignedResponseAlg option');
        this.disableUnsupportedJOSEItems(app.serverConfiguration.userinfo_encryption_alg_values_supported, '#userInfoEncryptedResponseAlg option');
        this.disableUnsupportedJOSEItems(app.serverConfiguration.userinfo_encryption_enc_values_supported, '#userInfoEncryptedResponseEnc option');
        this.disableUnsupportedJOSEItems(app.serverConfiguration.id_token_signing_alg_values_supported, '#idTokenSignedResponseAlg option');
        this.disableUnsupportedJOSEItems(app.serverConfiguration.id_token_encryption_alg_values_supported, '#idTokenEncryptedResponseAlg option');
        this.disableUnsupportedJOSEItems(app.serverConfiguration.id_token_encryption_enc_values_supported, '#idTokenEncryptedResponseEnc option');
        this.disableUnsupportedJOSEItems(app.serverConfiguration.token_endpoint_auth_signing_alg_values_supported, '#tokenEndpointAuthSigningAlg option');
        
        this.$('.nyi').clickover({
        	placement: 'right', 
        	title: 'Not Yet Implemented', 
        	content: 'The value of this field will be saved with the client, '
        		+'but the server does not currently process anything with it. '
        		+'Future versions of the server library will make use of this.'
        	});
        

        return this;
	}
	
});
