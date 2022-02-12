package com.glinboy.jcart.model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class Auditable<U> {

    @CreatedBy
    @Column(name = "CREATED_BY", updatable = false, nullable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "EDITED_BY", nullable = false)
    private String editedBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name = "CREATED_ON", updatable = false, nullable = false)
    private Date createdOn;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name = "EDITED_ON", nullable = false)
    private Date editedOn;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

}