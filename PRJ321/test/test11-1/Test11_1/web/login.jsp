<%-- 
    Document   : login
    Created on : Nov 1, 2019, 12:00:13 PM
    Author     : hoangnm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username <br/>
            <input type="text" name="username" required> <br>
            Password <br>
            <input type="text" name="password" required> <br>
            <input type="submit" value="Login">
        </form>
        
    </body>
</html>
