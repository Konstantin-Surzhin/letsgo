<%-- 
    Document   : frame3
    Created on : 13.10.2016, 15:13:59
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        </head>
        <body>
            <h2>Список городов</h2>

            <h:form>
                <h:outputLabel value="Название города"/>
                <h:inputText id="cityName" value="#{cityManagedBean.cityName}"/>
                <h:commandButton value="добавить" action="#{cityManagedBean.addCity}"/>
            </h:form>
            <h:form>
                 <h:outputLabel value="Выбрать город"/>
                 <h:selectOneListbox value="#{cityManagedBean.cityList}" >
                     
                 </h:selectOneListbox>
            </h:form>
        </body>
    </html>
</f:view>