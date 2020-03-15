<%-- 
    Document   : list
    Created on : Sep 21, 2019, 9:48:38 AM
    Author     : sonnt
--%>

<%@page import="model.Circle"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Circle> listHinhTron = (ArrayList<Circle>) request.getAttribute("data");
        %>
    </head>
    <body>
        <canvas id="myCanvas" width="500" height="500" style="border:1px solid #d3d3d3;">
            Your browser does not support the HTML5 canvas tag.</canvas>
        <form action="update" method="post">
            <% for (Circle tron : listHinhTron) {
            %>
            <input type="hidden" name="id_<%=tron.getId()%>" id="id_<%=tron.getId()%>" value="<%=tron.getId()%>"  />
            <input type="hidden" name="x_<%=tron.getId()%>" id="x_<%=tron.getId()%>" value="<%=tron.getX()%>"  />
            <input type="hidden" name="y_<%=tron.getId()%>" id="y_<%=tron.getId()%>" value="<%=tron.getY()%>"  />
            <input type="hidden" name="up_<%=tron.getId()%>" id="up_<%=tron.getId()%>" value="<%=tron.isUp()%>"  />
            <input type="hidden" name="right_<%=tron.getId()%>" id="right_<%=tron.getId()%>" value="<%=tron.isRight()%>"  />
            <input type="hidden" name="running_<%=tron.getId()%>" id="running_<%=tron.getId()%>" value="<%=tron.isRunning()%>"  />
            <%}%>
            <input type="submit" value="Save"/>
        </form>    
        
        
        <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");

            //define class Circle
            function Circle(id, x, y, radius, speed, r, g, b, isUp, isRight, isRunning)
            {
                this.id = id;
                this.x = x;
                this.y = y;
                this.radius = radius;
                this.speed = speed;
                this.r = r;
                this.g = g;
                this.b = b;
                this.isUp = isUp;
                this.isRight = isRight;
                this.isRunning = isRunning;

                this.draw = function (ctx)
                {
                    ctx.beginPath();
                    ctx.arc(this.x, this.y, this.radius, 0, 2 * Math.PI);
                    ctx.fillStyle = "rgb(" + this.r + "," + this.g + "," + this.b + ")";
                    ctx.fill();
                    ctx.stroke();
                };

                this.isClicked = function (x, y)
                {
                    var distance = Math.sqrt(
                            Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)
                            );
                    return distance <= radius;
                };

                this.move = function ()
                {
                    if (this.isRunning)
                    {
                        if (this.isUp)
                        {
                            this.y -= this.speed;
                            if (this.y - this.radius <= 0)
                                this.isUp = false;
                        } else
                        {
                            this.y += this.speed;
                            if (this.y + this.radius >= 500)
                                this.isUp = true;
                        }

                        if (this.isRight)
                        {
                            this.x += this.speed;
                            if (this.x + this.radius >= 500)
                                this.isRight = false;
                        } else
                        {
                            this.x -= this.speed;
                            if (this.x - this.radius <= 0)
                                this.isRight = true;
                        }
                    }
                };


            }

            var circles = [];
            
            <% for (Circle tron : listHinhTron) {
            %>
            circles.push(new Circle(<%=tron.getId()%>, <%=tron.getX()%>, <%=tron.getY()%>,
                    <%=tron.getRadius()%>, <%=tron.getSpeed()%>, <%=tron.getR()%>, 
                    <%=tron.getG()%>, <%=tron.getB()%>, <%=tron.isUp()%>, <%=tron.isRight()%>, <%=tron.isRunning()%>));
            <%}%>
           

            function runScene()
            {
                ctx.clearRect(0,0,500,500);
                for (var i = 0; i < circles.length; i++) {
                    circles[i].move();
                    var inputX = document.getElementById("x_"+circles[i].id);
                    inputX.value=circles[i].x;
                    var inputY = document.getElementById("y_"+circles[i].id);
                    inputY.value=circles[i].y;
                    var inputUp = document.getElementById("up_"+circles[i].id);
                    inputUp.value=circles[i].isUp;
                    var inputRight = document.getElementById("right_"+circles[i].id);
                    inputRight.value=circles[i].isRight;
                    var inputRunning = document.getElementById("running_"+circles[i].id);
                    inputRunning.value=circles[i].isRunning;
                    circles[i].draw(ctx);
                }
            }


            function Canvas_Onclick(e)
            {
                var x = e.offsetX;
                var y = e.offsetY;
                for (var i = 0; i < circles.length; i++) {
                    if (circles[i].isClicked(x, y))
                    {
                        circles[i].isRunning = !circles[i].isRunning;
                    }
                }
            }
            c.addEventListener("mousedown", function (e) {
                Canvas_Onclick(e);
            });
            setInterval(runScene,10);
        </script>
    </body>
</html>
