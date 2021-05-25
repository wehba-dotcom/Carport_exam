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
        <p> Here is a list for all orders in the system</p>
             <form action="${pageContext.request.contextPath}/fc/mangeorders" method="post">
        <table class="table table-striped">
            <thead><th>orderId</th><th>userId</th><th>Price</th><th>length</th><th>width</th><th>station</th><th></th><th></th></thead>
            <c:forEach var="orderList" items="${requestScope.orderList}">
            <tr>
                <td>${orderList.order_id}</td>
                <td>${orderList.user_id}</td>
                <td>${orderList.price}</td>
                <td>${orderList.length}</td>
                <td>${orderList.width}</td>
                <td>${orderList.station}</td>
                <td><button class="btn btn-danger btn-sm" type="submit" name="delete" value="${orderList.order_id}">Delete</button></td>
                <td><button class="btn btn-primary btn-sm" type="submit" name="edit" value="${orderList.order_id}">Edit Price</button></td>
            </tr>
                 </c:forEach>

                  </table>
        <c:if test="${not empty requestScope.error}">
            <br/>
            <p style="color:red; font-size: large">${requestScope.error}</p>
        </c:if>
             </form>

    </jsp:body>
</t:genericpage>
