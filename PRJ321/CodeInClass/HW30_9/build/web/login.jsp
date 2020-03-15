<%-- 
    Document   : login
    Created on : Oct 2, 2019, 10:43:22 AM
    Author     : Lenovo
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User u = (User) session.getAttribute("user");
        %>                
        <%if (u != null) {%>
        <form action="login" method="POST">
            <input type="text" name="user" placeholder="User" value="<%=u.getUser()%>"> <br/>
            <input type="password" name="pass" placeholder="Password" value="<%=u.getPass()%>"> <br/>
            <input type="submit" value="Login">
        </form>
        <%} else { %>
        <form action="login" method="POST">
            <input type="text" name="user" placeholder="User"> <br/>
            <input type="password" name="pass" placeholder="Password"> <br/>
            <input type="submit" value="Login">
        </form>
        <%}%>
    </body>
</html>
