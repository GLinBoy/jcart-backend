package ir.sargoll.shop.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class UserGroup extends BaseEntity {

    @Column
    private String name;
}
