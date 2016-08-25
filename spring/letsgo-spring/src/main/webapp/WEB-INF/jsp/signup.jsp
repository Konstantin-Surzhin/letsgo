<%-- 
    Document   : signup
    Created on : 03.06.2016, 9:51:04
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SignUp Page</title>
        <style type="text/css">
            .formFieldError { background-color: #FFC; }
        </style>
    </head>

    <body>
        <h1>${message}</h1>
        <mvc:form modelAttribute="user" action="result.htm">
            <table>
                <tr>
                    <td><mvc:label path="name">Name</mvc:label></td>
                    <td><mvc:input path="name" cssErrorClass="formFieldError"/></td>
                    <td><mvc:errors path="name" /></td>
                </tr>
                <tr>
                    <td><mvc:label path="passwd">Password</mvc:label></td>
                    <td><mvc:password path="passwd" cssErrorClass="formFieldError" /></td>
                    <td><mvc:errors path="passwd" /></td>
                </tr>
                <tr>
                    <td><mvc:label path="passwd">Repeat password</mvc:label></td>
                    <td><mvc:password path="rpasswd" cssErrorClass="formFieldError" /></td>
                    <td><mvc:errors path="rpasswd" /></td>
                </tr>
                <tr>
                    <td><mvc:label path="email">E-Mail</mvc:label></td>
                    <td><mvc:input path="email" cssErrorClass="formFieldError" /></td>
                    <td><mvc:errors path="email" /></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="Submit" />
                    </td>
                </tr>
            </table>
        </mvc:form>
    </body>
</html>
