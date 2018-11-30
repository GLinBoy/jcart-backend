package ir.sargoll.shop.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=true)
public class UserAddress extends BaseEntity {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "USER_ID", updatable = false)
    private User user;

    @Column
    private String deliveryName;

    @Column
    private String address;

    @Column
    private String country;

    @Column
    private String state;

    @Column
    private String city;

    @Column
    private String zipCode;

    @Column
    private String phone;

    @Column
    private String longitude;

    @Column
    private String latitude;
}
