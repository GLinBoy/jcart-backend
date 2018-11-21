package ir.sargoll.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "IMAGE",
        uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_IMAGE", columnNames = "NAME")
})
@Getter @Setter
public class Image extends BaseEntity {
    @Column
    private String name;

    @Column
    private String path;

    @Column
    private Integer ordering;
}
