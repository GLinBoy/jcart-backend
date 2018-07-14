package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter @Setter
public class Setting extends BaseEntity {
    private Locale locale;
    private String region;
}
