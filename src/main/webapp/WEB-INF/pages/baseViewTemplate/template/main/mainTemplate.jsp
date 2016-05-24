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
    body,html{
      font-family: "Roboto", "Helvetica Neue", Helvetica, Arial, sans-serif;
      font-size: 14px;
      height: 100%;
      width: 100%;
      padding: 0;
      margin: 0;
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
      background: #252830;
    }
    #wrapper.menuDisplayed #sidebar-wrapper-list{
      width: 180px;
      text-align: center;
    }
    #wrapper.menuDisplayed #mainContent{
      padding-left: 250px;
    }
    .nav-content {
      position: fixed;
      top: -100%;
      bottom: 0;
      left: 0;
      right: 0;
      background-color: rgba(0,0,0,.8);
      display: block;
      height: 100%;
      z-index: 9;
    }

    .nav-list {
      list-style: none;
      padding: 0;
      position: relative;
      top: 30%;
    }

    .item-anchor:after {
      content: "";
      position: absolute;
      width: 3px;
      height: 3px;
      left: 0;
      bottom: 0;
      z-index: 9;
      background: transparent;
      -webkit-transition: all 1s ease;
      -moz-transition: all 1s ease;
      -ms-transition: all 1s ease;
      -o-transition: all 1s ease;
      transition: all 1s ease;
    }

    .item-anchor {
      color: #fff;
      font-size: 30px;
      text-transform: uppercase;
      position: relative;
      text-decoration: none;
      padding: 10px;
    }

    .item-anchor:hover,
    .item-anchor:focus {
      color: #FCA311;
      -webkit-transition: all 1s ease;
      -moz-transition: all 1s ease;
      -ms-transition: all 1s ease;
      -o-transition: all 1s ease;
      transition: all 1s ease;
    }

    .item-anchor:hover:after,
    .item-anchor:focus:after{
      width: 100%;
      background: #FCA311;
      -webkit-transition: all 1s ease;
      -moz-transition: all 1s ease;
      -ms-transition: all 1s ease;
      -o-transition: all 1s ease;
      transition: all 1s ease;
    }

    .nav-item {
      margin: 40px auto;
      text-align: center;
    }

    .animated {
      display: block;
      margin: 0 auto;
    }

    .animated:hover .icon-bar,
    .animated:focus .icon-bar{
      background-color: #FCA311;
    }

    .animated:focus {
      cursor: pointer;
      z-index: 9999;
    }

    .middle {
      margin: 0 auto;
    }

    .icon-bar {
      -webkit-transition: all .7s ease;
      -moz-transition: all .7s ease;
      -ms-transition: all .7s ease;
      -o-transition: all .7s ease;
      transition: all .7s ease;
      z-index: 999999;
    }

    .animated .icon-bar {
      z-index: 999999;
      background-color: #FCA311;
    }

    .animated .top {
      -webkit-transform: translateY(10px) rotateZ(45deg);
      -moz-transform: translateY(10px) rotateZ(45deg);
      -ms-transform: translateY(10px) rotateZ(45deg);
      -o-transform: translateY(10px) rotateZ(45deg);
      transform: translateY(10px) rotateZ(45deg);
    }

    .animated .bottom {
      -webkit-transform: translateY(-11px) rotateZ(-45deg);
      -moz-transform: translateY(-11px) rotateZ(-45deg);
      -ms-transform: translateY(-11px) rotateZ(-45deg);
      -o-transform: translateY(-11px) rotateZ(-45deg);
      transform: translateY(-11px) rotateZ(-45deg);
    }

    .animated .middle {
      width: 0;
    }

    @keyframes showNav {
      from {
        top: -100%;
      }
      to {
        top: 0;
      }
    }

    @-webkit-keyframes showNav {
      from {
        top: -100%;
      }
      to {
        top: 0;
      }
    }

    @-moz-keyframes showNav {
      from {
        top: -100%;
      }
      to {
        top: 0;
      }
    }

    @-o-keyframes showNav {
      from {
        top: -100%;
      }
      to {
        top: 0;
      }
    }

    .showNav {
      -webkit-animation: showNav 1s ease forwards;
      -moz-animation: showNav 1s ease forwards;
      -o-animation: showNav 1s ease forwards;
      animation: showNav 1s ease forwards;
    }

    @keyframes hideNav {
      from {
        top: 0;
      }
      to {
        top: -100%;
      }
    }

    @-webkit-keyframes hideNav {
      from {
        top: 0;
      }
      to {
        top: -100%;
      }
    }

    @-moz-keyframes hideNav {
      from {
        top: 0;
      }
      to {
        top: -100%;
      }
    }

    @-o-keyframes hideNav {
      from {
        top: 0;
      }
      to {
        top: -100%;
      }
    }

    .hideNav {
      -webkit-animation: hideNav 1s ease forwards;
      -moz-animation: hideNav 1s ease forwards;
      -o-animation: hideNav 1s ease forwards;
      animation: hideNav 1s ease forwards;
    }

    .hidden {
      display: none;
    }

    h1 { position:absolute; top:100px; left:100px; color:#fff;}
    /* scroll style*/
    ::-webkit-scrollbar {
      width: 12px;
    }
    ::-webkit-scrollbar-track {
      -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
      border-radius: 10px;
    }
    ::-webkit-scrollbar-thumb {
      border-radius: 10px;
      -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.5);
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
      <%--<!--Sidebar content-->
      <div class="sidebar">
        <div class="sidebar-wrapper" id="sidebar-wrapper">
          <tiles:insertAttribute name="menu"/>
        </div>
        <div class="sidebar-wrapper-list" id="sidebar-wrapper-list">
          <tiles:insertAttribute name="menuList"/>
        </div>
      </div>--%>
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
  <div class="nav-content hideNav hidden">
    <ul class="nav-list">
      <li class="nav-item"><a href="<c:url value="/order"/>" title="Order" class="item-anchor">Order</a></li>
      <li class="nav-item"><a href="<c:url value="/statistic"/> " title="Statistic" class="item-anchor">Statistic</a></li>
      <li class="nav-item"><a href="<c:url value="/history"/>" class="item-anchor">History</a></li>
      <li class="nav-item"><a href="#" class="item-anchor">Settings</a></li>
    </ul>
  </div>
  <script>
    $(window).load(function() {
      $(".btn-nav").on("click tap", function() {
        $(".nav-content").toggleClass("showNav hideNav").removeClass("hidden");
        $(this).toggleClass("animated");
      });
    });
  </script>
</body>
</html>
