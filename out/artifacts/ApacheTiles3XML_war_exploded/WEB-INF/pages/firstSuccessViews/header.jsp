<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 02.03.2016
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link href="<c:url value='/static/css/bootstrap.main.css' />" rel="stylesheet"/>


<div class="dashhead">
  <div class="dashhead-titles">
    <h6 class="dashhead-subtitle">Dashboards</h6>
    <h3 class="dashhead-title">Overview</h3>
  </div>

  <div class="dashhead-toolbar">
    <div class="input-with-icon dashhead-toolbar-item">
      <input type="text" value="01/01/15 - 01/08/15" class="form-control" data-provide="datepicker">
      <span class="icon icon-calendar"></span>
    </div>
    <span class="dashhead-toolbar-divider hidden-xs"></span>
    <div class="btn-group dashhead-toolbar-item btn-group-thirds">
      <button type="button" class="btn btn-primary-outline">Day</button>
      <button type="button" class="btn btn-primary-outline active">Week</button>
      <button type="button" class="btn btn-primary-outline">Month</button>
    </div>
  </div>
</div>
