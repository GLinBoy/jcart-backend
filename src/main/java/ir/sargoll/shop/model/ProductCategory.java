package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class ProductCategory extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private ProductCategory parent;

    @OneToOne
    @JoinColumn(name = "IMAGE_ID")
    private Image image;
}
