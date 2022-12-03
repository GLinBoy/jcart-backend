package com.glinboy.jcart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class ProductOrderItem extends Product {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="ORDER_ID", updatable = false)
    private Order order;

    @Column
    private Integer number;
}
