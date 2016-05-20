<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 07.03.2016
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv = "Content-Type" content="text/html; charset = UTF-8">

  <link href="<c:url value='/static/css/registration' />" rel="stylesheet"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
  <link href="<c:url value='/static/css/bootstrap.main.css' />" rel="stylesheet"/>

  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
  <script src="<c:url value='/static/js/app.js' />"></script>
  <script src="<c:url value='/static/js/services/order/order_service.js' />"></script>
  <script src="<c:url value='/static/js/controllers/order/order_controller.js' />"></script>

</head>
<body ng-app ="myApp" class="ng-cloak">
  <div class="generic-container" ng-controller="OrderController as ctrl">
    <div class="panel panel-default">
      <div class="panel-heading"><span class="lead">Order form </span></div>
      <div class="formcontainer">
      <form class="form-horizontal" ng-submit="ctrl.submit()" name="orderForm">

          <div class="row">
            <div class="form-group col-md-12">
              <label class="col-md-2 control-lable" for="date_order"> Date order </label>
              <div class="col-md-7">
                <input type="date" ng-model="ctrl.order.date_order" id="date_order" class="form-control input-sm"/>
                <div class="has-error" ng-show="orderForm.$dirty">
                  <span ng-show="orderForm.date_order.$error.required">This is a required field</span>
                  <span ng-show="orderForm.date_order.$invalid">This field is invalid </span>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="form-group col-md-12">
              <label class="col-md-2 control-lable" for="date_delivery"> Date delivery </label>
              <div class="col-md-7">
                <input type="date" ng-model="ctrl.order.date_delivery" id="date_delivery" class="form-control input-sm" placeholder="Choose the order date delivery"/>
                <div class="has-error" ng-show="orderForm.$dirty">
                  <span ng-show="orderForm.date_delivery.$error.required">This is a required field</span>
                  <span ng-show="orderForm.date_delivery.$invalid">This field is invalid </span>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="form-group col-md-12">
              <label class="col-md-2 control-lable" for="time_delivery"> Time delivery </label>
              <div class="col-md-7">
                <input type="time" ng-model="ctrl.order.time_delivery" id="time_delivery" class="form-control input-sm" placeholder="Choose the time delivery order"/>
                <div class="has-error" ng-show="orderForm.$dirty">
                  <span ng-show="orderForm.time_delivery.$error.required">This is a required field</span>
                  <span ng-show="orderForm.time_delivery.$invalid">This field is invalid </span>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="form-group col-md-12">
              <label class="col-md-2 control-lable" for="price_order"> Prise order </label>
              <div class="col-md-7">
                <input type="text" ng-model="ctrl.order.price_order" id="price_order" class="price_order form-control input-sm"/>
                <div class="has-error" ng-show="orderForm.$dirty">
                  <span ng-show="orderForm.price_order.$error.required">This is a required field</span>
                  <span ng-show="orderForm.price_order.$invalid">This field is invalid </span>
                </div>
              </div>
            </div>
          </div>

         <div class="row">
           <div class="form-actions floatRight">
             <input type="submit"  value="Add" class="btn btn-primary btn-sm" ng-disabled="orderForm.$invalid"/>
             <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="orderForm.$pristine">Reset Form</button>

           </div>
         </div>

        </form>
      </div>
    </div>
  </div>

</body>
</html>
