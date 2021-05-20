<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
  Se your Carport Drawing
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <div>
         <h2> Drawing</h2>
        <p> here coming your carport draw </p>

        ${requestScope.svgdrawing}
        </div>
    </jsp:body>
</t:genericpage>