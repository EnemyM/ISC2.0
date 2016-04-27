<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
<script src="<c:url value="/static/js/content/menu.js"/>" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="<c:url value="/static/js/content/jqueryrotate.2.1.js"/> "></script>
<script>
    $("#glyphicon-leaf").click(function(e){
        e.preventDefault();
        $("#header").toggleClass("rotateBtn");
    });
</script>
<style>
    .leaf{
        float: left;
    }
    .leafbtn{
        display: block;
        width: 70px;
        height: 75px;
        position: relative;
        font-size: 30px;
        padding-top: 20px;
        padding-bottom: 20px;
        line-height: 1;
        color: #6f7890;
        text-align: center;
        border-bottom: 0;
        background-color: #0f1013;
    }
    .logo{
        padding: 20px;
        height: 75px;
        float: left;
        color: #ffffff;
    }
    .leafbtn:hover{
        color: #6db33f;
        text-decoration: none;
    }

    .glyphicon-leaf:hover{
        -moz-transform: rotate(15deg); /* Для Firefox */
        -ms-transform: rotate(15deg); /* Для IE */
        -webkit-transform: rotate(15deg); /* Для Safari, Chrome, iOS */
        -o-transform: rotate(15deg); /* Для Opera */
        transform: rotate(15deg);
    }
</style>

<div class="header navbar-fixed-top" id="header">
    <div class="leaf" id="leaf">
        <a class="leafbtn" id="menu-toggle">
            <span class="glyphicon glyphicon-leaf" id="glyphicon-leaf"></span>
        </a>
    </div>
    <div class="logo">ISC the best Information System of control</div>
</div>
