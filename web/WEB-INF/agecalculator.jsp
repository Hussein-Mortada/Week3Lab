<%-- 
    Document   : agecalculator
    Created on : Jan 23, 2023, 8:48:49 PM
    Author     : Hussein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form action="age" method="post">
            Enter your age: <input type="text" name="newAge" value="${newAge}"><br>
            <input type="submit" value="Age next Calculator">
        </form>
            <p>${answer}</p>
            <a href="arithmeticcalculator.jsp">Arithmetic calculator</a>
    </body>
</html>
