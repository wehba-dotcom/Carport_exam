<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Register as new User
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div style="margin-top: 5em;">
            <form name="login" action="${pageContext.request.contextPath}/fc/registercommand" method="POST">
                    <div class="row mb-3">
                        <label class="col-sm-1 col-form-label" for="name">Name</label>
                        <div class="col-sm-4">
                            <input id="name" class="form-control" type="text" name="name" value="${param.name}" placeholder="name">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-1 col-form-label" for="email">Email</label>
                        <div class="col-sm-4">
                            <input id="email" class="form-control" type="text" name="email" value="${param.email}" placeholder="someone@nowhere.com">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-1 col-form-label" for="adress">Adress</label>
                        <div class="col-sm-4">
                            <input id="adress" class="form-control" type="text" name="adress" value="${param.adress}" placeholder="adress">
                        </div>
                    </div> <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="phonenumber">Phone No</label>
                    <div class="col-sm-4">
                        <input id="phonenumber" class="form-control" type="text" name="phonenumber" value="${param.phonenumber}" placeholder="phonenumber">
                    </div>
                </div> <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="balance">Balance</label>
                    <div class="col-sm-4">
                        <input id="balance" class="form-control" type="text" name="balance" value="${param.balance}" placeholder="balance">
                    </div>
                </div>
                    <div class="row mb-3">
                        <label class="col-sm-1 col-form-label" for="password1">Password1</label>
                        <div class="col-sm-4">
                            <input id="password1" class="form-control" type="password" name="password1" value="${param.password1}" placeholder="password1">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-1 col-form-label" for="password2">Password2</label>
                        <div class="col-sm-4">
                            <input id="password2" class="form-control" type="password" name="password2" value="${param.password2}" placeholder="password2">
                        </div>
                    </div>
                <input class="btn btn-primary" type="submit" type="submit" value="Submit">
            </form>
                <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>
        </div>
    </jsp:body>
</t:genericpage>


