<%-- 
    Document   : frame1
    Created on : 13.10.2016, 15:11:07
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html>
    <f:view>   
        <head>
            <title>Top</title>
        </head>
        <body>
            <h1><h:outputText value="#{cityManagedBean.pageTitle}"/></h1>
        </body>
    </f:view>   
</html>
