import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContactServlet", urlPatterns = "/contacts")
public class ContactServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Contacts contactsDoa = DaoFactory.contactsDoa();
        List<Contact> contacts = DaoFactory.contactsDoa().getContacts(); //
        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("/contacts.jsp").forward(request, response);
    }
}
