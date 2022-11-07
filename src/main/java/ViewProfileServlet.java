import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Track session
        HttpSession session = request.getSession();
        // set an attribute named username, with the value of ducksOverducks
        session.setAttribute("username", "ducksOverducks");

        // print the value of the session key username to the console.
        System.out.println(session.getAttribute("username"));

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
