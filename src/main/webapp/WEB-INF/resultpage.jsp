<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage>
    <jsp:attribute name="header">
        <div class="text-center">
      <p>  Choose Carport </p>
        </div>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>
    <jsp:body>
             <div class="text-center">
           <p>
               You have reserved the  carport with length : ${requestScope.length} cm <br/>
               You have reserved the  carport with width : ${requestScope.width} cm
           </p>
             </div>

           <table class="table table-bordered table-dark">
               <thead><th>Description </th><th>length</th><th>Qauntity</th><th>informaion</th></thead>
               <c:forEach var="carportItem" items="${requestScope.bill.carportItemList}">
                   <tr>
                       <td>${carportItem.description}</td>
                       <td>${carportItem.length}</td>
                       <td>${carportItem.qauntity}</td>
                       <td>${carportItem.info}</td>
                   </tr>
               </c:forEach>

           </table
               <p>Total price : ${requestScope.bill.getTotalPrice()}</p>

            <div>
                press here to se your carport draw<a href="${pageContext.request.contextPath}/fc/showsvg">SVG Drwaing</a>
            </div>
        <form  action="${pageContext.request.contextPath}/fc/station" method="get">
           <input type="hidden" name="orderId" value="${requestScope.OrderID}">
            <label for="station">Choose carport:</label>
             <select id="station" name="station" >
                <option value="station" selected>Choose</option>
                <option value="accept" >accept</option>
                <option value="refuse" >refuse</option>
                    </select>
                <br> <button type="submit" class="btn btn-primary mt-3">Sent chooses</button></br></br>
            </form>
    </jsp:body>
</t:genericpage>
