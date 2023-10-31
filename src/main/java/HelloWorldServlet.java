import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        //Parameter talks to to the KEY of a query string - /url?key=value
        //the 'key' will go in the method call to getParameter
        String name = req.getParameter("cohort");

        System.out.println("the parameter in our url said: " + name);


        res.setContentType("text/html");
         PrintWriter out = res.getWriter();
         out.println("<h1>Hello, Fenrir!</h1>");
         out.println("<h3>Happy Halloween!</h3>");
         out.println("<form method=\"POST\" action=\"/register\">\n" +
                 "    <label for=\"email\">Email:</label>\n" +
                 "    <input id=\"email\" name=\"email\" placeholder=\"Enter your email address\" />\n" +
                 "</form>\n");

    }
}
