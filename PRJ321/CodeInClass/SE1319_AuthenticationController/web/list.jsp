<%-- 
    Document   : list
    Created on : Oct 2, 2019, 3:33:47 PM
    Author     : sonnt
--%>

<%@page import="util.SessionHelper"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Account account = SessionHelper.getAccountFromSession(session);
        %>
    </head>
    <body>
        Hello Mr <%=account.getDisplayName()%> <br/>
        Click <a href="logout">Here</a> to logout
    </body>
</html>
