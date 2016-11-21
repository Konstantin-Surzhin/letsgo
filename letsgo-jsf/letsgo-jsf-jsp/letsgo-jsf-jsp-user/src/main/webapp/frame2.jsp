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
<f:view>
    <html>
        <body>
            <h:outputLink value="#{root}/jsf-jsp-City" target="_parent">Города</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-Degree" target="_parent">Разряды</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-Event" target="_parent">События</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-UserGame" target="_parent">Игры</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-GameMove" target="_parent">Ход игры</h:outputLink><br>     
            <h:outputLink value="#{root}/jsf-jsp-GameComment" target="_parent">Комментарии к игре</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-MoveComment" target="_parent">Комментарии к ходам</h:outputLink><br>            
            <h:outputLink value="#{root}/jsf-jsp-GameDate" target="_parent">Даты игры</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-Game" target="_parent">Игры</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-GameRule" target="_parent">Правила игры</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-League" target="_parent">Лиги</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-Place" target="_parent">Места</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-Room" target="_parent">Комнаты</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-UserBan" target="_parent">Блокировки игроков</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-UserDegree" target="_parent">Разряды игроков</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-User" target="_parent"  disabled="true">Игроки</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-UserRole" target="_parent">Роли игроков</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-Team" target="_parent">Команды</h:outputLink><br>
            <h:outputLink value="#{root}/jsf-jsp-Club" target="_parent">Клубы</h:outputLink><br>
            </body>
        </html>
</f:view>