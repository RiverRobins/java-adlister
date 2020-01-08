import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderSummaryServlet", urlPatterns = "/summary")
public class OrderSummaryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html");
        response.getWriter().println("<p>You ordered "+ request.getParameter("num") +" of " + request.getParameter("pro") + "!</p>");
    }
}
