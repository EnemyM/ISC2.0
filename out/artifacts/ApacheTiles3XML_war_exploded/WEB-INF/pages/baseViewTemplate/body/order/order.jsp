<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 16.03.2016
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>AngularJS $http Example</title>
  <style>
    .username.ng-valid {
      background-color: lightgreen;
    }
    .username.ng-dirty.ng-invalid-required {
      background-color: red;
    }
    .username.ng-dirty.ng-invalid-minlength {
      background-color: yellow;
    }

    .email.ng-valid {
      background-color: lightgreen;
    }
    .email.ng-dirty.ng-invalid-required {
      background-color: red;
    }
    .email.ng-dirty.ng-invalid-email {
      background-color: yellow;
    }

  </style>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="OrderController as ctrl">
  <div class="panel panel-default">
    <div class="panel-heading"><span class="lead">Create Order Form </span></div>
    <div class="formcontainer">
      <form:form method="post" modelAttribute="order" ng-submit="ctrl.submit()" name="orderForm" class="form-horizontal">
        <input type="hidden" ng-model="ctrl.order.id_order" />

        <%-- Products order: product,amount , prise--%>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="product">Products:  </label>
            <div class="col-md-7">
              <form:select ng-model="ctrl.orderProducts"
                           id="product" class="form-control input-sm"
                           placeholder="Choose product" path="product"
                           items="${products}" multiple="true" itemValue="id_product"
                           itemLabel="product_name"/>
              <div class="has-error" ng-show="orderForm.$dirty">
                <span ng-show="orderForm.product.$invalid">This field is invalid </span>
              </div>

              <label class="col-md-2 control-lable" for="amount_product"> Amount </label>
              <input type="text" ng-model="ctrl.orderAmount" id="amount_product" class="form-control input-sm" placeholder="Enter amount product"/>
              <div class="has-error" ng-show="orderForm.$dirty">
                <span ng-show="orderForm.orderAmount.$invalid">This field is invalid </span>
              </div>
              <a href="<c:url value="/countAmount/" />" class="btn btn-warning btn-sm">Prise</a><tr><td>${amount}</td></tr>

            </div>
          </div>
        </div>

        <%-- Time delivery--%>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="time_delivery">Time delivery</label>
            <div class="col-md-7">
              <input type="time" ng-model="ctrl.order.time_delivery" id="time_delivery" class="form-control input-sm" />
            </div>
          </div>
        </div>

        <%-- Place delivery--%>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="place_delivery">Time delivery</label>
            <div class="col-md-7">
              <input type="text" ng-model="ctrl.order.place_delivery" id="place_delivery" class="form-control input-sm"
                     placeholder="Input place delivery"/>
            </div>
          </div>
        </div>

        <%-- Total coast --%>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="price_order">Time delivery</label>
            <div class="col-md-7">
              <a href="<c:url value="/totalPrice"/> " class="btn btn-warning btn-sm"> Total Price </a>
              <div type="text" ng-model="ctrl.order.price_order" id="price_order" class="form-control input-sm"
                     placeholder="Input place delivery">${totalPrice}</div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="form-actions floatRight">
            <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
          </div>
        </div>
      </form:form>
    </div>
  </div>


<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/user_service.js' />"></script>
<script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
</body>
</html>
