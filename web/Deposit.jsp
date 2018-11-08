<%-- 
    Document   : Deposit
    Created on : Nov 8, 2018, 3:19:57 PM
    Author     : maysmiler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit Page</title>
    </head>
    <body>
        <form action="Deposit" method="post">
            <h1>Deposit :</h1>
            <input type="number" name="deposit"/>
            <br>
            ${messageDepo}
            <br>
            <input type="submit" value="Deposit"/>
            <a href="MyAccount">back</a>
        </form>
       
    </body>
</html>
