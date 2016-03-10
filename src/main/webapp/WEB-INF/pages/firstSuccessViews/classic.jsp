<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 06.03.2016
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title><tiles:getAsString name="title"/></title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link href="<c:url value='/static/css/bootstrap.main.css' />" rel="stylesheet"/>
</head>
<body>

<h1>Main page</h1>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span2">
      <!--Sidebar content-->
      <tiles:insertAttribute name="menu" />
    </div>
    <div class="span10">
      <!--Body content-->
      <%--<tiles:insertAttribute name="header" />--%>
      <tiles:insertAttribute name="body" />
      <tiles:insertAttribute name="footer"/>
    </div>
  </div>
</div>
</body>
</html>
