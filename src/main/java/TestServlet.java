import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Annotation informs the compiler what URL pattern to listen for when listening for requests
@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    // Override annotation which is overriding the default implementation from the HttpServlet class.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String greeting = request.getParameter("greeting");
        String person = request.getParameter("person");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + greeting +  " from " + person + "</h1>");
    }
}
