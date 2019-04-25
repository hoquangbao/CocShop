<%-- 
    Document   : viewcart
    Created on : Dec 11, 2018, 2:04:10 AM
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
        <h1>My Cart</h1> 
        <form action="CusMainController" method="POST">
            <c:if test="${sessionScope.SHOP != null}">
                <c:if test="${not empty sessionScope.SHOP}" var="table">
                    <table border="1">
                        <thead>

                            <tr>
                                <th>No</th>
                                <th>ProductName</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Remove</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${sessionScope.SHOP}" var="dto" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${dto.value.productName}<input type="hidden" name="txtProductName" value="${dto.value.productName}"/> </td>
                                    <td>${dto.value.quantity}<input type="hidden" name="txtQuantity" value="${dto.value.quantity}"/>  </td>
                                    <td>${dto.value.price} </td>
                                    <td><input type="checkbox" name="rmv" value="${dto.value.productID}"/><input type="hidden" name="txtProductID" value="${dto.value.productID}"/></td>
                                </tr>
                            </c:forEach>
                            <c:set var="total" value="${total}"/>
                            <c:forEach items="${sessionScope.SHOP}" var="dto" >
                                <c:set var="total" value="${total + (dto.value.price * dto.value.quantity)}"/>
                            </c:forEach>
                            <tr>
                                <td></td>
                                <td></td>
                                <td><input type="submit" name="action" value="Remove"/> </td>
                                <td>${total}<input type="hidden" name="txtTotal" value="${total}"/></td>
                                <td><a href="CusShowProductController">Continue shopping</a></td>
                            </tr>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${!table}">
                    You don't have any product!
                    <a href="CusShowProductController">Back</a>
                </c:if>
            </c:if>
            <font color="red">${requestScope.ERROR}</font><br/>
            <input type="hidden" name="username" value="${sessionScope.USER}"/>
            <input type="submit" name="action" value="Buy"/>
        </form>
    </body>
</html>
