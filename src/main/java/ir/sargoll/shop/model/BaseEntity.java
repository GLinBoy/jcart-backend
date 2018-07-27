package ir.sargoll.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter @Setter
public abstract class BaseEntity extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive;
}
