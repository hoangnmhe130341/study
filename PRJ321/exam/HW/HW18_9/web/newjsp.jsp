<%-- 
    Document   : newjsp
    Created on : Sep 18, 2019, 7:51:48 AM
    Author     : sonnt
--%>

<%@page import="entity.Circle"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Circle> cirs = (ArrayList<Circle>) request.getAttribute("data");
        %>
    </head>
    <body>
        <canvas id="myCanvas" width="1000" height="1000" style="border:1px solid #d3d3d3;">
            Your browser does not support the HTML5 canvas tag.</canvas>
        <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            var cursorX;
            var cursorY;

            <%
                for (Circle cir : cirs) {
            %>
            ctx.beginPath();
            ctx.strokeStyle = "rgb(<%=cir.getR()%>,<%=cir.getG()%>,<%=cir.getB()%>)";
            ctx.arc(<%=cir.getX()%>, <%=cir.getY()%>, <%=cir.getRadius()%>, 0, 2 * Math.PI);
            ctx.stroke();
            <%}%>
            document.addEventListener('click', printMousePos);

            function printMousePos(e) {
                cursorX = e.pageX;
                cursorY = e.pageY;
                var s = "";
                var cirX=0;
                var cirY=0;
                var cirR=0;
            <%for (Circle cir : cirs) {
            %>
                cirX = <%=cir.getX()%>
                cirY = <%=cir.getY()%>
                cirR = <%=cir.getRadius()%>
                if (Math.sqrt(Math.pow(cursorX - cirX, 2) + Math.pow(cursorY - cirY, 2)) <= cirR) {
                    s +="<%=cir.getName()%>\n";
                }
            <%}%>
                if (s !== "") {
                    alert(s);
                }
            }

        </script> 
    </body>
</html>
