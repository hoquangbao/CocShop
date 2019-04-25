<%-- 
    Document   : index
    Created on : Dec 5, 2018, 2:32:17 PM
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
        <h1>LOGIN PAGE</h1>
        <form action="UserMainController" method="POST">
            <font color="red">${requestScope.ERROR}</font><br/>
            Username: <input type="text" name="txtUsername"/><br/>
            Password: <input type="password" name="txtPassword"/><br/>
            <input type="submit" name="action" value="Login"/>
        </form>
    </body>
</html>
