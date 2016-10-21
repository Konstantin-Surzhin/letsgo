<%-- 
    Document   : error
    Created on : 24.05.2016, 9:43:28
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>        
<c:set var="clientLocale" value="${pageContext.request.locale}" />
<fmt:setLocale value="${clientLocale}" />
<fmt:setBundle basename="org.igo.i18n.error.Bundle" var="msg" scope="session"/>
<c:url var="url" value="/admin"/>
<!DOCTYPE html>
<html lang="${clientLocale}">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="title" bundle="${msg}"/></title>
    </head>
    <body>
        <h1><fmt:message key="welcome" bundle="${msg}"/></h1>

        <h2><fmt:message key="message" bundle="${msg}"/></h2>

        <p><fmt:message key="hint" bundle="${msg}"/></p>
    </body>
</html>
