package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Circle;
import java.util.ArrayList;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");

            ArrayList<Circle> listHinhTron = (ArrayList<Circle>) request.getAttribute("data");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <canvas id=\"myCanvas\" width=\"500\" height=\"500\" style=\"border:1px solid #d3d3d3;\">\n");
      out.write("            Your browser does not support the HTML5 canvas tag.</canvas>\n");
      out.write("        <script>\n");
      out.write("            var c = document.getElementById(\"myCanvas\");\n");
      out.write("            var ctx = c.getContext(\"2d\");\n");
      out.write("\n");
      out.write("            //define class Circle\n");
      out.write("            function Circle(id, x, y, radius, speed, r, g, b, isUp, isRight, isRunning)\n");
      out.write("            {\n");
      out.write("                this.id = id;\n");
      out.write("                this.x = x;\n");
      out.write("                this.y = y;\n");
      out.write("                this.radius = radius;\n");
      out.write("                this.speed = speed;\n");
      out.write("                this.r = r;\n");
      out.write("                this.g = g;\n");
      out.write("                this.b = b;\n");
      out.write("                this.isUp = isUp;\n");
      out.write("                this.isRight = isRight;\n");
      out.write("                this.isRunning = isRunning;\n");
      out.write("\n");
      out.write("                this.draw = function (ctx)\n");
      out.write("                {\n");
      out.write("                    ctx.beginPath();\n");
      out.write("                    ctx.arc(this.x, this.y, this.radius, 0, 2 * Math.PI);\n");
      out.write("                    ctx.fillStyle = \"rgb(\" + this.r + \",\" + this.g + \",\" + this.b + \")\";\n");
      out.write("                    ctx.fill();\n");
      out.write("                    ctx.stroke();\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                this.isClicked = function (x, y)\n");
      out.write("                {\n");
      out.write("                    var distance = Math.sqrt(\n");
      out.write("                            Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)\n");
      out.write("                            );\n");
      out.write("                    return distance <= radius;\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                this.move = function ()\n");
      out.write("                {\n");
      out.write("                    if (this.isRunning)\n");
      out.write("                    {\n");
      out.write("                        if (this.isUp)\n");
      out.write("                        {\n");
      out.write("                            this.y -= this.speed;\n");
      out.write("                            if (this.y - this.radius <= 0)\n");
      out.write("                                this.isUp = false;\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            this.y += this.speed;\n");
      out.write("                            if (this.y + this.radius >= 500)\n");
      out.write("                                this.isUp = true;\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                        if (this.isRight)\n");
      out.write("                        {\n");
      out.write("                            this.x += this.speed;\n");
      out.write("                            if (this.x + this.radius >= 500)\n");
      out.write("                                this.isRight = false;\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            this.x -= this.speed;\n");
      out.write("                            if (this.x - this.radius <= 0)\n");
      out.write("                                this.isRight = true;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            var circles = [];\n");
      out.write("            circles.push(new Circle(1, 150, 150, 50, 1, 0, 0, 255, false, true, true));\n");
      out.write("\n");
      out.write("            circles.push(new Circle(2, 450, 450, 50, 2, 255, 0, 0, true, false, true));\n");
      out.write("\n");
      out.write("            function runScene()\n");
      out.write("            {\n");
      out.write("                for (var i = 0; i < circles.length; i++) {\n");
      out.write("                    circles[i].move();\n");
      out.write("                    circles[i].draw(ctx);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            function Canvas_Onclick(e)\n");
      out.write("            {\n");
      out.write("                var x = e.offsetX;\n");
      out.write("                var y = e.offsetY;\n");
      out.write("                for (var i = 0; i < circles.length; i++) {\n");
      out.write("                    if (circles[i].isClicked(x, y))\n");
      out.write("                    {\n");
      out.write("                        circles[i].isRunning = !circles[i].isRunning;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            c.addEventListener(\"mousedown\", function (e) {\n");
      out.write("                Canvas_Onclick(e);\n");
      out.write("            });\n");
      out.write("            setInterval(runScene,10);\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
