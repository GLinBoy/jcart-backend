package ir.sargoll.shop.model;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductImage extends BaseEntity {
    private String name;
    private String path;
    private Integer order;
}
