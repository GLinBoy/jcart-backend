package com.glinboy.jcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
