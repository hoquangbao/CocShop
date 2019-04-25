<%-- 
    Document   : insert_product
    Created on : Dec 10, 2018, 5:09:33 PM
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
        <h1>Insert new Product!</h1>
        <form action="ProductMainController" method="POST">
            <font color="red">${requestScope.ERROR}</font>
            <table border="0">
                <tbody>
                    <tr>
                        <td>ProductID </td>
                        <td><input type="text" name="txtProductID" required="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>ProductName </td>
                        <td><input type="text" name="txtProductName" required="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>Type </td>
                        <td><input type="text" name="txtType" required="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td><input type="text" name="txtDescription" required="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="number" name="txtPrice" required="true"/><br/></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="action" value="Insert"/> 
        </form>
    </body>
</html>
