<%-- 
    Document   : admin
    Created on : Dec 10, 2018, 1:37:08 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.USER}!</h1>
        <a href="ShowUserController">Manage User</a>
        <a href="ShowProductController">Manage Product</a>
        <a href="ShowOrderController">Manage Order</a>
    </body>
</html>
