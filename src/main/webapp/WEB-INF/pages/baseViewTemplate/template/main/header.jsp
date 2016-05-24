<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
<script src="<c:url value="/static/js/content/menu.js"/>" ></script>
<script src="<c:url value="/static/js/content/fullScreenMenu.js"/>" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="<c:url value="/static/js/content/jqueryrotate.2.1.js"/> "></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script>
    $("#glyphicon-leaf").click(function(e){
        e.preventDefault();
        $("#header").toggleClass("rotateBtn");
    });
</script>
<style>
    @import url(https://fonts.googleapis.com/css?family=roboto);
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
        left: 50px;
        position: relative;
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

    .nav {
        position: relative;
        width: auto;
        display: inline-block;
        border: none;
    }

    .btn-nav {
        position: fixed;
        top: 5px;
        left: 5px;
        background: transparent;
        border: none;
        padding: 10px;
        -webkit-transition: all .5s ease;
        -moz-transition: all .5s ease;
        -ms-transition: all .5s ease;
        -o-transition: all .5s ease;
        transition: all .5s ease;
        cursor: pointer;
        z-index: 99999;
    }

    .btn-nav:focus {
        outline: 0;
    }

    .icon-bar {
        display: block;
        margin: 6px 0;
        width: 30px;
        height: 5px;
        background-color: #FFFFFF;
    }

    .btn-nav:hover .icon-bar {
        -webkit-transition: all 1s ease;
        -moz-transition: all 1s ease;
        -ms-transition: all 1s ease;
        -o-transition: all 1s ease;
        transition: all 1s ease;
        background-color: #FCA311;
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
    .logo{
        font-size: 30px;
    }
</style>

<div class="header navbar-fixed-top" id="header">
    <%--<div class="leaf" id="leaf">
        <a class="leafbtn" id="menu-toggle">
            <span class="glyphicon glyphicon-leaf" id="glyphicon-leaf"></span>
        </a>
    </div>--%>
        <div class="nav">
            <button class="btn-nav">
                <span class="icon-bar top"></span>
                <span class="icon-bar middle"></span>
                <span class="icon-bar bottom"></span>
            </button>
        </div>
    <div class="logo">ISC the best Information System of control</div>

</div>
<script>
    $(window).load(function() {
        $(".btn-nav").on("click tap", function() {
            $(".nav-content").toggleClass("showNav hideNav").removeClass("hidden");
            $(this).toggleClass("animated");
        });
    });
</script>

