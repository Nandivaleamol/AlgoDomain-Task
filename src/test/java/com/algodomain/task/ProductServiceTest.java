package com.algodomain.task;

import com.algodomain.task.entity.Charges;
import com.algodomain.task.entity.Product;
import com.algodomain.task.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    // Test case method: Create new product
    // here is use builder design pattern (@Builder)
    @Test
    public void createProductTest(){
        Charges  charges = new Charges(18,	300);
        Product product =Product.builder()
                .productId(1005)
                .name("Neelkamal Been Bag")
                .productType("Sofa Set")
                .category("Furniture")
                .discount(10)
                .basePrice(350)
                .charges(charges)
                .build();
        Product savedProduct = this.productService.createProduct(product);
        System.out.println(savedProduct);
    }

    // Test Case Method: Get Single Product
    @Test
    public void getProductTest(){
        Product product = this.productService.getProductById(1003);
        System.out.println(product);
    }

    // Test Case Method: Get All Products
    @Test
    public void getAllProducts(){
        List<Product> allProducts = this.productService.getAllProducts();
        allProducts.forEach(System.out::println);
    }

    // Test Case Method: Update Product by product id
    @Test
    public void updateProduct(){
        Charges  charges = new Charges(24,	800);
        Product product =Product.builder()
                .productId(1002)
                .name("LG Washing Machine Pro")
                .productType("Washing Machine")
                .category("Home Appliances")
                .discount(22)
                .basePrice(	20000)
                .charges(charges)
                .build();

        Product updatedProduct = this.productService.updateProductById(product, 0);
        System.out.println(updatedProduct);
    }

    // Test Case Method: Delete Product by product id
    @Test
    public void deleteProduct(){
        this.productService.deleteProductById(1002);
        System.out.println("product deleted successfully!!");
    }
}
