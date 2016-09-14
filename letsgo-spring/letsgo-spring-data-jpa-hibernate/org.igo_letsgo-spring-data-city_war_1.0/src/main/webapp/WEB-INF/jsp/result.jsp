<%-- 
    Document   : result
    Created on : 12.09.2016, 9:43:51
    Author     : surzhin.konstantin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello City! </h1>
        <div><em>${error}</em></div>
        <table border = "1" >
            <c:forEach var="city" items="${cities}" >
                <tr>
                    <td>${city.cityName}</td>
                    <td>${city.id}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
