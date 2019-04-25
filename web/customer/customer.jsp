<%-- 
    Document   : employee
    Created on : Dec 10, 2018, 1:37:17 AM
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
        <h1>Welcome ${sessionScope.USER}!</h1>
        <a href="GetUserInfomation?username=${sessionScope.USER}">Profile</a>
        <a href="viewcart.jsp">View My Cart</a>
        <form action="CusMainController" method="POST">
            <input type="text" name="txtSearch" required="true"/><br/>
            <input type="submit" name="action" value="Search"/><br/>
        </form>
        <br>
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="table">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ProductID</th>
                            <th>ProductName</th>
                            <th>Type</th>
                            <th>Price</th>
                            <th>Cart</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.productID}</td>
                                <td>${dto.productName}</td>
                                <td>${dto.type}</td>
                                <td>${dto.price}</td>
                                <td>
                                    <form action="CusMainController" method="POST">
                                        <input type="hidden" name="productID" value="${dto.productID}"/>
                                        <input type="hidden" name="productName" value="${dto.productName}"/>
                                        <input type="hidden" name="price" value="${dto.price}"/>
                                        <input type="submit" name="action" value="Add to Cart"/>
                                    </form>
                                </td>
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
