<%-- 
    Document   : index
    Created on : Nov 4, 2019, 8:11:40 PM
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
        <h1>Username : ${requestScope.dbUsername}</h1>
        <h1>pass : ${requestScope.dbPassword}</h1>
    </body>
</html>
