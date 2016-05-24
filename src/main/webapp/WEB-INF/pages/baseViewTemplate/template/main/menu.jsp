<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="<c:url value="/static/js/content/fullScreenMenu.js"/>" ></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
  @import url(https://fonts.googleapis.com/css?family=roboto);
  .ch{
    background-color: #30343e;
  }
  .nav-i{
    margin-bottom: 0;
    padding-left: 0;
    list-style: none;
  }
  .nav-i  li  a{
    color: #cfd2da;
    text-decoration: none;
    position: relative;
    font-size: 18px;
    display: block;
    text-align: center;
    border-radius: 0;
    padding: 15px;
  }
  .nav-i  li a:hover, a:focus{
    background-color: #6f7890;
  }
  .nav-i > li + li >  a{
    border-top: 1px solid #252830;
    border-right: 0;
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
  .jquery-script-ads { position:absolute; top:200px; left:100px;}

</style>
<div class="nav-content hideNav hidden">
  <ul class="nav-list">
    <li class="nav-item"><a href="<c:url value="/order"/>" title="Order" class="item-anchor">Order</a></li>
    <li class="nav-item"><a href="<c:url value="/secondPage"/> " title="Statistic" class="item-anchor">Statistic</a></li>
    <li class="nav-item"><a href="#" class="item-anchor">History</a></li>
    <li class="nav-item"><a href="#" class="item-anchor">Settings</a></li>
  </ul>
</div>
<%--
<div class="ch" id="menu-wrapper">
  <div class="icon-nav" id="icon-nav">
    <ul class="nav-i">
      <li>
        <a href="<c:url value="/order"/>" title="Order" class="frs-p">
          <span class="glyphicon glyphicon-list-alt"></span>
        </a>
      </li>
      <li>
        <a href="<c:url value="/secondPage"/> " title="Statistic" class="scd-p">
          <span class="glyphicon glyphicon-stats"></span>
        </a>
      </li>
    </ul>
  </div>
</div>
--%>
