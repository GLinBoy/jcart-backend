package com.glinboy.jcart.model;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "ORDERS")
@Data
@EqualsAndHashCode(callSuper=true)
public class Order extends BaseEntity {
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "USER_ID", updatable = false)
    private User user;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToMany
    @JoinTable(name = "JOIN_ORDERS_COUPONS",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "COUPON_ID")
    )
    private Set<Coupon> coupons;

    @JsonManagedReference
    @OneToMany (fetch= FetchType.LAZY, mappedBy = "order", cascade = {CascadeType.ALL})
    private List<ProductOrderItem> items;

    @Column
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "DELIVERY_ADDRESS_ID")
    private UserAddress deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "FACTOR_ADDRESS_ID")
    private UserAddress factorAddress;

    @Column
    private LocalDate deliveryDate;

    @Column
    private String description;
}
