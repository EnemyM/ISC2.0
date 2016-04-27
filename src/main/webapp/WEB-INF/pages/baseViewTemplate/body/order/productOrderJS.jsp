<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="<c:url value='/static/js/app.js' />"></script>
  <script src="<c:url value='/static/js/services/order/product_order_service.js' />"></script>
  <script src="<c:url value='/static/js/controllers/order/product_order_controller.js' />"></script>
  <script src="<c:url value='/static/js/map/map.js' />"></script>
  <link rel="stylesheet" href="<c:url value="/static/css/order/orderPageStyle.css"/> "/>
  <script src="<c:url value="/static/js/content/menu.js"/>" ></script>
</head>
<body ng-app="myApp" ng-controller="ProductController as ctr">
<div class="container-fluid" id="wrapper" style="padding-left: 0px;padding-right: 0px;">
  <div class="row" style="color: #cfd2da;">
    <div class="hr-divider">
      <h3 class="hr-divider-content hr-divider-heading">Order</h3>
    </div>
    <div class="orderMap col-lg-12 col-md-10 col-sm-12" id="myMap"></div>
    <%-- product order --%>
    <div class="product-order col-lg-4 col-md-5 col-sm-4">
      <%--Top add the product, amount --%>
        <div class="top-add-form">
          <div><span><center>Products Order</center></span></div>
          <form ng-submit="ctr.submit()" name="productForm">
            <div>
              <input type="hidden" ng-model="ctr.product_order.id_product_order">
              <div class="select-product">
                <div><label>Add Product</label></div>
                <div>
                  <select ng-model="ctr.product_order.product_name" required="true" width="20px">
                    <option value="">Choose the product</option>
                    <c:forEach items="${products}" var="product">
                      <option>${product.product_name}</option>
                    </c:forEach>
                  </select>
                </div>
              </div><br>
              <div class="amountProduct">
               <div>
                 <label>Amount product</label><br>
                 <input type="text" ng-model="ctr.product_order.amount_product" placeholder="Amount" required="true" size="5px">
                 <input type="submit" value="+" ng-disabled="productForm.$invalid">
               </div>
              </div><br>
            </div>
          </form>
        </div>
        <%-- Dow list of the shosen product --%>
        <div class="panel panel-default">
          <div class="tablecontainer">
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
                  <div class="table-product">
                    <tbody>
                    <tr ng-repeat="product_order in ctr.products_order">
                      <td><span ng-bind="product_order.product_name"></span></td>
                      <td><span ng-bind="product_order.amount_product"></span></td>
                      <td><span ng-bind="product_order.price_amount"></span></td>
                      <td><button type="button">+/-</button> <button type="button">-</button></td>
                    </tr>
                    </tbody>
                  </div>
              </table>
            </div>
          </div>
      </div>
    <%-- order route --%>
    <div class="orderInf col-lg-4 col-md-5 col-sm-4">
      <div><span><center>Route</center></span></div>
      <%--latitude spot--%>
      <div class="spot-latitude">
       <div class="l-spot-lat"><label><center>Latitude</center></label></div>
        <input type="text" required="true" ng-model="" size="">
      </div>
      <%--longitude spot--%>
      <div class="spot-longitude">
        <div class="l-spot-lon"><label><center>Longitude</center></label></div>
        <input type="text" required="true" ng-model="">
      </div>
      <%-- spot type --%>
      <div class="spot-type">
        <div class="l-spot-type"><lable>Spot Type</lable></div>
        <select ng-model="" required="true">
          <option value="">Choose type </option>
          <c:forEach items="${spot_types}" var="spot_type">
            <option>${spot_type.type}</option>
          </c:forEach>
        </select>
      </div>
    </div>
    <%-- order --%>
    <div class="orderInf col-lg-4 col-md-5 col-sm-4 ">
      <div><span><center> Order</center></span></div>
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
  </div>
</div>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCcvW79JU7_-mGjdioRMcwbIBJIBBIgZ5Q&callback=initMap">
</script>
</body>
</html>
