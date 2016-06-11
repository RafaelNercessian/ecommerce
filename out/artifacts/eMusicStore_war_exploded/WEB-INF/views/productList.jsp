<%--
  Created by IntelliJ IDEA.
  User: Rafael
  Date: 11/06/2016
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <thead>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
            </thead>
        </tr>
         <tr>
            <td>${product.productName}</td>
            <td>${product.productCategory}</td>
            <td>${product.productCondition}</td>
            <td>${product.productPrice}</td>
        </tr>

    </table>
</body>
</html>
