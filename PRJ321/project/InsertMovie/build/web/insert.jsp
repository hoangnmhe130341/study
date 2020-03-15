<%-- 
    Document   : insert
    Created on : Oct 23, 2019, 4:45:17 PM
    Author     : hoangnm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Type"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="insert" method="POST">
            ID : <input type="text" name="id" pattern="[0-9]+" required> <br/>
            Name : <input type="text" name="name" required><br/>
            <c:forEach items="${requestScope.listT}" var="type">
                <input type="checkbox" name="type" value="${type.id}"> ${type.name} <br/>
            </c:forEach>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
