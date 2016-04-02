<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 07.03.2016
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
  <link href="<c:url value='/static/css/mainTemplate/templateStyle.css' />" rel="stylesheet"/>

</head>
<body>
  <div>
    <%-- header--%>
    <div class="header">
      <div class="headerCon">
        <h3 class="">
          <tiles:insertAttribute name="header"/>
        </h3>
      </div>
    </div>
    <!--Sidebar content-->
    <div class="sidebar-wrapper">
        <tiles:insertAttribute name="menu"/>
    </div>

    <!--Body content-->
    <div class="content">
      <div class="container-fluid">
          <%--main content--%>
        <div class="mainContent">
          <div class="body">
            <tiles:insertAttribute name="body"/>
          </div>
          <div class="footer">
            <tiles:insertAttribute name="footer"/>
          </div>
        </div>

      </div>
    </div>
  </div>
</body>
</html>
