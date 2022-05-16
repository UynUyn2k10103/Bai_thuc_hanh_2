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
        <h1>Products</h1>
        <p style="color: red">${notification}</p>
        <table style="border: 1px solid black" border="1">
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Price</th>
                <th colspan="2"></th>
            </tr>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.code}</td>
                    <td>${p.description}</td>
                    <td>$ ${p.price}</td>
                    <td class="w-50"><a href="update-product-by-code?code=${p.id}">Edit</a></td>
                    <td class="w-50"><a href="delete-product-by-code?code=${p.id}">Delete</a></td>
                
                </tr>
            </c:forEach>
        </table>
<!--        <p>update-product-by-code?code=${p.id}</p>-->
        <p></p>
        <button><a href="addProduct" style="text-decoration: none; color: black; font-size: 15px;">Add Product</a></button>
    </body>
</html>