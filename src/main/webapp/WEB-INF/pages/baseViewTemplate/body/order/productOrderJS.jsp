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
  <script src="<c:url value='/static/js/services/order/order_service.js' />"></script>
  <script src="<c:url value='/static/js/controllers/order/order_controller.js' />"></script>
  <script src="<c:url value='/static/js/map/map.js' />"></script>
  <link rel="stylesheet" href="<c:url value="/static/css/order/orderPageStyle.css"/> "/>
  <link rel="stylesheet" href="<c:url value="/static/css/animate/animated.css"/> "/>
  <script src="<c:url value="/static/js/content/menu.js"/>" ></script>
</head>
<body ng-app="myApp">
<div class="container-fluid" ng-controller="OrderController as ctr" id="wrapper" style="padding-left: 0px;padding-right: 0px;color:#1ca8dd;">
  <div class="row">
    <div class="hr-divider animated">
      <h3 class="hr-divider-content hr-divider-heading">Order</h3>
    </div>
    <%-- search location --%>
    <div class="search-spot-location">
      <input type="text" id="search-spot-location-in" align="center" value="" placeholder="Search location" class="select-w-300 transparent-background custom-height-25"/>
      <button type="button" id="search-spot-location-butt" class="transparent-background custom-height-25"><span class="glyphicon glyphicon-search"></span></button>
    </div>
    <%-- mous cursor's coords --%>
    <div id="coords"></div>
      <%--col-lg-12 col-md-10 col-sm-12--%>
      <div class="orderMap col-lg-8" id="myMap"></div>
      <%-- order spot --%>
      <div class="order-spot col-lg-4">
        <div class="mar-top-10"><span><center>Order spot</center></span></div>
        <div>
        <form ng-submit="ctr.addSpot()" name="orderSpot" >
          <input type="hidden" ng-model="ctr.order_spot.id_order_spot">
          <%-- address spot--%>
          <div class="spot-address mar-top-10" align="center">
            <div class="l-spot-ad" align="left"><label>Address</label></div>
            <input type="text" ng-model="ctr.order_spot.address" id="spot-address-in" required="true"   placeholder="Address spot" class="form-control input-sm select-w-300">
          </div>
          <%--latitude spot--%>
          <div class="spot-latitude mar-top-10">
            <div class="l-spot-lat"><label>Latitude</label></div>
            <input id="spot-lat-in" ng-model="ctr.order_spot.latitude" type="number" required="true" class="form-control input-sm"  placeholder="Latitude spot">
          </div>
          <%--longitude spot--%>
          <div class="spot-longitude mar-top-10" align="right">
            <div class="l-spot-lon" align="left"><label>Longitude</label></div>
            <input id="spot-lng-in" ng-model="ctr.order_spot.longitude" type="number" required="true" class="form-control input-sm"  placeholder="Longitude spot">
          </div>
          <%-- spot type --%>
          <div class="spot-type mar-top-10" align="center">
            <div class="l-spot-type" align="left"><lable>Spot Type</lable></div>
            <select required="true" ng-model="ctr.order_spot.name_spot_type" class="form-control select-w-300" id="spot-type-s">
              <option value="">Choose type</option>
              <c:forEach items="${spot_types}" var="spot_type">
                <option>${spot_type.type}</option>
              </c:forEach>
            </select>
            <div class="button-spot mar-top-10" align="center">
              <input id="save-spot-butt" type="submit" ng-click="ctr.addSpot()" value="Save" class="btn btn-sm btn-primary-outline btn-32-per btn-spot" ng-disabled="orderSpot.$invalid"/>
              <%-- delete buttons --%>
              <input id="delete-spot-butt" type="button" ng-click="ctr.removeOrderSpot(ctr.order_spot.address)" value="Delete" class="btn btn-sm btn-primary-outline btn-32-per btn-spot">
              <input id="delete-all-spot-butt" type="button" ng-click="ctr.deleteAllSpots()" value="Delete All" class="btn btn-sm btn-primary-outline btn-32-per btn-spot">
            </div>
          </div>
        </form>
        </div>
        <%-- Bottom of the list spots panel --%>
        <div class="panel-spot panel-default">
          <%-- Default panel contents --%>
          <div class="panel-heading" align="center"><span class="lead">List of order spots </span></div>
          <div class="tablecontainer">
            <table class="table table-hover">
              <%--Head panel--%>
              <thead>
              <tr>
                <th>Address</th>
                <th>Type</th>
                <th></th>
              </tr>
              </thead>
              <%--Content table--%>
              <div class="table-spot">
                <tbody>
                <tr ng-repeat="order_spot in ctr.order_spots">
                  <td><span ng-bind="order_spot.address"></span></td>
                  <td><span ng-bind="order_spot.name_spot_type"></span></td>
                  <td><button type="button" ng-click="ctr.editOrderSpot(order_spot.address)"><span class="glyphicon glyphicon glyphicon-refresh"></span></button><%--<button id="delete-spot-butt" type="button" ng-click="ctr.removeOrderSpot(order_spot.address)"><span class="glyphicon glyphicon-remove"></span></button>--%></td>
                </tr>
                </tbody>
              </div>
            </table>
          </div>
        </div>
      </div>
    <%-- product order --%>
    <div class="product-order col-lg-4">
      <%-- Top of the list with added products, amount --%>
        <div class="top-add-form">
          <div class="mar-top-10"><span><center>Product Order</center></span></div>
          <form ng-submit="ctr.submit()" name="productForm">
            <div>
              <input type="hidden" ng-model="ctr.product_order.id_product_order">
              <div class="select-product mar-top-10" align="center">
                <div class="l-product" align="left"><label>Add Product</label></div>
                <div class="">
                  <select ng-model="ctr.product_order.product_name" required="true" class="form-control select-w-300">
                    <option value="">Choose the product</option>
                    <c:forEach items="${products}" var="product">
                      <option>${product.product_name}</option>
                    </c:forEach>
                  </select>
                </div>
              </div>
              <div class="mar-top-10">
                <button type="button" class="btn btn-sm btn-primary-outline btn-32-per"><span class="glyphicon glyphicon-plus"></span> Add product</button>
              </div>
              <div class="amountProduct" align="center">
                <div class="amount-product-in mar-top-10">
                  <div class="l-amount-product" align="left"><label>Amount product</label></div>
                  <input type="number" ng-model="ctr.product_order.amount_product" placeholder="Amount" required="true" size="5px"
                         class="form-control input-sm select-w-300" ng-maxlength="10" id="product_order">
                  <div class="has-error" ng-show="productForm.$dirty">
                    <span ng-show="productForm.product_order.$error.type">Only numbers</span>
                    <span ng-show="productForm.product_order.$error.required">This is a required field</span>
                    <span ng-show="productForm.product_order.$error.maxlength">Maximum length required is 10</span>
                    <span ng-show="productForm.product_order.$invalid">This field is invalid </span>
                  </div>
                </div>
              </div>
              <div class="button-add-product mar-top-10">
                <input type="submit" value="{{!ctr.product_order.price_amount ? 'Add' : 'Update'}}" ng-disabled="productForm.$invalid" class="btn btn-sm btn-primary-outline btn-32-per">
              </div>
            </div>
          </form>
        </div>
        <%-- Bottom of the list product panel --%>
        <div class="panel panel-default mar-top-10">
          <%-- Default panel contents --%>
          <div class="panel-heading" align="center"><span class="lead">List of order products</span></div>
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
                      <td><button type="button" ng-click="ctr.edit(product_order.product_name)"><span class="glyphicon glyphicon glyphicon-refresh"></span></button><button type="button" ng-click="ctr.remove(product_order.product_name)"><span class="glyphicon glyphicon-remove"></span></button></td>
                    </tr>
                    </tbody>
                  </div>
              </table>
            </div>
          </div>
      </div>
    <%-- order route --%>
    <div class="order-route col-lg-4 ">
      <div class="mar-top-10"><span><center>Route</center></span></div>
      <form ng-submit="ctr.addRoute()" name="orderRoute" >
        <div class="button-route mar-top-10" align="center">
          <input id="build-route-butt" type="button"  value="Build route" class="btn btn-sm btn-primary-outline btn-35-per">
          <input id="save-route-butt" type="button" ng-click="ctr.saveRoute()" value="Save route" class="btn btn-sm btn-primary-outline btn-35-per">
        </div>
        <div id="right-panel" class="mar-top-10"></div>
      </form>
    </div>

    <%-- order --%>
    <div class="order-content col-lg-4">
      <div class="mar-top-10"><span><center>Order</center></span></div>
      <div>
      <form  ng-submit="ctr.create()" name="orderForm">
        <input type="hidden" ng-model="ctr.order.id_order">
        <div class="date-delivery mar-top-10" align="center">
          <div class="l-date-delivery" align="left"><label>Date delivery</label></div>
          <input type="date" required="true" ng-model="ctr.order.date_delivery" class="btn-primary-outline btn-date-delivery">
        </div>
        <div class="time-delivery mar-top-10" align="center">
         <div class="l-time-delivery" align="left"><label>Time delivery</label></div>
          <input type="time" required="true" ng-model="ctr.order.time_delivery" class="btn-primary-outline">
        </div><br>
        <div class="transport mar-top-10" align="center">
          <div class="l-transport" align="left"><label>Transport</label></div>
          <select ng-model="ctr.order.name_transport" required="true" class="form-control select-w-300">
            <option value="">Choose the transport</option>
            <c:forEach items="${transports}" var="transport">
              <option>${transport.name_transport}</option>
            </c:forEach>
          </select>
        </div>
        <div class="create-order-btn mar-top-10 btn-35-per" align="left">
          <button type="submit" ng-click="ctr.create()" ng-disabled="orderForm.$invalid" class="btn btn-sm btn-primary-outline btn-100-per">Create Order</button>
        </div>
        <div class="add-transport-btn mar-top-10 btn-35-per" align="left">
          <button type="button" class="btn btn-sm btn-primary-outline add-transport-butt btn-100-per"><span class="glyphicon glyphicon-plus"></span> Transport</button>
        </div>
      </form>
      </div>
    </div>
  </div>
  <%-- Order panel --%>
  <div class="order-panel" id="order-panel">
    <div class="panel-order panel-default">
      <div class="panel-heading-order" align="center">
        <center><span class="lead">Order list</span></center>
        <div class="order-btn" align="right">
          <button title="Save all orders" class="btn btn-sm btn-primary-outline order-save-btn"><span class="glyphicon glyphicon-floppy-open"></span></button>
          <button title="Print list" class="btn btn-sm btn-primary-outline order-print-btn"><span class="glyphicon glyphicon-print"></span></button>
        </div>
      </div>
      <table class="table table-condensed">
        <thead>
        <tr>
          <th>#</th>
          <th>Creation date</th>
          <th>Price Order</th>
          <th>Date delivery</th>
          <th>Time delivery</th>
          <th>Transport</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="order in ctr.orders">
          <td><span ng-bind="order.date_order"></span></td>
          <td><span ng-bind="order.price_order"></span></td>
          <td><span ng-bind="order.date_delivery"></span></td>
          <td><span ng-bind="order.time_delivery"></span></td>
          <td><span ng-bind="order.name_transport"></span></td>
        </tr>
        <%--<c:forEach items="${orders}" var="order">
          <tr>
            <td><span>${order.id_order}</span></td>
            <td><span>${order.date_order}</span></td>
            <td><span>${order.price_order}</span></td>
            <td><span>${order.date_delivery}</span></td>
            <td><span>${order.time_delivery}</span></td>
            <td><span>${order.name_transport}</span></td>
          </tr>
        </c:forEach>--%>
        </tbody>
      </table>
    </div>
  </div>
</div>
<%-- This is the key for using Google Maps APIv3--%>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCcvW79JU7_-mGjdioRMcwbIBJIBBIgZ5Q&callback=initMap">
</script>
<script>
  $(window).scroll(function() {
    $('.order-panel').each(function () {
      var imagePos = $(this).offset().top;
      var topOWindow = $(window).scrollTop();
      if (imagePos < topOWindow + 700) {
        $(this).addClass('slideInUp');
      }
    });
  });
</script>
</body>
</html>
