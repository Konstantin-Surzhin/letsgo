<%-- 
    Document   : frame1
    Created on : 13.10.2016, 15:11:07
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
            <title>Top</title>
        </head>
        <body>
            <h1>
                <h:outputText value="#{cityManagedBean.pageTitle}"/></h1>
        </body>
    </html>
</f:view>