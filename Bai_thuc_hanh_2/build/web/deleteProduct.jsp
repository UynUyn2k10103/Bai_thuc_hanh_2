<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css"/>
        <title>Product Maintenance</title>
    </head>
    <body>
        <h1>Are you sure you want to delete this product?</h1>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Product Code: ${product.code}</p>
        <span>Product Description: ${product.description}</span></br>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Product Price: ${product.price}</p>
        <button><a href="delete-product?code=${product.id}" style="text-decoration: none; color: black; font-size: 15px;">Yes</a></button>
        <button><a href="products" style="text-decoration: none; color: black; font-size: 15px;">No</a></button>
    </body>
</html>
