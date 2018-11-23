package ir.sargoll.shop.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter @Setter
public abstract class BaseEntity extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive;
}
