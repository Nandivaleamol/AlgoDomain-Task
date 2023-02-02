package com.algodomain.task.controller;

import com.algodomain.task.entity.Product;
import com.algodomain.task.payload.ApiResponse;
import com.algodomain.task.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //create new product
    @CrossOrigin(origins = "http://localhost:4200/")
    @ApiOperation(value = "Add a new product", notes = "Adds a new product to the database")
    @PostMapping("/")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.createProduct(product));
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @ApiOperation(value = "Get a single product", notes = "Returns a of product with final price")
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId){
        return ResponseEntity.ok(this.productService.getProductById(productId));
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @ApiOperation(value = "Get a list of all products", notes = "Returns a list of all products with final price")
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(this.productService.getAllProducts());
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @ApiOperation(value = "Update an existing product", notes = "Updates an existing product in the database")
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProductById(@RequestBody Product product, @PathVariable int productId){
        return ResponseEntity.ok(this.productService.updateProductById(product,productId));
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @ApiOperation(value = "Delete a product", notes = "Deletes a product from the database")
    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse> deleteProductById(@PathVariable int productId){
        this.productService.deleteProductById(productId);
        return ResponseEntity.ok(new ApiResponse("Product deleted successfully!!",true));
    }

}
