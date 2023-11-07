package dao;

import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ListProducts implements ProductsDao {
    private List<Product> products = new ArrayList<>();

    public ListProducts() {
       insert(new Product("flux capacitor", 100.99));
       insert(new Product("libyan uranium", 10000.99));
       insert(new Product("creepy van to do experiments in", 30000.99));
    }

    @Override
    public List<Product> all() {
        return this.products;
    }

    @Override
    public long insert(Product product) {
        //To add a product:
        // I need to ADD the incoming object to my AL
        this.products.add(product);
        return 0;
    }
}
