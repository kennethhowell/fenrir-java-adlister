package dao;

import util.Config;

public class DaoFactory {
    private static ProductsDao productsDao; //A field of the interface we want to build one of
    static Config config = new Config();

    public static ProductsDao getProductsDao() { //When you call this method. .
        if (productsDao == null) { //If there were no productDao objects around, make one:
            productsDao = new MySQLProductsDao(config);
        }

        //Otherwise, get the one that exists:
        return productsDao;
    }

}
