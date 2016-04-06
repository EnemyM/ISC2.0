<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="<c:url value='/static/js/app.js' />"></script>
  <script src="<c:url value='/static/js/services/order/product_order_service.js' />"></script>
  <script src="<c:url value='/static/js/controllers/order/product_order_controller.js' />"></script>
  <link rel="stylesheet" href="<c:url value="/static/css/order/orderPageStyle.css"/> "/>
</head>
<body ng-app="myApp" ng-controller="ProductController as ctr">
<div class="container-fluid">
  <div class="row">
    <div class="orderMap col-lg-12 col-md-10 col-sm-12"></div>
    <div class="productOrder col-lg-4 col-md-5 col-sm-4">
      <%--Top add the product, its amount --%>
        <div class="topAddForm">
          <div><span> Add Products </span></div>
          <form ng-submit="ctr.submit()" name="productForm">
            <div>
              <input type="hidden" ng-model="ctr.product_order.id_product_order" />
              <select ng-model="ctr.product_order.product_name" required="true" width="20px">
                <option value="">Choose the product</option>
                <c:forEach items="${products}" var="product">
                  <option>${product.product_name}</option>
                </c:forEach>
              </select>
              <input type="text" ng-model="ctr.product_order.amount_product" placeholder="Amount" required="true" size="5px">
              <input type="submit" value="+" ng-disabled="productForm.$invalid">
            </div>
          </form>
        </div>
        <%-- Dow list of the shosen product --%>
        <div class="panel panel-default">
          <div class="tablecontainer">
            <%--<div>
              <c:forEach items="${productsOrder}" var="product_order">
                <tr>
                  <td>${product_order.amount_product}</td>
                </tr>
              </c:forEach>
            </div>--%>
            <table class="table table-hover">
                <%--Head panel--%>
                <thead>
                  <tr>
                    <th>Product</th>
                    <th>Amount</th>
                    <th>Price</th>
                    <th></th>
                  </tr>
                </thead>
                <%--Content table--%>
                <tbody>
                  <tr ng-repeat="u in ctr.products_order">
                    <td><span ng-bind="u.product_name"></span></td>
                    <td><span ng-bind="u.amount_product"></span></td>
                    <td><span ng-bind="u.price_amount"></span></td>
                    <td><button type="button">+/-</button> <button type="button">-</button></td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
      </div>
    <div class="orderInf col-lg-4 col-md-5 col-sm-4 ">
      <div><span> Order </span></div>
      <form name="orderForm">
        <input type="hidden" ng-model="id_order">
        <div>
          <label>Date delivery</label><br>
          <input type="date" required="true" ng-model="ctr.order.date_delivery">
        </div><br>
        <div>
          <label>Time delivery</label><br>
          <input type="time" required="true" ng-model="ctr.order.time_delivery">
        </div><br>
        <div>
          <label>Transport</label><br>
          <select ng-model="ctr.order.transport" required="true">
            <option value="">Choose the transport</option>
            <c:forEach items="${transports}" var="transport">
              <option>${transport.name_transport}</option>
            </c:forEach>
          </select>
        </div><br>
        <button ng-click="create()">Create</button>
      </form>
    </div>
    <div class="orderTr col-lg-4 col-md-10 col-sm-4 "></div>
  </div>
</div>
</body>
</html>
