<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 07.03.2016
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<center>
<div class="order" ng-app ="myApp">
  <div class="containerOrder" ng-controller="orderController as ctrl">
    <%--<div class="panelOrder">
      <div class="header"><span class="">Registration form </span></div>
      <div class="form">--%>
       <%-- <form ng-submit="ctrl.submit()" name="orderForm" class="">

          <div class="row">
            <div class="form-group col-md-12">
              <label class="col-md-2 control-lable" for="date_order"> Date order </label>
              <div class="col-md-7">
                <input type="date" ng-model="ctrl.order.date_order" id="date_order" class="date_order form-control input-sm" placeholder="Choose the order date"/>
                <div class="has-error" ng-show="orderForm.$dirty">
                  <span ng-show="orderForm.date_order.$error.required">This is a required field</span>
                  <span ng-show="orderForm.date_order.$invalid">This field is invalid </span>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="form-group col-md-12">
              <label class="col-md-2 control-lable" for="date_delivery"> Date order </label>
              <div class="col-md-7">
                <input type="date" ng-model="ctrl.order.date_delivery" id="date_delivery" class="date_delivery form-control input-sm" placeholder="Choose the order date delivery"/>
                <div class="has-error" ng-show="orderForm.$dirty">
                  <span ng-show="orderForm.date_delivery.$error.required">This is a required field</span>
                  <span ng-show="orderForm.date_delivery.$invalid">This field is invalid </span>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="form-group col-md-12">
              <label class="col-md-2 control-lable" for="time_delivery"> Date order </label>
              <div class="col-md-7">
                <input type="time" ng-model="ctrl.order.time_delivery" id="time_delivery" class="time_delivery form-control input-sm" placeholder="Choose the time delivery order"/>
                <div class="has-error" ng-show="orderForm.$dirty">
                  <span ng-show="orderForm.time_delivery.$error.required">This is a required field</span>
                  <span ng-show="orderForm.time_delivery.$invalid">This field is invalid </span>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="form-group col-md-12">
              <label class="col-md-2 control-lable" for="price_order"> Date order </label>
              <div class="col-md-7">
                <input type="text" ng-model="ctrl.order.price_order" id="price_order" class="price_order form-control input-sm" placeholder=""/>
                <div class="has-error" ng-show="orderForm.$dirty">
                  <span ng-show="orderForm.price_order.$error.required">This is a required field</span>
                  <span ng-show="orderForm.price_order.$invalid">This field is invalid </span>
                </div>
              </div>
            </div>
          </div>

        </form>--%>
         <div class="row">
           <div class="form-actions floatRight">
             <input type="submit"  value="Add" class="btn btn-primary btn-sm" <%--ng-disabled="registerForm.$invalid"--%>/>
             <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" <%--ng-disabled="registerForm.$pristine"--%>>Reset Form</button>
             <a class="btn btn-danger custom-width" href="<c:url value='/'/>"> Log in</a>
           </div>
         </div>

      <%--</div>
    </div>--%>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="<c:url value='/static/js/app.js' />"></script>
  <script src="<c:url value='/static/js/services/orderService.js' />"></script>
  <script src="<c:url value='/static/js/controllers/orderController.js' />"></script>
</div>
</center>