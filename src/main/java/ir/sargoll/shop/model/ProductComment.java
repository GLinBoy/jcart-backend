package ir.sargoll.shop.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class ProductComment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "USER_ID", updatable = false)
    private User user;

    @Column
    private String comment;

    @Column
    private Integer rate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
