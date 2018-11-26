package ir.sargoll.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=true)
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
