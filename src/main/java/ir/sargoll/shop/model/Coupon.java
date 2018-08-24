package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;

@Entity
@Table (uniqueConstraints = @UniqueConstraint(name = "UNQ_COUPON", columnNames = {"CODE"}))
@Getter @Setter
public class Coupon extends BaseEntity {
    @Column
    private Double percent;

    @Column
    private Double ceiling;

    @Column
    private String code;

    @Column
    private LocalDate start;

    @Column
    private LocalDate end;
}
