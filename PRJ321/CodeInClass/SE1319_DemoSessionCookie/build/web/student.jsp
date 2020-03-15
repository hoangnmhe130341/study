<%-- 
    Document   : student
    Created on : Sep 30, 2019, 5:19:20 PM
    Author     : sonnt
--%>

<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
           Student s = (Student)session.getAttribute("1");
        %>
    </head>
    <body>
        <h1><%=s.getName()%></h1>
    </body>
</html>
