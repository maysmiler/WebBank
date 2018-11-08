<%-- 
    Document   : MyAccount
    Created on : Nov 8, 2018, 2:46:53 PM
    Author     : maysmiler
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Account Page</title>
    </head>
    <body>
        <h1>My Account : </h1>
        <h3>Account Name : ${account.name}</h3>
        <h4>Balance : ${account.balance}</h4>
        ${messages}
        
        <br>
        <br>
        <a href="Deposit">Deposit</a>
        <br>
        <a href="Withdraw">Withdraw</a>
        <br>
        <a href="History">History</a>
        <br>
        <br>
        <br>
        <a href="Logout">Logout</a>
    </body>
</html>
