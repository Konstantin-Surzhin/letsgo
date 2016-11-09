<%-- 
 Copyright (C) 2016 surzhin.konstantin

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${head}</title>
    </head>
    <body>
        <h1>${head}</h1>

        <form:form method="POST" acceptCharset="UTF-8" modelAttribute="city" >
            <form:label path="cityName">${message}</form:label>
            <form:input path="cityName" />
            <input type="submit" value="${submit}" />
        </form:form>
    </body>
</html>
