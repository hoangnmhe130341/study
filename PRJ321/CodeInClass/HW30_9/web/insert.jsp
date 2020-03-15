<%-- 
    Document   : insert
    Created on : Oct 2, 2019, 11:41:19 AM
    Author     : hoangnm
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
            <%if(u!=null) { %>
                <h1><%=u.getUser()%></h1>
                <h1><%=u.getPass()%></h1>
            <%} else { %>
                <h1>Access denied</h1>
            <%}%>
    </body>
</html>
