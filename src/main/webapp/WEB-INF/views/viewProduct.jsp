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
            <h1 style="margin-top:80px;">Product detail</h1>
            <p class="lead">Here is the detail information of the product!</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width: 455px;height: 300px;">
                </div>
                <div class="col-md-5">
                    <h3>Product Name: ${product.productName}</h3>
                    <p>Product description: ${product.productDescription}</p>
                    <p>Manufacturer: ${product.productManufacturer}</p>
                    <p>Category: ${product.productCategory}</p>
                    <p>Condition: ${product.productCondition}</p>
                    <p>Price: ${product.productPrice} USD</p>
                </div>

            </div>

        </div>
        <%@include file="/WEB-INF/views/template/footer.jsp"%>

    </div>
</div>


