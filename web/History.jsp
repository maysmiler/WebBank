<%-- 
    Document   : History
    Created on : Nov 8, 2018, 8:02:48 PM
    Author     : maysmiler
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
    </head>
    <body>
        <h1>History</h1>
        <table>
            <tr>
                <td>#</td>
                <td>TimeStamp</td>
                <td>Method</td>
                <td>Amount</td>
                <td>Balance</td>
            </tr>
            <c:forEach items="${history}" var="h" varStatus="n">
            <tr>
                <td>${n.count}</td>  
                <td>${h.createdate}</td>  
                <td>${h.method}</td>  
                <td>${h.amount}</td>  
                <td>${h.balance}</td>  
            </tr>
            </c:forEach>
        </table>
            <a href="MyAccount">back</a>
    </body>
</html>
