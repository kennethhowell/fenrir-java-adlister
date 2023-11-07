package dao;

import com.mysql.cj.jdbc.Driver;
import models.Product;
import util.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLProductsDao implements ProductsDao {
    private Connection connection = null;

    public MySQLProductsDao(Config config){

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch ( SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }

    }
    @Override
    public List<Product> all() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");
            return createProductsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public long insert(Product product) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(createInsertQuery(product), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }


    private String createInsertQuery(Product product) {
        return "INSERT INTO products(name, price) VALUES "
                + "(" + "'" + product.getName() +"', "
                + "'" + product.getPrice() + "')";
    }

    private Product extractProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("price")
        );
    }



    private List<Product> createProductsFromResults(ResultSet rs) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            products.add(extractProduct(rs));
        }
        return products;
    }
}
