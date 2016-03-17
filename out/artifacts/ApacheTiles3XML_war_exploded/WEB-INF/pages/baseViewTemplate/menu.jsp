<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 07.03.2016
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
<div <%--class="sidebar-wrapper"--%>>
  Menu
  <ul <%--class="sidebar-nav"--%>>
    <li><a href="<c:url value="/firstPage"/> " > First Page</a></li>
    <li><a href="<c:url value="/secondPage"/> " > Second Page</a></li>
  </ul>
</div>
