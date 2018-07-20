package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class User extends BaseEntity {
    private String name;
    private String family;
    private String email;
    private String mobile;
    private String password;
    private List<UserAddress> addresses;
    private UserLevel level;
    private List<UserGroup> groups;
    private List<Discount> discounts;
    private List<Order> orders;
    private Setting setting;
    private UserGender gender;
    private Boolean verifiedEmail;
    private Boolean verifiedMobile;
    private Long wallet;
}
