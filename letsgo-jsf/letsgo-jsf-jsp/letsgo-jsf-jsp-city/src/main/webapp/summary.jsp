<%-- 
    Document   : summary
    Created on : 17.11.2016, 17:34:59
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <f:view>  
        <head>
            <title>JSP Page</title>
        </head>
        <body>
            <div>
                <h2>Общая информация по городам!</h2>
                <h3>Список городов</h3>
                <h:form>
                    <h:outputLabel value="Выбрать город"/>
                    <h:selectOneMenu value="#{cityManagedBean.cityCode}" >  
                        <c:forEach items="#{cityManagedBean.cityList}" var="city">
                            <f:selectItem itemValue="#{city.id}" itemLabel="#{city.cityName}"/>
                        </c:forEach>
                    </h:selectOneMenu>
                    <h:commandButton value="Выбрать" action="#{cityManagedBean.addCity}" />
                </h:form>
            </div>
            <table border="1">
                <tr>
                    <td colspan="2">Лиги города</td>
                </tr>
                <tr>
                    <td>Название</td>
                    <td>Число комманд в лиге</td>
                </tr>
                <tr>
                    <td>Городская лига "А"</td>
                    <td>2</td>
                </tr>
                <tr>
                    <td>Городская лига "Б"</td>
                    <td>2</td>
                </tr>
                <tr>
                    <td>Городская лига "В"</td>
                    <td>2</td>
                </tr>
            </table>
            <br/>
            <table border="1">
                <tr>
                    <td colspan="2">Список клубов</td>
                </tr>
                <tr>
                    <td>Название</td>
                    <td>Число комманд в клубе</td>
                </tr>
                <tr>
                    <td>Белый камень</td>
                    <td>5</td>
                </tr>
            </table>
            <br/>
            <table border="1">
                <tr>
                    <td colspan="2">Список команд</td>
                </tr>
                <tr>
                    <td>Название</td>
                    <td>Число человек в команде</td>
                </tr>
                <tr>
                    <td>Белый камень - мужики</td>
                    <td>5</td>
                </tr>
                <tr>
                    <td>Белый камень - бабы</td>
                    <td>5</td>
                </tr>
                <tr>
                    <td>Белый камень - молодежка</td>
                    <td>5</td>
                </tr>
                <tr>
                    <td>Белый камень - ветераны</td>
                    <td>5</td>
                </tr>
            </table>
            <br/>
            <table border="1">
                <tr>
                    <td colspan="2">Список комнат</td>
                </tr>
                <tr>
                    <td>Название</td>
                    <td>Число человек в комнате</td>
                </tr>
            </table>
            <br/>
            <table border="1">
                <tr>
                    <td colspan="7">Список игроков</td>
                </tr>
                <tr>
                    <td>Прозвище</td>
                    <td>Разряд</td>
                    <td>Рейтинг</td>
                    <td>Выиграл</td>
                    <td>Ничья</td>
                    <td>Проиграл</td>
                    <td>Удрал</td>
                </tr>
            </table>
            <br/>
            <table border="1">
                <tr>
                    <td colspan="8">Сыграино партий</td>
                </tr>
                <tr>
                    <td>Код партии</td>
                    <td>Белые</td>
                    <td>Разряд</td>
                    <td>Рейтинг</td>
                    <td>Черные</td>
                    <td>Разряд</td>
                    <td>Рейтинг</td>
                    <td>Результат</td>
                </tr>
            </table>
        </body>
    </f:view>  
</html>
