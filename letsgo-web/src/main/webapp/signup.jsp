<%-- 
    Document   : signup
    Created on : 27.05.2016, 13:06:26
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>        
<c:set var="clientLocale" value="${pageContext.request.locale}" />
<c:set var="clientLocales" value="${pageContext.request.locales}" />
<fmt:setLocale value="${clientLocale}" />
<fmt:setBundle basename="org.igo.i18n.signup.Bundle" var="msg" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="title" bundle="${msg}"/></title>
    </head>
    <body>
        <h1><fmt:message key="welcome" bundle="${msg}"/></h1>
        <form method="POST" action="SignUp">
            <input type="text" name="name"><br/>
            <input title="passwd" type="password" name="passwd"><br/>
            <input title="repeatpasswd" type="password" name="rpasswd"><br/>
            <input type="submit" value="submit" name="submit"/>
        </form>
    </body>
</html>
