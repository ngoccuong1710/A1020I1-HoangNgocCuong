package vn.codegym.service;

import vn.codegym.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long id);

    List<Product> findAll();

    void save(Product product);

    void remove(Product product);
}
