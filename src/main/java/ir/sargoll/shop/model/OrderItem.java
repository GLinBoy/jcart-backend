package ir.sargoll.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem extends Product {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="ORDER_ID", updatable = false)
    Order order;

    @Column
    Integer number;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", updatable = false)
    Product product;
}
