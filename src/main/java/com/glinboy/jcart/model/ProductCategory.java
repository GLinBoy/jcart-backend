package com.glinboy.jcart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=true)
public class ProductCategory extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private ProductCategory parent;

    @OneToOne
    @JoinColumn(name = "IMAGE_ID")
    private Image image;

    @JsonBackReference
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ProductCategory> childes;
}
