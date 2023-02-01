package com.algodomain.task.service;

import com.algodomain.task.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    // add new product
    Product createProduct(Product product);

    // get single product by product id
    Product getProductById(Integer productId);

    // get all product list
    List<Product> getAllProducts();

    // update product by product id
    Product updateProductById(Product product, Integer productId);

    // delete product by product id
    void deleteProductById(Integer productId);


}
