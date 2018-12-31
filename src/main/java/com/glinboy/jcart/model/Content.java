package com.glinboy.jcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=true)
public class Content extends BaseEntity {
    @Column
    private String title;

    @Column
    private String content;
}
