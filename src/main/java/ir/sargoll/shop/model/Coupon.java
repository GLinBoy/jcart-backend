package ir.sargoll.shop.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table (uniqueConstraints = @UniqueConstraint(name = "UNQ_COUPON", columnNames = {"CODE"}))
@Data
@EqualsAndHashCode(callSuper=true)
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
