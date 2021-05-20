<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <style>
                * {
                    box-sizing: border-box;
                }

                body {
                    margin: 0;
                    font-family: Arial;
                }

                .header {
                    text-align: center;
                    padding: 32px;
                }

                /* Create two equal columns that floats next to each other */
                .column {
                    float: left;
                    width: 50%;
                    padding: 15px;
                }

                .column img {
                    margin-top: 12px;
                }

                /* Clear floats after the columns */
                .row:after {
                    content: "";
                    display: table;
                    clear: both;
                }
            </style>
             <div class="header">
            <h2>Welcome to Carport Site</h2>
             </div>
        <div class="row">
        <div class="column">
         <a href="${pageContext.request.contextPath}/fc/custom"><img src="${pageContext.request.contextPath}/images/Head4.png" class="img-fluid mb-4" alt="Snow" style="width:100%"/></a><br/>
                <a href="${pageContext.request.contextPath}/fc/custom">Here you can customise your Carport </a>
            </div>
            <div class="column">
                <a href="${pageContext.request.contextPath}/fc/enkelt"><img src="${pageContext.request.contextPath}/images/Head2.jpg" alt="Snow" class="img-fluid mb-4" style="width:100%"/></a><br/>
                <a href="${pageContext.request.contextPath}/fc/enkelt">Here you can reserve a ready Carport </a>
            </div>
        </div>

        <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>