package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class Discount  extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "USR_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @Column
    private Double percent;
    @Column
    private Double ceiling;
    @Column
    private Boolean isUsed;
}
