<%-- 
    Document   : Login
    Created on : Nov 8, 2018, 2:21:00 PM
    Author     : maysmiler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="Login" method="post">
        <h1>Login : </h1>
        Account Id : <input type="number" name="id" required/>
        <br>
        <br>
        Pin : <input type="password" name="pin" required/>
        <br>
        <br>
        ${message}
        <br>
        <br>
        <input type="submit" value="Login"/>
        </form>
    </body>
</html>
