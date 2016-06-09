<%-- 
Document   : login
Created on : 24.05.2016, 9:43:15
Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>        
<c:set var="clientLocale" value="${pageContext.request.locale}" />
<fmt:setLocale value="${clientLocale}" />
<fmt:setBundle basename="org.igo.i18n.login.Bundle" var="msg" scope="session"/>
<!DOCTYPE html>
<html lang="${clientLocale}">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="title" bundle="${msg}"/></title>
    </head>
    <body>
        <h1><fmt:message key="welcome" bundle="${msg}"/></h1>
        <form method="POST" action="j_security_check">
            <input type="text" name="j_username"><br/>
            <input title="login:" type="password" name="j_password"><br/>
            <input type="submit" value="submit" name="submit"/>
        </form>
    </body>
</html>
