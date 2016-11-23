<%-- 
    Document   : index
    Created on : 23.11.2016, 9:54:39
    Author     : pl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User registration page</title>
    </head>
    <body>
        <h1>Login</h1>
    </body>
    <form method="post" title="login">
        <label>Login(nikname)</label>
        <input type="text" value="" name="login" id="login"/><br/>
        <label>password</label>
        <input type="password" value="" name="passwd" id="passwd"/><br/>
        <input type="submit" value="Submit"/>
        <input type="reset"/>
    </form>
    <a href="newUser.jsp">New User</a>
</html>
