<%-- 
    Document   : index
    Created on : 19.05.2016, 14:42:24
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IGO Server</title>
    </head>
    <body>
        <h1>Let's go play go!</h1>
        <c:set var="clientLocale" value="${pageContext.request.locale}" />
        <c:set var="clientLocales" value="${pageContext.request.locales}" />
        
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
