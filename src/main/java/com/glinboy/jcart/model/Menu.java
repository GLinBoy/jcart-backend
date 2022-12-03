package com.glinboy.jcart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
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
