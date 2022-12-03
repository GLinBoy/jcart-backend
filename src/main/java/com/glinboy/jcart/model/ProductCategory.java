package com.glinboy.jcart.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
