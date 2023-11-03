package controllers;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello-mvc")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("n"); // < talking to URL query string /. . .?name=
        // if the name is null, it means that "name" was not present in the query
        // string, and here we'll provide a default value
        if(name==null){
            name="World!";
        }else if(name.equals("bgates")){
            response.sendRedirect("https://microsoft.com");
            return;
        }
        // pass the value of the name variable to the view, and send the request
        // forward to the hello.jsp file
        request.setAttribute("name_to_view",name);
        request.getRequestDispatcher("/hello.jsp").forward(request,response);
    }

}
