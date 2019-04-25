<%-- 
    Document   : insert
    Created on : Dec 10, 2018, 2:17:54 PM
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
        <h1>INSERT NEW USER</h1>
    <form action="UserMainController" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Username </td>
                        <td><input type="text" name="txtUsername" required="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>Password </td>
                        <td><input type="password" name="txtPassword" required="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>Email </td>
                        <td><input type="text" name="txtEmail" required="true"/><br/></td>
                    </tr>
                    <tr>
                        <td>Role </td>
                        <td>
                            <select name="txtRole">
                                <option value="Admin" >Admin</option>
                                <option value="Customer">Customer</option>
                            </select>
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="action" value="Insert"/> 
        </form>
    </body>
</html>
