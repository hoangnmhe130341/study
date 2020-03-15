<%-- 
    Document   : updateListJsp
    Created on : Sep 26, 2019, 3:16:48 PM
    Author     : 84963
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Employee> emps = (ArrayList<Employee>) request.getAttribute("emps");
        %>
    </head>
    <body>        
        <table border="1px" style="margin-bottom: 10px">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Date of birth</td>
                <td>Gender</td>
                <td>Department</td>                
            </tr>
            <%for (Employee e : emps) {
            %>
            <tr>
                <td><%=e.getId()%></td>
                <td><%=e.getName()%></td>
                <td><%=e.getDob()%></td>
                <td>
                    <img src="img/<%=e.isGender() ? "Male-Face-F5-icon.png" : "browser-girl-firefox-icon.png"%>" alt=""/>
                </td>
                <td><%=e.getDept().getName()%></td>                
            </tr>
            <%}%>
        </table> 
        <form action="update" method="post">
            <input type="hidden" value="<%=emps.get(0).getId()%>" name ="id">
            Name: <input type="text" name="name">
            </br>
            Date of birth: <input type="date" name="dob">
            </br>
            Gender: <select name = "gender">
                <option value = "false">Male</option>
                <option value = "true">Female</option>                
            </select>
            </br>
            Department: <select name = "de_id">
                <option value = "1">Information System</option>
                <option value = "2">Computer Science</option>
                <option value = "3">Information Assurance</option>
            </select>
            </br>
            <input type="submit" value="Send">
        </form>
    </body>
</html>
