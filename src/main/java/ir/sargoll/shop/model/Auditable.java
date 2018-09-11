package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public abstract class Auditable<U> {

    @CreatedBy
    @Column(name = "CREATED_BY", updatable = false, nullable = false)
    private Long createdBy;

    @LastModifiedBy
    @Column(name = "EDITED_BY", nullable = false)
    private Long editedBy;

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