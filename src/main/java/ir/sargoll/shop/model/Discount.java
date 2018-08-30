package ir.sargoll.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class Discount  extends BaseEntity {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "USR_ID")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column
    private Double percent;

    @Column
    private Double ceiling;
}
