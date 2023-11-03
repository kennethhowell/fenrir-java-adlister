package dao;

import models.Product;

import java.util.List;

public interface ProductsDao {

    List<Product> all();
    void insert(Product product);
}