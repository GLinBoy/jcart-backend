package ir.sargoll.shop.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter @Setter
public class UserGroup extends BaseEntity {

    @Column
    private String name;
}
