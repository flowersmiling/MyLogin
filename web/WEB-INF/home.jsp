<%-- 
    Document   : home
    Created on : 2022-2-4, 0:18:28
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h2>Hello,${username}</h2>
        <a href="login?action=logout">Log Out</a>
    </body>
</html>
