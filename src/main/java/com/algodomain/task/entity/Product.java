package com.algodomain.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Product {

    @Id
    private int productId;
    private String name;
    private String productType;
    private String category;
    private double basePrice;
    private double discount;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Charges charges;
    private double finalPrice;

    @JsonProperty
    public double getFinalPrice() {
        return finalPrice;
    }

    @JsonIgnore
    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
