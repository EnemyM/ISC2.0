<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 16.03.2016
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Users List</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
  <link href="<c:url value='/static/css/bootstrap.main.css' />" rel="stylesheet"/>
</head>

<body>
<div class="generic-container">
  <div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">List of Orders </span></div>
    <table class="table table-hover">
      <thead>
      <tr>
        <th>Status</th>
        <th>User</th>
        <th>Products</th>
        <th>Price order</th>
        <th>Date order</th>
        <th>Date delivery</th>
        <th>Place delivery</th>
        <th>Time delivery</th>
        <th width="100"></th>
        <th width="100"></th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${orders}" var="order">
        <tr>
          <td>${order.order_status}</td>
          <td>${order.user}</td>
          <td><form:select path="product" items="${products}" multiple="true"
                           itemValue="id" itemLabel="product_name" class="form-control input-sm" /></td>
          <td>${order.price_order}</td>
          <td>${order.date_order}</td>
          <td>${order.dete_delivery}</td>
          <td>${order.plays_delivery}</td>
          <td><a href="<c:url value='/edit-user-${user.ssoId}' />" class="btn btn-success custom-width">edit</a></td>
          <td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <div class="well">
    <a href="<c:url value='/newuser' />">Add New User</a>
  </div>
</div>
</body>
</html>