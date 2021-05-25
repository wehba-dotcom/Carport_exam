<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
      Edit all Orders
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        <h3 class="mb-3"> Here you can edit and update all orders in the system</h3>
             <form action="${pageContext.request.contextPath}/fc/mangeorders" method="post">
                 <input type="hidden" name="order_id" value="${requestScope.orderItem.order_id}">
        <div class="input-group input-group-sm mb-3">
            <div class="form-group">
                <label class="form-check-label" for="price">Price : </label>
                <input id="price" class="form-control" type="text" name="price" value="${requestScope.orderItem.price}">
                <button class="btn btn-primary btn-sm mt-2" type="submit" name="update" >Update Price</button>
            </div>

        </div>
        <c:if test="${not empty requestScope.error}">
            <br/>
            <p style="color:red; font-size: large">${requestScope.error}</p>
        </c:if>
             </form>

    </jsp:body>
</t:genericpage>
