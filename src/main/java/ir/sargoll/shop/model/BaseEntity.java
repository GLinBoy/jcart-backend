package ir.sargoll.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter @Setter
public abstract class BaseEntity extends Auditable<String>{
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
}
