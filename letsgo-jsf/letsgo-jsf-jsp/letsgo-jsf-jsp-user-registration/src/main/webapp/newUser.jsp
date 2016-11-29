<%-- 
    Document   : newUser
    Created on : 23.11.2016, 10:18:33
    Author     : pl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <f:view>     
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>User registration page</title>
        </head>
        <body>
            <h1>Login</h1>
            <h:form>
                <h:panelGrid id="panel" columns="2" border="1" cellpadding="0" cellspacing="2">
                    <f:facet name="header">
                        <h:outputText value="Регистрация нового пользователя"/>
                    </f:facet>
                    <h:outputLabel value="Login(nikname): " />
                    <h:inputText value="#{userRegistrationManagedBean.login}"  required="true"/>
                    <h:outputLabel value="password"/>
                    <h:inputSecret value="#{userRegistrationManagedBean.password}"  required="true"/>
                    <h:outputLabel value="repite password"/>
                    <h:inputSecret value="#{userRegistrationManagedBean.rpassword}"  required="true"/>
                    <f:facet name="footer">
                        <h:panelGroup style="display:block; text-align:center">
                            <h:commandButton value="Регистация" id="submit" type="submit" action="#{userRegistrationManagedBean.addUser}"/>
                            <h:commandButton value="Сброс" id="reset" type="reset"/>
                        </h:panelGroup>
                    </f:facet>
                </h:panelGrid>
            </h:form>
            <h:form>
                <h:commandLink value="login" action="index" />
            </h:form>
        </body>
    </f:view>
</html>
