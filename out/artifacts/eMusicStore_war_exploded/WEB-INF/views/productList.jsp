<%--
  Created by IntelliJ IDEA.
  User: Rafael
  Date: 11/06/2016
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/views/template/header.jsp"%>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1 style="margin-top:80px;">All products</h1>

            <p class="lead">Checkout all the awesome products available now!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
                <tr class="bg-success">
                    <th>Photo</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Condition</th>
                    <th>Price</th>
                    <th></th>
                </tr>
            </thead>
                <c:forEach var="product" items="${products}">
                    <tr>
                            <td><img src="#" alt="image"></td>
                            <td>${product.productName}</td>
                            <td>${product.productCategory}</td>
                            <td>${product.productCondition}</td>
                            <td>${product.productPrice}</td>
                            <td><a href="${s:mvcUrl('HC#viewProduct').arg(0,product.productId).build()}"><span class="glyphicon glyphicon-info-sign"/></a></td>
                    </tr>
                </c:forEach>
        </table>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
