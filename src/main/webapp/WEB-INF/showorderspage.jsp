<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
      A List og all Orders
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        Here is a list for all orders in the system
        <table class="table">

            <thead><th>orderid</th><th>userid</th><th>Price</th><th>length</th><th>width</th></thead>
            <c:forEach var="order" items="${requestScope.orderList}">
            <tr>
                <td>${order.order_id}</td>
                <td>${order.user_id}</td>
                <td>${order.price}</td>
                <td>${order.length}</td>
                <td>${order.width}</td>
            </tr>


            </c:forEach>

        </table>



    </jsp:body>
</t:genericpage>
