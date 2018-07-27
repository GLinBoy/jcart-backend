package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter @Setter
public class UserTransaction extends BaseEntity {

    @Column
    private LocalDate date;

    @Column
    private Double price;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
