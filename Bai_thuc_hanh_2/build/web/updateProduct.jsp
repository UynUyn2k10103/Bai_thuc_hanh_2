
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
        <h1>Product</h1>
        <h3 style="color: red">${sussess}</h3>
        
        <p style="color: red;">${notification}</p>
        <form action="updateProduct?id=${product.id}" method="post">
            <input type="hidden" name="action" value="update">
            <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Product Code:</label>
            <input type="text" name="code" value="${code}" disabled="true" /><br>
            <label>Product Description:</label>
            <input type="text" name="description" value="${description}"/><br>
            <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Product Price:</label>
            <input type="text" name="price" value="${price}"/><br>
            <p></p>
            <button><a style="text-decoration: none; color: black; font-size: 15px;">Update Product</a></button>
            <!--<input name="update" id="update" value="Update Product" style="text-decoration: none; color: black; font-size: 15px;" type="submit"/>-->
            <button><a href="products" style="text-decoration: none; color: black; font-size: 15px;">View Products</a></button>
        </form>
        
        
    </body>
</html>
