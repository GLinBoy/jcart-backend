package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class Order extends BaseEntity {
    private User user;
    private OrderStatus status;
    private Set<Coupon> coupons;
    private UserAddress address;
    private List<Product> products;
    private LocalDate ordreDate;
    private UserAddress deliveryAddress;
    private UserAddress factorAddress;
    private LocalDate deliveryDate;
    private String description;
}
