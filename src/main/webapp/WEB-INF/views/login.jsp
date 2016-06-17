<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <h2 style="margin-top:90px">Login with username and password!</h2>
    <form name="loginForm" action="<c:url value="j_spring_security_check"/>" method="post">
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <div class="form-group">
            <label for="username">User: </label>
            <input type="text" id="username" name="username" class="form-control">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control">
        </div>
        <input type="submit" value="Submit" class="btn btn-default">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
        <%@ include file="/WEB-INF/views/template/footer.jsp"%>
    </div>
</div>



