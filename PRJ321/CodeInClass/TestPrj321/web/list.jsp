<%-- 
    Document   : list
    Created on : Sep 27, 2019, 5:06:09 PM
    Author     : Lenovo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("data");
        %>
    </head>
    <body>
        <table border="1">
            <tr>
                 <th>Name Student</th>
                 <th>Score</th>
             </tr>
             <% for (Student stu : students) {
             %>
             <tr>
                 <td><%=stu.getName()%></td>
                 <td><%=stu.getEx().getScore()%></td>       
             <option value="${skillName} ${(skillName eq requestScope.sName)?"selected":""}">
             </option>
             </tr>
             <%}%>
         </table>
    </body>
</html>
