<%-- 
    Document   : product
    Created on : Dec 10, 2018, 4:38:54 PM
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
        <h1>Product Manage</h1>
        <a href="insert_product.jsp">Insert new product</a><br/>
        <br/>
        <form action="ProductMainController" method="POST">
            Search : <input type="text" name="txtSearch" required="true"/>
            <input type="submit" name="action" value="Search"/>
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
                            <th>Delete</th>
                            <th>Update</th>
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
                                    <c:url var="deleteLink" value="ProductMainController">
                                        <c:param name="action" value="Delete"/>
                                        <c:param name="txtProductID" value="${dto.productID}"/>
                                        <c:param name="txtSearch" value="${param.txtSearch}"/>
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <form action="ProductMainController" method="POST">
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                        <input type="hidden" name="txtProductID" value="${dto.productID}"/>
                                        <input type="submit" name="action" value="Edit"/>
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
