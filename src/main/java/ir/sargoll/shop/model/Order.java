package ir.sargoll.shop.model;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDERS")
@Getter @Setter
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
