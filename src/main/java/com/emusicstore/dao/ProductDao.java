package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.util.List;

/**
 * Created by Rafael on 11/06/2016.
 */
public interface ProductDao {
    void addProduct(Product product);
    Product getProductById(Integer id);
    List<Product> getAllProducts();
    void deleteProduct(Integer id);
}
