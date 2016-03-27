<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Insert title here</title>
  <SCRIPT language="javascript">
          function addRow(tableID) {

            var table = document.getElementById(tableID);

            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
            var cell1 = row.insertCell(0);

            var element1 = document.createElement("input");
            element1.type = "checkbox";
            element1.name="chkbox[]";

            cell1.appendChild(element1);

            var cell2 = row.insertCell(1);
            cell2.innerHTML = rowCount + 1;

            var cell3 = row.insertCell(2);
            var element2 = document.createElement("select");
            element2.type = "select";
            var length =(table.rows.length)-1;
            element2.name = "products_order["+length+"].product";
            cell3.appendChild(element2);

            var cell4 = row.insertCell(3);
            var element3 = document.createElement("input");
            element3.type = "text";
            var length =(table.rows.length)-1;
            element3.name = "products_order["+length+"].amount_product";
            cell4.appendChild(element3);

          }

  function deleteRow(tableID) {
    try {
      var table = document.getElementById(tableID);
      var rowCount = table.rows.length;

      for(var i=0; i < rowCount; i++) {
        var row = table.rows[i];
        var chkbox = row.cells[0].childNodes[0];
        if(null != chkbox && true == chkbox.checked) {
          table.deleteRow(i);
          rowCount--;
          i--;
        }
      }
    }catch(e) {
      alert(e);
    }
  }

  </SCRIPT>
</head>
<body>

<form:form modelAttribute="order" action="/" method="post">

          <fieldset>
            <legend>Order</legend>

              <form:input path="id_order" type="hidden"/>

                <INPUT type="button" value="Add Product" onclick="addRow('dataTable')" />
                <INPUT type="button" value="Delete" onclick="deleteRow('dataTable')" />
                <TABLE id="dataTable" width="600px" border="1">
                  <TR>
                      <TD><INPUT type="checkbox" name="chk"/></TD>
                      <TD> 1 </TD>
                      <TD>
                        <%--<form:select
                                id="product" class="form-control input-sm modal-body-scroller"
                                placeholder="Choose product" path="products_order"
                                items="${products}" multiple="true" itemValue="id_product"
                                itemLabel="product_name" name="products_order[0].product"/>--%>

                          <form:select path="products_order">
                            <%--<form:option value="NONE" label="Product"/>--%>
                            <form:options itemLabel="product_name" items="${products}"
                                          itemValue="id_product" name="products_order[0].product" />
                        </form:select>
                      </TD>
                    <TD><form:input type='text' name="products_order[0].amount_product" required="true" path=""/> </TD>
                  </TR>
                </TABLE>

              <a href="<c:url value="/add"/>"> add</a>
              <c:forEach items="${order.products_order}" var="product" varStatus="status">
                  <tr>
                      <td align="center">${status.count}</td>
                      <td>Amount<input type="text" name="products_order[${status.index}].amount" /></td>

                  </tr>
              </c:forEach>

                <label>Place delivery</label>
                <form:input path="" type='text'
                            name="place_deliveries" required="true"/>

                <label for = time_delivery>Time delivery</label>
                <form:input path="time_delivery" name="time_delivery" type="time" required="true" />

                <label for = date_delivery>Date delivery</label>
                <form:input path="date_delivery" name="date_delivery" type="date" required="true" />

          </fieldset>
          <fieldset>
            <button type=submit>Add order</button>
          </fieldset>
</form:form>

</body>
</html>