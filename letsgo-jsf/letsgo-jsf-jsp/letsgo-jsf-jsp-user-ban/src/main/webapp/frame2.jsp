<%-- 
    Document   : frame1
    Created on : 13.10.2016, 15:11:07
    Author     : surzhin.konstantin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="#{request.scheme}://#{request.serverName}:#{request.serverPort}"/>
<f:subview id="menu">
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
        <h:outputLink value="#{root}/jsf-jsp-City" target="_parent">City</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-Degree" target="_parent">Degrees</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-Event" target="_parent">Events</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-GameComment" target="_parent">Game comments</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-GameDate" target="_parent">Game dates</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-GameMove" target="_parent">Game moves</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-Game" target="_parent">Games</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-GameRule" target="_parent">Games rules</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-League" target="_parent">Leagues</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-MoveComment" target="_parent">Move comments</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-Place" target="_parent">Places</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-Room" target="_parent">Rooms</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-UserBan" target="_parent" disabled="true">User bans</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-UserDegree" target="_parent">User degrees</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-User" target="_parent">Users</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-UserRole" target="_parent">User roles</h:outputLink><br>
        <h:outputLink value="#{root}/jsf-jsp-Team" target="_parent">Teams</h:outputLink><br>
        </body>
    </html>
</f:subview>