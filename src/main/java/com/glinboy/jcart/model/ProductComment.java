package com.glinboy.jcart.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=true)
public class ProductComment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "USER_ID", updatable = false)
    private User user;

    @Column
    private String comment;

    @Column
    private Integer rate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
