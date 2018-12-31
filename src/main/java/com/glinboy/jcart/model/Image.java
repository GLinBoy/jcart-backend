package com.glinboy.jcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
