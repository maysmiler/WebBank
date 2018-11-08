<%-- 
    Document   : Withdraw
    Created on : Nov 8, 2018, 6:07:45 PM
    Author     : maysmiler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Withdraw Page</title>
    </head>
    <body>
        <h1>Withdraw : </h1>
        <form action="Withdraw" method="post">
            <input type="number" name="withdraw"/>
            <br>
            ${messageWi}
            <br>
            <input type="submit" value="Withdraw"/>
            <a href="MyAccount">back</a>
                
        </form>
             
    </body>
</html>
