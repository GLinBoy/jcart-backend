package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Content extends BaseEntity {
    private String title;
    private String content;
}
