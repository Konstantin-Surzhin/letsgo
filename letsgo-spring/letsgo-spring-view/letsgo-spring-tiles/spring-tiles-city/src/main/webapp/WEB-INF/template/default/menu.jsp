<!--
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
-->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/home.htm" var="homeUrl" htmlEscape="true"/>
<spring:url value="/about.htm" var="aboutUrl" htmlEscape="true"/>
<div class="menu">
Menu
    <ul>
        <li>
            <a href="${homeUrl}">Home</a>
        </li>
        <li>
            <a href="${aboutUrl}">About</a>
        </li>
    </ul>
</div>
