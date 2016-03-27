<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="<c:url value='/static/js/app.js' />"></script>
  <script src="<c:url value='/static/js/services/order/product_order_service.js' />"></script>
  <script src="<c:url value='/static/js/controllers/order/product_order_controller.js' />"></script>
  <style>
    .body{
      width: 300px;
      height: 300px;
      margin: 2px 2px 2px 2px;
      border: 0.5px solid darkmagenta;
    }
  </style>
</head>
<body ng-app="myApp">
<div ng-controller="ProductController as ctr">
  <%--Top add the product, its amount --%>
  <div>
    <form ng-submit="ctr.submit()" name="productForm">
      <div>
        <select ng-model="ctr.product_order.product" required="true" width="20px">
          <c:forEach items="${products}" var="product">
            <option>${product.product_name}</option>
          </c:forEach>
        </select>
        <input type="text" ng-model="ctr.product_order.amount_product" placeholder="Amount" required="true" width="5px">

        <input type="submit" value="+" ng-disabled="productForm.$invalid">
      </div>
    </form>
  </div>
    <%-- Dow list of the shosen product --%>
  <div class="panel panel-default">
    <div class="tablecontainer">

      <div>
        <c:forEach items="${productsOrder}" var="product_order">
          <tr>
            <td>${product_order.amount_product}</td>
          </tr>
        </c:forEach>
      </div>
      <%--<table class="table table-hover">
        &lt;%&ndash;Head panel&ndash;%&gt;
        <thead>
          <tr>
            <th>Product</th>
            <th>Amount</th>
            <th>Price</th>
            <th></th>
          </tr>
        </thead>
        &lt;%&ndash;Content table&ndash;%&gt;
          <tbody>
            <button type="button">+/-</button> <button type="button">-</button>
          </tbody>
      </table>--%>

    </div>
  </div>


</div>

</body>
</html>
