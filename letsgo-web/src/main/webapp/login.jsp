<%-- 
    Document   : login
    Created on : 24.05.2016, 9:43:15
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page!</h1>
        <form method="POST" action="j_security_check">
            <input type="text" name="j_username"><br/>
            <input title="login:" type="password" name="j_password"><br/>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
