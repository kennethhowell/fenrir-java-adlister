package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import util.Config;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchProductServlet", urlPatterns = "/searchProduct")
public class SearchProductServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {


      try {

          Config localConfig = new Config();
          Connection connection = DriverManager.getConnection(
                  localConfig.getUrl(),
                  localConfig.getUser(),
                  localConfig.getPassword()
          );

//          Statement searchStmt = connection.createStatement();
//Refactoring: We're going to use a preparedStmt to protect against SQL injection attacks



          String searchTerm = request.getParameter("search");

          String sql = "SELECT * FROM products WHERE name LIKE ?";

          String userSearch = "%" + searchTerm + "%";

          PreparedStatement searchStmt = connection.prepareStatement(sql);

          searchStmt.setString(1, userSearch);

          ResultSet results = searchStmt.executeQuery();

          Product foundProduct = new Product();
          List<Product> listToView = new ArrayList<>();
          while (results.next()) {

              listToView.add(new Product(results.getString("name"), results.getDouble("price")));
          }

          //Now I can populate a view with the List of objects I went and retrieved (currently are in a variable called listToView)
          // Pass the data to the jsp
          System.out.println("Data here");
          System.out.println(listToView);
          request.setAttribute("viewProducts", listToView);
          request.setAttribute("searchTerm", searchTerm);
          request.getRequestDispatcher("/products/index.jsp").forward(request, response);

      } catch (SQLException e){
          e.printStackTrace();
      }


  }

}
