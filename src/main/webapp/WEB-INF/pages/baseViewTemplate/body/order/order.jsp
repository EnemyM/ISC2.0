<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 16.03.2016
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

</head>
<body>
<div class="generic-container" >
  <div class="panel panel-default">
    <div class="panel-heading"><span class="lead">Create Order Form </span></div>
    <div class="formcontainer">
      <form:form method="POST" modelAttribute="order" class="form-horizontal" action="/">
        <form:input type="hidden" path="id_order"/>

        <%-- Products order: product,amount , prise--%>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="products_order">Products:  </label>

                  <div class="col-md-7">
                      <form:select
                              id="product" class="form-control input-sm"
                              path="products_order"
                              items="${products}" multiple="true" itemValue="id_product"
                              itemLabel="product_name"/>

                <%--<label class="col-md-2 control-lable" for="amount_product">Amount:  </label>
                  <form:input type="text" path="products_order" name="products_order.amount_product"/>--%>


              <%--<form:form modelAttribute="product_order" method="POST" class="form-horizontal">
                <label class="col-md-2 control-lable" for="amount_product"> Amount </label>
                <form:input type="text" path="amount_product" id="amount_product"
                            class="form-control input-sm" placeholder="Enter amount product"/>
                <div class="has-error">
                  <span>This field is invalid </span>
                </div>
                <a href="<c:url value="/costAmount/" />" class="btn btn-warning btn-sm">Prise</a><tr><td>${cost}</td></tr>

              </form:form>--%>

              </div>
          </div>
        </div>

        <%-- Time delivery--%>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="time_delivery">Time delivery</label>
            <div class="col-md-7">
              <form:input type="time" path="time_delivery" id="time_delivery" class="form-control input-sm" />
            </div>
          </div>
        </div>

        <%-- Place delivery--%>
        <%--<div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="place_delivery">Time delivery</label>
            <div class="col-md-7">
              <form:input type="text" path="place_delivery" id="place_delivery" class="form-control input-sm"
                     placeholder="Input place delivery"/>
            </div>
          </div>
        </div>--%>

       <%-- &lt;%&ndash; Total coast &ndash;%&gt;
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" for="price_order">Time delivery</label>
            <div class="col-md-7">
              <a href="<c:url value="/totalPrice"/> " class="btn btn-warning btn-sm"> Total Price </a>
              <div type="text" id="price_order" class="form-control input-sm"
                     placeholder="Input place delivery">${totalPrice}</div>
            </div>
          </div>
        </div>--%>

        <div class="row">
          <div class="form-actions floatRight">
            <input type="submit" value="Add" class="btn btn-primary btn-sm" />

          </div>
        </div>

      </form:form>
    </div>
  </div>

</div>
</body>
</html>
