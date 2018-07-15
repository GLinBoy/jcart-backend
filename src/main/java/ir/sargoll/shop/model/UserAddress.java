package ir.sargoll.shop.model;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserAddress extends BaseEntity {
    private User user;
    private String deliveryName;
    private String address;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private String phone;
    private String longitude;
    private String latitude;
}
