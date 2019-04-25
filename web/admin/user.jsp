<%-- 
    Document   : user
    Created on : Dec 10, 2018, 1:39:45 AM
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
        <h1>Hello ${sessionScope.USER}!</h1><br/>
        <br/>
        <a href="insert_user.jsp">Insert new user</a><br/>
        <br>
        <form action="UserMainController" method="POST">
            Search User: <input type="text" name="txtSearch" required="true"/>
            <input type="submit" name="action" value="Search"/>
        </form><br/>
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="table">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.username}</td>
                                <td>${dto.email}</td>
                                <td>${dto.role}</td>
                                <td>
                                    <c:url var="deleteLink" value="UserMainController">
                                        <c:param name="action" value="Delete"/>
                                        <c:param name="username" value="${dto.username}"/>
                                        <c:param name="txtSearch" value="${param.txtSearch}"/>
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <form action="UserMainController" method="POST">
                                        <input type="hidden" name="username" value="${dto.username}"/>
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
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
