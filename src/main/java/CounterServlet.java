import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int count;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count += 1;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if(req.getParameter("reset") != null && req.getParameter("reset").equals("true")) {
            count = 0;
            resp.sendRedirect("/count");
        }

        out.println("Count: " + count);


    }
}
