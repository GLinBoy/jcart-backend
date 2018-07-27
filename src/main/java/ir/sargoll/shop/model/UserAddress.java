package ir.sargoll.shop.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class UserAddress extends BaseEntity {

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
