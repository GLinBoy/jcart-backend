package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class Menu extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String href;

    @Column
    @Enumerated(EnumType.STRING)
    private MenuTarget target;
}
