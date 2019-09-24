package simpleshop.service;

import simpleshop.entity.Product;

import java.util.List;

public class ProductService {

    DAO dao;

    public ProductService(DAO dao) {
        this.dao = dao;
    }

    public List<Product> findAll() {

        List<Product> products = dao.findAllProduct();

        return products;
    }
}
