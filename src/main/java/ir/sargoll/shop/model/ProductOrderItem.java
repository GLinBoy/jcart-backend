package ir.sargoll.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ProductOrderItem extends Product {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="ORDER_ID", updatable = false)
    private Order order;

    @Column
    private Integer number;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", updatable = false)
    private Product product;
}
