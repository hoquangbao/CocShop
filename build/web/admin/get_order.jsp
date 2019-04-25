<%-- 
    Document   : get_order
    Created on : Dec 15, 2018, 1:11:19 AM
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
        <h1>Order Manage</h1>
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="table">
                <table border="1">
                    <thead>
                        <tr>
                            <th>OrderID</th>
                            <th>ProductID</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.INFO}" var="dto">
 
                            <tr>
                                <td>${dto.orderID}</td>
                                <td>${dto.productID}</td>
                                <td>${dto.quantity}</td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${!table}">
                No record found!
            </c:if>
        </c:if>
    </body>
</html>
