package com.algodomain.task.service.impl;

import com.algodomain.task.entity.Charges;
import com.algodomain.task.entity.Product;
import com.algodomain.task.exception.ResourceNotFoundException;
import com.algodomain.task.repository.ProductRepository;
import com.algodomain.task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {

        //----------------Final Price Calculation--------------------
        double discountAmount = product.getBasePrice() * (product.getDiscount() / 100);
        Charges charges = product.getCharges();
        double gstAmount = product.getBasePrice() * (charges.getGst() / 100);

        double finalPrice = product.getBasePrice()+gstAmount-discountAmount;
        product.setFinalPrice(finalPrice);
      // ------------------------------------------------------------------

        return this.productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer productId) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        //-------------GST Amount and Discount Amount Calculation-------------------------------------
        double discountAmount = product.getBasePrice() * (product.getDiscount() / 100);
        Charges charges = product.getCharges();
        double gstAmount = product.getBasePrice() * (charges.getGst() / 100);

        charges.setGst((float) gstAmount);
        product.setDiscount(discountAmount);
        product.setCharges(charges);

        double finalPrice = product.getBasePrice()+gstAmount-discountAmount;
        product.setFinalPrice(finalPrice);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = this.productRepository.findAll();

        //Calculation of percentage to amount (GST, DISCOUNT, FINAL PRICE)
        List<Product> updateProductList = products.stream()
                .peek(product -> {
                    double originalPrice = product.getBasePrice();
                    double gstAmount = originalPrice * (product.getCharges().getGst() / 100);
                    double discountAmount = originalPrice * (product.getDiscount() / 100);
                    double finalPrice = originalPrice + gstAmount - discountAmount;

                    Charges charges = product.getCharges();
                    charges.setGst((float) gstAmount);

                    product.setCharges(charges);
                    product.setDiscount(discountAmount);
                    product.setFinalPrice(finalPrice);

                }).collect(Collectors.toList());

        return updateProductList;
    }

    @Override
    public Product updateProductById(Product product, Integer productId) {
        Product product1 = this.productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        // calculating final price
        double basePrice = product.getBasePrice();
        double discount = product.getDiscount();
        Charges charges = product.getCharges();
        float gst = charges.getGst();
        float delivery = charges.getDelivery();
        double finalPrice = (basePrice + gst + delivery) - discount;
       //-----------------------------------------------------------------------

//        product1.setFinalPrice((basePrice + gst + delivery) - discount);
        product1.setFinalPrice(finalPrice);
        product1.setProductId(product.getProductId());
        product1.setName(product.getName());
        product1.setProductType(product.getProductType());
        product1.setCharges(product.getCharges());
        product1.setCategory(product.getCategory());
        product1.setDiscount(discount);
        product1.setBasePrice(basePrice);

        return this.productRepository.save(product1);
    }

    @Override
    public void deleteProductById(Integer productId) {
        Product product = this.productRepository
                .findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        this.productRepository.delete(product);
    }
}
