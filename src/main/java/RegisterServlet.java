import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        String email = request.getParameter("email");

        System.out.println("The user's email was " + email);

    }
}
