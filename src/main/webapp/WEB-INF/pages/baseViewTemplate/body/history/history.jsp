<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
  <link rel="stylesheet" href="<c:url value="/static/css/order/orderPageStyle.css"/> "/>
  <style>
    .panel{
      width: 100%;
      overflow-y: auto;
    }
  </style>
</head>
<body ng-app="myApp" ng-controller="OrderController as ctr">
<div class="hr-divider">
    <h3 class="hr-divider-content hr-divider-heading">History</h3>
</div>
<div class="history-panel">
  <div class="panel panel-default">
    <div class="panel-heading" align="center"><span class="lead">List of history orders</span></div>
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
          <c:forEach items="${orders}" var="order">
          <tr>
              <td><span>${order.id_order}</span></td>
              <td><span>${order.date_order}</span></td>
              <td><span>${order.price_order}</span></td>
              <td><span>${order.date_delivery}</span></td>
              <td><span>${order.time_delivery}</span></td>
          </tr>
          </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>
