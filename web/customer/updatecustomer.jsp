<%-- 
    Document   : updatecustomer
    Created on : Dec 11, 2018, 1:14:58 AM
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
        <h1>Update User Information</h1>
        <form action="CusMainController" method="POST">
            <font color="red">${requestScope.ERROR}</font>
            <table border="0">
                <tbody>
                    <tr>
                        <td>Username </td>
                        <td><input type="text" name="txtUsername" value="${param.username}" readonly="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>Password </td>
                        <td><input type="password" name="txtPassword" value="${requestScope.INFO.password}" required="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>Email </td>
                        <td><input type="text" name="txtEmail" value="${requestScope.INFO.email}" required="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>Role</td>
                        <td>
                            <select name="txtRole">
                                <option value="Admin">Admin</option>
                                <option value="Customer">Customer</option>
                            </select>
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="username" value="${param.username}"/>
            <input type="submit" name="action" value="Update"/> 
        </form>
    </body>
</html>
