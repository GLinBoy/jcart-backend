package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Coupon extends BaseEntity {
    private Double percent;
    private Double ceiling;
    private Boolean isUsed;
}
