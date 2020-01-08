import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderFormServlet", urlPatterns = "/order")
public class OrderFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "text/html");
        response.getWriter().println("<form method='GET' action='/summary'>" +
                "<label for='pro'> Enter the product you want:</label>" +
                "<input type='text' id='pro' name='pro'>" +
                "<label for='num'>Enter amount: </label>" +
                "<input type='number' id='num' name='num'>" +
                "<button type='submit'>Checkout</button>" +
                "</form>");
    }
}
