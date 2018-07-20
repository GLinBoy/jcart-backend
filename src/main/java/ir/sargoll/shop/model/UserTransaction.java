package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class UserTransaction extends BaseEntity {
    private LocalDate date;
    private Double price;
    private TransactionStatus status;
    private Order order;
    private User user;
}
