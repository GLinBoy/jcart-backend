package ir.sargoll.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=true)
public class Discount  extends BaseEntity {

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "USR_ID")
    private User user;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column
    private Double percent;

    @Column
    private Double ceiling;
}
