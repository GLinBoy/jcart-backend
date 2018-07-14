package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Product extends BaseEntity {
    private String name;
    private String description;
    private List<ProductAtributie> atributies;
    private Double price;
    private List<ProductComment> commencts;
    private Double rate;
    private String code;
    private List<ProductCategory> categories;
    private List<ProductImage> images;
    private ProductCoupon coupon;
}
