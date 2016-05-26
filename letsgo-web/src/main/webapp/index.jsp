<%-- 
    Document   : index
    Created on : 19.05.2016, 14:42:24
    Author     : surzhin.konstantin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>        
<c:set var="clientLocale" value="${pageContext.request.locale}" />
<c:set var="clientLocales" value="${pageContext.request.locales}" />
<fmt:setLocale value="${clientLocale}" />
<fmt:setBundle basename="org.igo.i18n.home.Bundle" var="msg" scope="session"/>
<!DOCTYPE html>
<html lang="${clientLocale}">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="title" bundle="${msg}"/></title>
    </head>
    <body>
        <h1><fmt:message key="welcome" bundle="${msg}"/></h1>

        Preferred locale: ${clientLocale.displayName}<br/>
        Preferred locale country: ${clientLocale.displayCountry}<br/>
        Preferred locale language: ${clientLocale.displayLanguage}<br/>

        <c:forEach var="loc" items="${clientLocales}" begin="1" >

            Preferred Locale: ${clientLocale.displayName}<br/>
            Preferred locale country: ${clientLocale.displayCountry}<br/>
            Preferred locale language: ${clientLocale.displayLanguage}<br/><br/>
        </c:forEach>
    </body>
</html>
