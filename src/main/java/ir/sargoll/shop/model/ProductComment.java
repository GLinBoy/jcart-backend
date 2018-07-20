package ir.sargoll.shop.model;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductComment extends BaseEntity {
    private User user;
    private String comment;
    private Integer rate;
}
