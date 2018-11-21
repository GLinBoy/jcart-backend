package ir.sargoll.shop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    private List<OrderItem> items;

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
