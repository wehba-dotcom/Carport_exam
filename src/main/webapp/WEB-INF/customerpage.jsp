<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of our wonderful site.
       <p>
           <a href="${pageContext.request.contextPath}">here you can go to home site </a>
       </p>
        <h3>  here you can se all yopur orders</h3>
        <p>
            <a href="${pageContext.request.contextPath}/fc/myorders">Se a list og order </a>
        </p>
    </jsp:body>

</t:genericpage>

