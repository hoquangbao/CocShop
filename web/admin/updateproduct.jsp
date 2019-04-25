<%-- 
    Document   : updateproduct
    Created on : Dec 10, 2018, 4:57:38 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Product!</h1>
        <form action="ProductMainController" method="POST">
            <font color="red">${requestScope.ERROR}</font>
            <table border="0">
                <tbody>
                    <tr>
                        <td>ProductID </td>
                        <td><input type="text" name="txtProductID" value="${param.txtProductID}" readonly="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>ProductName </td>
                        <td><input type="text" name="txtProductName" value="${requestScope.INFO.productName}" required="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>Type </td>
                        <td><input type="text" name="txtType" value="${requestScope.INFO.type}" required="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td><input type="text" name="txtDescription" value="${requestScope.INFO.description}"/> <br/></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="text" name="txtPrice" value="${requestScope.INFO.price}" required="true"/><br/></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="action" value="Update"/> 
        </form>
    </body>
</html>
