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
  <%--<link href="<c:url value='/static/css/bootstrap.main.css' />" rel="stylesheet"/>--%>
  <style>
    body{
      margin: 0;
      padding: 0;
    }
    .header{
      position: absolute;
      width: 100%;
      height: 50px;
      padding-left: 250px;
      /*box-sizing: border-box;*/
      border: 1px solid black;
      z-index: 3;
    }
    .sidebar-wrapper{
      z-index: 4;
      position: absolute;
      width: 250px;
      height: 100%;
      padding-top: 50px;
      border: 1px solid black;
    }
    .content{
      position: absolute;
      width: 100%;
      height: 100%;
      padding-top: 50px;
      padding-left: 250px;
    }
    .container-fluid{
      border: 1px solid black;
    }

  </style>
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
