<%-- 
    Document   : list
    Created on : Sep 25, 2019, 4:42:46 PM
    Author     : sonnt
--%>

<%@page import="model.Employee"%>
<%@page import="model.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Department> depts = (ArrayList<Department>)request.getAttribute("depts");
            ArrayList<Employee> emps = (ArrayList<Employee>)request.getAttribute("emps");           
            Integer did = (Integer)request.getAttribute("did");
        %>
    </head>
    <body>
        <form action="list" method="get" id="frm">
            <select name="did" onchange="document.getElementById('frm').submit();">
            <option value="0">---------ALL---------</option>
            <%for (Department d : depts) {
            %>
            <option <%=(d.getId()==did)?"selected":"" %> value="<%=d.getId()%>"><%=d.getName()%></option>
            <%}%>
        </select>  
        </form>
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Dob</td>
                <td>Gender</td>
                <td>Department</td>
                <td></td>
            </tr>
            <%for (Employee e : emps) {
            %>
             <tr>
                <td><%=e.getId()%></td>
                <td><%=e.getName()%></td>
                <td><%=e.getDob()%></td>
                <td>
                    <img src="img/<%=e.isGender()?"Male-Face-F5-icon.png":"browser-girl-firefox-icon.png" %>" alt=""/>
                </td>
                <td><%=e.getDept().getName()%></td>
                <td><a href="update?id=<%=e.getId()%>">Edit</a></td>
            </tr>
            <%}%>
        </table>    
        
        
    </body>
</html>
