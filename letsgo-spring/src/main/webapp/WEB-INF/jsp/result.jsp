<%-- 
    Document   : result
    Created on : 03.06.2016, 14:06:49
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Spring MVC Form Handling</title>
    </head>
    <body>
        <h2>User Registration Result</h2>
        <table>
            <tr>
                <td>Name</td>
                <td>${u.name}</td>
            </tr>
            <tr>
                <td>Password</td>
                <td>${u.email}</td>
            </tr>
        </table>
    </body>
</html>