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

<html>
    <f:view>     
        <head>
            <title>Управление городами</title>
        </head>
        <body>
            <h2>Здесь можно добавить город.</h2>
            <h:form>
                <h:selectOneRadio value="#{cityManagedBean.techMetod}">
                    <f:selectItem itemValue="ejb" itemLabel="EJB3"/>
                    <f:selectItem itemValue="rest" itemLabel="REST"/>
                    <f:selectItem itemValue="soap" itemLabel="SOAP"/>
                    <f:selectItem itemValue="rpc" itemLabel="RPC"/>
                    <f:selectItem itemValue="mq" itemLabel="MQ"/>
                    <f:selectItem itemValue="jms" itemLabel="JMS"/>
                </h:selectOneRadio><br/>
                <h:selectOneRadio value="#{cityManagedBean.msgMediaType}">
                    <f:selectItem itemValue="text/plain" itemLabel="Text"/>
                    <f:selectItem itemValue="application/json" itemLabel="JSON"/>
                    <f:selectItem itemValue="application/xml" itemLabel="XML"/>
                    <f:selectItem itemValue="application/x-protobuf" itemLabel="PROTOBUF"/>
                    <f:selectItem itemValue="application/x-thrift" itemLabel="Thrift"/>
                </h:selectOneRadio><br/>
                <h:selectOneRadio value="#{cityManagedBean.persistenceType}">
                    <f:selectItem itemValue="jdbc" itemLabel="JDBC"/>
                    <f:selectItem itemValue="jpa" itemLabel="JPA"/>
                    <f:selectItem itemValue="openjpa" itemLabel="openJPA"/>
                    <f:selectItem itemValue="activejpa" itemLabel="activeJPA"/>
                    <f:selectItem itemValue="ebean" itemLabel="Ebean"/>
                    <f:selectItem itemValue="datanucleus" itemLabel="DataNucleus"/>
                    <f:selectItem itemValue="eclipselink" itemLabel="EclipseLink"/>
                    <f:selectItem itemValue="hibernate" itemLabel="Hibernate"/>
                    <f:selectItem itemValue="mybatis" itemLabel="myBatis"/>
                    <f:selectItem itemValue="springjdbc" itemLabel="Spring JDBC"/>
                    <f:selectItem itemValue="springdata" itemLabel="Spring Data"/>
                </h:selectOneRadio><br/>
                <h:selectOneRadio value="#{cityManagedBean.dbName}">
                    <f:selectItem itemValue="h2" itemLabel="H2"/>
                    <f:selectItem itemValue="mysql" itemLabel="MySql"/>
                    <f:selectItem itemValue="postgresql" itemLabel="PostgreeSQL"/>
                    <f:selectItem itemValue="derby" itemLabel="Derby"/>
                    <f:selectItem itemValue="db2" itemLabel="DB2"/>
                </h:selectOneRadio><br/>
                <h:outputLabel value="Название города: "/>
                <h:inputText id="cityName" value="#{cityManagedBean.cityName}"/>
                <h:commandButton value="добавить" action="#{cityManagedBean.addCity}"/>
            </h:form><br/>

        </body>
    </f:view>  
</html>
