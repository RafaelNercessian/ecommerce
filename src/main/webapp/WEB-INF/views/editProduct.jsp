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
            <h1 style="margin-top:80px;">Edit Product</h1>
            <p class="lead">Please update the product!</p>
        </div>

        <div class="container">
            <form:form action="${s:mvcUrl('AC#editProductPost').arg(0,product.productId).build()}" method="POST" commandName="product" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="name">Name</label>
                    <form:input path="productName" id="name" class="form-control" value="${product.productName}"/>
                </div>


                <div class="form-group">
                    <label for="category">Category</label>
                    <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="instrument"/>Instrument</label>
                    <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="record"/>Record</label>
                    <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="accessory"/>Accessory</label>
                </div>

                <div class="form-group">
                    <label for="description">Description</label>
                    <form:input path="productDescription" id="description" class="form-control" value="${product.productDescription}"/>
                </div>

                <div class="form-group">
                    <label for="price">Price</label>
                    <form:input path="productPrice" id="price" class="form-control" value="${product.productPrice}"/>
                </div>

                <div class="form-group">
                    <label for="condition">Condition</label>
                    <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="New"/>New</label>
                    <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="Used"/>Used</label>
                </div>

                <div class="form-group">
                    <label for="status">Status</label>
                    <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="Active"/>Active</label>
                    <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="Inactive"/>Inactive</label>
                </div>

                <div class="form-group">
                    <label for="unit">Unit(s) in stock</label>
                    <form:input path="unitInStock" id="unit" class="form-control" value="${product.unitInStock}"/>
                </div>

                <div class="form-group">
                    <label for="manufacturer">Manufacturer</label>
                    <form:input path="productManufacturer" id="manufacturer" class="form-control" value="${product.productManufacturer}"/>
                </div>

                <div class="form-group">
                    <label for="image">Image</label>
                    <form:input path="productImage" id="image" type="file" class="form:input-large"/>
                </div>

                <input type="submit" value="Submit" class="btn btn-default"/>
                <a href="/admin/productInventory" class="btn btn-default">Cancel</a>

            </form:form>

        </div>
        <%@include file="/WEB-INF/views/template/footer.jsp"%>

    </div>
</div>


