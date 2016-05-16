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
<div class="container-fluid" id="wrapper" style="padding-left: 0px;padding-right: 0px;color:#1ca8dd;">
  <div class="row">
    <div class="hr-divider">
      <h3 class="hr-divider-content hr-divider-heading">Order</h3>
    </div>
    <%-- search location --%>
    <div class="search-spot-location">
      <input type="text" id="search-spot-location-in" align="center" value="" placeholder="Search location" class="select-w-300 transparent-background custom-height-25"/>
      <button type="button" id="search-spot-location-butt" class="transparent-background custom-height-25"><span class="glyphicon glyphicon-search"></span></button>
    </div>
    <div class="orderMap col-lg-12 col-md-10 col-sm-12" id="myMap"></div>
    <%-- product order --%>
    <div class="product-order col-lg-4 col-md-5 col-sm-4 ">
      <%--Top add the product, amount --%>
        <div class="top-add-form">
          <div class="mar-top-10"><span><center>Products Order</center></span></div>
          <form ng-submit="ctr.submit()" name="productForm">
            <div>
              <input type="hidden" ng-model="ctr.product_order.id_product_order">
              <div class="select-product mar-top-10" align="center">
                <div><label>Add Product</label></div>
                <div>
                  <select ng-model="ctr.product_order.product_name" required="true" class="select-w-300">
                    <option value="">Choose the product</option>
                    <c:forEach items="${products}" var="product">
                      <option>${product.product_name}</option>
                    </c:forEach>
                  </select>
                </div>
              </div>
              <div class="amountProduct" align="center">
                <div class="amount-product-in mar-top-10" >
                  <label>Amount product</label><br>
                  <input type="text" ng-model="ctr.product_order.amount_product" placeholder="Amount" required="true" size="5px"
                         class="select-w-300">
                </div>
                <div class="button-add-product mar-top-10">
                  <input type="submit" value="Add" ng-disabled="productForm.$invalid" class="select-w-300">
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
    <div class="order-route col-lg-4 col-md-5 col-sm-4">
      <div class="mar-top-10"><span><center>Route</center></span></div>
      <form ng-submit="ctr.addSpot()" name="orderRoute" >
        <%-- address spot--%>
        <div class="spot-address mar-top-10" align="center">
          <div class="l-spot-ad"><label>Address</label></div>
          <input type="text" ng-model="ctr.order_spot.address" id="spot-address-in" required="true" value=""  placeholder="Enter address spot" class="select-w-300">
        </div>
        <%--latitude spot--%>
        <div class="spot-latitude mar-top-10">
          <div class="l-spot-lat"><label>Latitude</label></div>
          <input id="spot-lat-in" ng-model="ctr.order_spot.latitude" type="text" required="true"  value="" placeholder="Latitude spot">
        </div>
        <%--longitude spot--%>
        <div class="spot-longitude mar-top-10" align="right">
          <div class="l-spot-lon"><label>Longitude</label></div>
          <input id="spot-lng-in" ng-model="ctr.order_spot.longitude" type="text" required="true"  value="" placeholder="Longitude spot">
        </div>
        <%-- spot type --%>
        <div class="spot-type mar-top-10" align="center">
          <div class="l-spot-type"><lable>Spot Type</lable></div>
          <select required="true" ng-model="ctr.order_spot.name_spot_type" class="select-w-300" id="spot-type-s">
            <option value="">Choose type</option>
            <c:forEach items="${spot_types}" var="spot_type">
              <option>${spot_type.type}</option>
            </c:forEach>
          </select>
        </div>
        <div class="button-spot mar-top-10" align="center">
          <input id="save-spot-butt" type="submit" ng-click="ctrl.addSpot()" value="Save" class="select-w-300" ng-disabled="orderRoute.$invalid"/>
          <input id="delete-spot-butt" type="button" ng-click="deleteSpot()" value="Delete" class="select-w-300">
          <input id="delete-all-spot-butt" type="button" ng-click="deleteAllSpot()" value="Delete All" class="select-w-300">
        </div>
      </form>
    </div>
    <%-- order --%>
    <div class="order-content col-lg-4 col-md-5 col-sm-4">
      <div class="mar-top-10"><span><center>Order</center></span></div>
      <form  ng-submit="ctr.create()" name="orderForm">
        <input type="hidden" ng-model="ctr.order.id_order">
        <div class="date-delivery mar-top-10">
          <label>Date delivery</label><br>
          <input type="date" required="true" ng-model="ctr.order.date_delivery">
        </div>
        <div class="time-delivery mar-top-10">
          <label>Time delivery</label><br>
          <input type="time" required="true" ng-model="ctr.order.time_delivery">
        </div>
        <div class="transport mar-top-10">
          <label>Transport</label><br>
          <select ng-model="ctr.order.transport" required="true" class="select-w-300">
            <option value="">Choose the transport</option>
            <c:forEach items="${transports}" var="transport">
              <option>${transport.name_transport}</option>
            </c:forEach>
          </select>
        </div>
        <div class="order-button mar-top-10">
          <button type="submit" ng-click="ctr.create()" ng-disabled="orderForm.$invalid" class="select-w-300">Create</button>
        </div>
      </form>
    </div>
  </div>
</div>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCcvW79JU7_-mGjdioRMcwbIBJIBBIgZ5Q&callback=initMap">
</script>
</body>
</html>
