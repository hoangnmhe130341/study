<%-- 
    Document   : newjsp2
    Created on : Sep 20, 2019, 2:53:01 PM
    Author     : Lenovo
--%>

<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Circle"%>
<%@page import="entity.Circle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            ArrayList<Circle> cirs = (ArrayList<Circle>) request.getAttribute("data");
            Random random = new Random();
        %>
    </head>
    <body>
        <canvas id="myCanvas" width="1000" height="1000" style="border:1px solid #d3d3d3;"></canvas>
        <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            document.addEventListener('click', function (event) {
                <%
                    for (Circle cir : cirs) {                            
                %>
                if (Math.sqrt(Math.pow((<%=cir.getX()%> - event.pageX), 2) + Math.pow((<%=cir.getX()%> - event.pageY), 2)) < <%=cir.getRadius()%>) {
                    <%if(cir.isCheck()){                        
                        cir.setSpeedX(0);
                        cir.setSpeedY(0);
                        cir.setCheck(false);
                    } else {
                        cir.setSpeedX(random.nextInt(10));
                        cir.setSpeedY(random.nextInt(10));
                        cir.setCheck(true);
                    }
                    %>                            
                }
                <%}%>
            });
            function drawBall() {
                <%
                    for (Circle cir : cirs) {
                %>
                ctx.beginPath();
                ctx.arc(<%=cir.getX()%>, <%=cir.getY()%>, <%=cir.getRadius()%>, 0, Math.PI * 2);
                ctx.fillStyle = "rgb(<%=cir.getR()%>,<%=cir.getG()%>,<%=cir.getB()%>)";
                ctx.fill();
                ctx.closePath();
                
                <%}%>
            }
            function handleBall() {
            <%
                for (Circle cir : cirs) {                    
            %>    
            if (<%=cir.getX()%> < <%=cir.getRadius()%> || <%=cir.getX()%> > c.width - <%=cir.getRadius()%>) {
                    <%cir.setSpeedX(cir.getSpeedX()*-1);%>                   
                }
            if (<%=cir.getY()%> < <%=cir.getRadius()%> || <%=cir.getY()%> > c.height - <%=cir.getRadius()%>) {
                    <%cir.setSpeedY(cir.getSpeedY()*-1);%>
                }
            }
            <%}%>
            function updateBall() {
            <%for (Circle cir : cirs) {
                    cir.setX(cir.getX()+cir.getSpeedX());
                    cir.setX(cir.getX()+cir.getSpeedX());
                }
            %>
            }
            function draw() {
                ctx.clearRect(0, 0, c.width, c.height);
                drawBall();
                handleBall();
                updateBall();
                requestAnimationFrame(draw);
            }
            draw();
        </script>
    </body>
</html>
