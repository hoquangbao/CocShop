<%-- 
    Document   : order
    Created on : Dec 15, 2018, 12:02:27 AM
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
        <form action="OrderMainController" method="POST">
            Search : <input type="text" name="txtSearch" required="true"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <br/>
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="table">
                <table border="1">
                    <thead>
                        <tr>
                            <th>OrderID</th>
                            <th>Username</th>
                            <th>Total</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.INFO}" var="dto">
                            <tr>
                                <td>
                                    <c:url var="getOrder" value="OrderMainController">
                                        <c:param name="action" value="Get Order"/>
                                        <c:param name="txtOrderID" value="${dto.orderID}"/>
                                    </c:url>
                                    <a href="${getOrder}">${dto.orderID}</a>
                                </td>
                                <td>${dto.username}</td>
                                <td>${dto.total}</td>
                                <td>
                                    <c:url var="deleteLink" value="OrderMainController">
                                        <c:param name="action" value="Delete"/>
                                        <c:param name="txtOrderID" value="${dto.orderID}"/>
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
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
