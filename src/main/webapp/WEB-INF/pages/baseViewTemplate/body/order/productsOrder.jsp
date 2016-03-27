<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 22.03.2016
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
  <script src="<c:url value="/static/js/appProduct.js" />"></script>
</head>
<body>

<div>
  <div>
    <form:form modelAttribute="product_order" method="POST">
      <label>Amount product</label>
      <form:input path="amount_product" />
      <input type="submit" value="Add"/>

    </form:form>
  </div>
  <div>
    <c:forEach items="${products}" var="product_order">
        <tr>
          <td>${product_order.amount_product}</td>
        </tr>
    </c:forEach>
  </div>
</div>

</body>
</html>
