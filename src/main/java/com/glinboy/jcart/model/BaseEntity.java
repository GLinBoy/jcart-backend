package com.glinboy.jcart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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
