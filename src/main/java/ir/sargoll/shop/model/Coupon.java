package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Coupon extends BaseEntity {
    private Double percent;
    private Double ceiling;
    private Boolean isUsed;
    private String code;
    private LocalDate start;
    private LocalDate end;
}
