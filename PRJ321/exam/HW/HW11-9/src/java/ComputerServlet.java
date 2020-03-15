
import java.awt.Color;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 84963
 */
@WebServlet(urlPatterns = "/computer/do")
public class ComputerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random r = new Random();
        double num1 = Double.parseDouble(req.getParameter("A"));
        double num2 = Double.parseDouble(req.getParameter("B"));
        String operator = req.getParameter("operator");
        double results = 0;
        switch (operator) {
            case "+":
                results = num1 + num2;
                break;
            case "-":
                results = num1 - num2;
                break;
            case "x":
                results = num1 * num2;
                break;
            case "/":
                results = num1 / num2;
                break;
        }        
        resp.getWriter().println("<html>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("Results: <span style='color:rgb("+r.nextInt(255)+","+r.nextInt(255)+","+r.nextInt(255)+");'>" + results + "</span>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
