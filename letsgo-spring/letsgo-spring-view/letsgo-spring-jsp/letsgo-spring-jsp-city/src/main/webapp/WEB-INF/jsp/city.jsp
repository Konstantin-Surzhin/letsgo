<%-- 
    Document   : city
    Created on : 08.09.2016, 12:12:48
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${city_head}</title>
    </head>
    <body>
        <h1>${city_head}</h1>

        <form:form method="POST" acceptCharset="UTF-8" modelAttribute="city" >
            <form:label path="cityName">${message}</form:label>
            <form:input path="cityName" />
            <input type="submit" value="${submit}" />
        </form:form>
    </body>
</html>
