package com.glinboy.jcart.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=true)
public class UserAddress extends BaseEntity {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "USER_ID", updatable = false)
    private User user;

    @Column
    private String deliveryName;

    @Column
    private String address;

    @Column
    private String country;

    @Column
    private String state;

    @Column
    private String city;

    @Column
    private String zipCode;

    @Column
    private String phone;

    @Column
    private String longitude;

    @Column
    private String latitude;
}
