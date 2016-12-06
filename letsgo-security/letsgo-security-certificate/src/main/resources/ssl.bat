"C:\Program Files\Java\jre1.8.0_111\bin\keytool.exe" -v -genkey -alias wildfly.ssl -keypass alias.2015 -keyalg RSA -keysize 2048 -sigalg SHA1withRSA -keystore wildfly.ssl.keystore -storepass keystore.2015
"C:\Program Files\Java\jre1.8.0_111\bin\keytool.exe" -list -v -keystore wildfly.ssl.keystore
<https-listener name="httpsServer" security-realm="ApplicationRealm" socket-binding="https"/>

        <security-realms>
            <security-realm name="ManagementRealm">
                <authentication>
                    <local default-user="$local" skip-group-loading="true"/>
                    <properties path="mgmt-users.properties" relative-to="jboss.server.config.dir"/>
                </authentication>
                <authorization map-groups-to-roles="false">
                    <properties path="mgmt-groups.properties" relative-to="jboss.server.config.dir"/>
                </authorization>
            </security-realm>
            <security-realm name="ApplicationRealm">
                <server-identities>
                    <ssl>
                        <keystore path="wildfly.ssl.keystore" relative-to="jboss.server.config.dir" keystore-password="keystore.2015" alias="wildfly.ssl" key-password="alias.2015"/>
                    </ssl>
                </server-identities>
                <authentication>
                    <local default-user="$local" allowed-users="*" skip-group-loading="true"/>
                    <properties path="application-users.properties" relative-to="jboss.server.config.dir"/>
                </authentication>
                <authorization>
                    <properties path="application-roles.properties" relative-to="jboss.server.config.dir"/>
                </authorization>
            </security-realm>
        </security-realms>