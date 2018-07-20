package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class About extends BaseEntity {
    String email;
    UserAddress address;
    List<UserAddress> agencies;
}
