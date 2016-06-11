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

    .logo{
        left: 60px;
        position: relative;
        height: 75px;
        float: left;
        color: #ffffff;
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
        width: 28px;
        height: 4px;
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
        top: 15px;
    }


    .logout{
        font-size: 25px;
        display: block;
        margin-right: 30px;
        width: 30px;
        float: right;
        margin-top: 20px;
    }
    .logout a{

        color: #cfd2da;
    }
    .logout a:hover{
        color: #FCA311;

    }
</style>

<div class="header navbar-fixed-top" id="header">
        <div class="nav">
            <button class="btn-nav" title="Menu">
                <span class="icon-bar top"></span>
                <span class="icon-bar middle"></span>
                <span class="icon-bar bottom"></span>
            </button>
        </div>
    <div class="logo">ISC <small>the best Information System of control</small></div>

    <div class="logout" align="right">
        <span class="floatRight" title="Logout"><a title="Logout" href="<c:url value="/logout" />"><span class="glyphicon glyphicon-log-out"></span></a></span>
    </div>
</div>
<script>
    $(window).load(function() {
        $(".btn-nav").on("click tap", function() {
            $(".nav-content").toggleClass("showNav hideNav").removeClass("hidden");
            $(this).toggleClass("animated");
        });
    });
</script>

