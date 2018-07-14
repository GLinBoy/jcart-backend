package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Menu extends BaseEntity {
    private String name;
    private String description;
    private String href;
    private MenuTarget target;
}
