package com.glinboy.jcart.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;


@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data 
@EqualsAndHashCode(callSuper=true)
public abstract class BaseEntity extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive;
}
