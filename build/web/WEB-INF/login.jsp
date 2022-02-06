<%-- 
    Document   : login
    Created on : 2022-2-4, 0:18:12
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <p><label>Username:</label><input type="textbox" name="username" value="${username}"></p>
            <p><label>Password:</label><input type="textbox" name="password"></p>
            <input type="submit" name="login" value="submit">
        </form>
        <p>${message}</p>
    </body>
</html>
