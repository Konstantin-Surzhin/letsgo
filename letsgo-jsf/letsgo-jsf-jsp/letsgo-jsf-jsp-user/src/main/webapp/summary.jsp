<%-- 
    Document   : summary
    Created on : 17.11.2016, 17:34:59
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <f:view>  
        <body>
            <div>
                <h2>Общая информация по игрокам!</h2>
                <h3>Список Игроков</h3>
                <h:form>
                    <h:outputLabel value="Выбрать игрока"/>
                    <h:selectOneMenu value="#{userManagedBean.userCode}" >  
                        <c:forEach items="#{userManagedBean.userList}" var="user">
                            <f:selectItem itemValue="#{user.id}" itemLabel="#{user.userName}"/>
                        </c:forEach>
                    </h:selectOneMenu>
                    <h:commandButton value="Выбрать" action="#{userManagedBean.addUser}" />
                </h:form>
            </div>
            <table border="1">
                <tr>
                    <td>Прозвище</td>
                    <td>Город</td>
                    <td>Клуб</td>
                    <td>Команда</td>
                    <td>Лига</td>
                    <td>Комната</td>
                    <td>Разряд</td>
                    <td>Рейтинг</td>
                    <td>Игры</td>
                    <td>Комментарии</td>
                </tr>
                <tr>
                    <td><h:outputLink value="profile.jsp?user=blackCat">blackCat</h:outputLink></td>
                    <td><h:outputLink value="#{root}/jsf-jsp-City?city=moscow" target="_parent">Москва</h:outputLink></td>
                    <td><h:outputLink value="#{root}/jsf-jsp-Club?city=moscow&amp;club=CatAdDog" target="_parent">Cat And Dog</h:outputLink></td>
                    <td><h:outputLink value="#{root}/jsf-jsp-Team?city=moscow&amp;team=cat" target="_parent">Cat</h:outputLink></td>
                    <td><h:outputLink value="#{root}/jsf-jsp-League?city=moscow&amp;league=A" target="_parent">Лига A</h:outputLink></td>
                    <td><h:outputLink value="#{root}/jsf-jsp-Team?city=moscow&amp;room=red" target="_parent">Red</h:outputLink></td>
                    <td><h:outputLink value="#{root}/jsf-jsp-UserDegree?user=blackCat" target="_parent">20k</h:outputLink></td>
                    <td><h:outputLink value="#{root}/jsf-jsp-UserRating?user=blackCat" target="_parent">5888</h:outputLink></td>
                    <td><h:outputLink value="#{root}/jsf-jsp-UserGame?user=blackCat" target="_parent">Игры</h:outputLink></td>
                    <td><h:outputLink value="#{root}/jsf-jsp-UserComment?user=blackCat" target="_parent">Комментарии</h:outputLink></td>
                    </tr>
                </table>
            </body>
    </f:view>  
</html>
