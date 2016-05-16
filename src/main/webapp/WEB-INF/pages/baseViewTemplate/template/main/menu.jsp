<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

<style>
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

</style>
<div class="ch" id="menu-wrapper">
  <div class="icon-nav" id="icon-nav">
    <ul class="nav-i">
      <li>
        <a href="<c:url value="/order"/> " title="Order" class="frs-p">
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
