package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class ProductPack extends BaseEntity {
    private Set<Product> products;
    private Coupon coupon;
}
