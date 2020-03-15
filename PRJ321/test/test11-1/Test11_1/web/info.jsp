<%-- 
    Document   : info
    Created on : Nov 1, 2019, 12:17:46 PM
    Author     : hoangnm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .tdl{
                  border-right: 2px solid black; 
                  border-bottom: 2px solid black; 
                  padding: 0px;
            }
            .tdr{
                  border-bottom: 2px solid black;  
            }
            table{
                 border-top: 2px solid black;  
                 border-left:  2px solid black;  
                 border-right:  2px solid black;  
            }
        </style>
    </head>
    <body>
        <h1>User : ${sessionScope.username}</h1>
        <table style="width: 50%; height: 300px;" >
            <tr>
                <td class="tdl" style="height: 50px;">ID</td>
                <td class="tdr" style="height: 50px;">Name</td>
            </tr>
            <c:forEach items="${listG}" var="group">
                <tr>
                    <td class="tdl">${group.id}</td>
                    <td class="tdr">${group.name}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
