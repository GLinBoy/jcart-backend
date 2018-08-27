package ir.sargoll.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter @Setter
public class ProductCategory extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private ProductCategory parent;

    @OneToOne
    @JoinColumn(name = "IMAGE_ID")
    private Image image;

    @JsonBackReference
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ProductCategory> childes;
}
