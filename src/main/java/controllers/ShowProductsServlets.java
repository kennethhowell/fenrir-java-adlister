package controllers;

import dao.DaoFactory;
import dao.ProductsDao;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ShowProductsServlets", urlPatterns = "/products")
public class ShowProductsServlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ProductsDao productsDao = DaoFactory.getProductsDao(); //Go run this method- in the factory, this will either get the existing DAO or create one as described in the method body

        //I want to store all the products I retrieve via all into a local variable

        List<Product> listToView = productsDao.all();

        //Now I can populate a view with the List of objects I went and retrieved (currently are in a variable called listToView)
        // Pass the data to the jsp
        System.out.println("Data here");
        System.out.println(listToView);
        request.setAttribute("viewProducts", listToView);
        request.getRequestDispatcher("/products/index.jsp").forward(request, response);

    }

}
