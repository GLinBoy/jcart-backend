package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductCategory {
    private String name;
    private String description;
    private ProductCategory parent;
    private CategoryImage image;
}
