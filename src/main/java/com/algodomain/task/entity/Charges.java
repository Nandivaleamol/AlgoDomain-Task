package com.algodomain.task.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Charges {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float gst;
    private float delivery;

    public Charges(float gst, float delivery) {
        this.gst = gst;
        this.delivery = delivery;
    }
}
