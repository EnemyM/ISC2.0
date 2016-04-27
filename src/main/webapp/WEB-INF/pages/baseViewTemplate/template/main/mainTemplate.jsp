<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title><tiles:getAsString name="title"/></title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  <link href="<c:url value='/static/css/template/templateStyle.css' />" rel="stylesheet"/>
  <script src="<c:url value="/static/js/content/menu.js"/>" ></script>
  <style>
    body{
      font-family: "Roboto", "Helvetica Neue", Helvetica, Arial, sans-serif;
      font-size: 14px;
    }
    .header{
      border: 1px solid black;
      width: 100%;
      height:75px;
      background: #252830;
    }
    .sidebar-wrapper{

    }
    .sidebar-wrapper{
      top: 75px;
      z-index: 1;
      position: fixed;
      overflow-y: hidden;
      width: 70px;
      height: 100%;
      border: 1px solid black;
      bottom: 0;
      left: 0;
      padding-left: 0;
      background-color: #30343e;
      float: left;
    }
    .sidebar-wrapper-list{
      top: 75px;
      width: 0;
      z-index: 2;
      position: fixed;
      overflow-y: hidden;
      height: 100%;
      bottom: 0;
      left: 70px;
      padding-left: 0;
      background-color: #30343e;
      float: left;
    }
    .content{
      width: 100%;
      position: absolute;
      border: 1px solid black;
      padding-left: 70px;
      background: #252830;
    }
    #wrapper.menuDisplayed #sidebar-wrapper-list{
      width: 180px;
      text-align: center;
    }
    #wrapper.menuDisplayed #mainContent{
      padding-left: 250px;
    }
  </style>
</head>
<body>
  <div class="wrapper" id="wrapper">
    <%-- header--%>
    <div class="header">
      <div class="headerCon">
          <tiles:insertAttribute name="header"/>
      </div>
    </div>
      <!--Sidebar content-->
      <div class="sidebar">
        <div class="sidebar-wrapper" id="sidebar-wrapper">
          <tiles:insertAttribute name="menu"/>
        </div>
        <div class="sidebar-wrapper-list" id="sidebar-wrapper-list">
          <tiles:insertAttribute name="menuList"/>
        </div>
      </div>
        <!--Body content-->
        <div class="content" id="mainContent">
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
