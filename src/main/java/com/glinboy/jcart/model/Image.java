package com.glinboy.jcart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "IMAGE",
        uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_IMAGE", columnNames = "NAME")
})
@Data
@EqualsAndHashCode(callSuper=true)
public class Image extends BaseEntity {
    @Column
    private String name;

    @Column
    private String path;

    @Column
    private Integer ordering;
}
