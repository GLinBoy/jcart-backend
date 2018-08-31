package ir.sargoll.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Getter @Setter
public class Product extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(name = "JOIN_PRODUCTS_ATTRIBUTES",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "ATTRIBUTE_ID")
    )
    private List<ProductAttribute> attributes;

    @Column
    private Double price;

    @JsonManagedReference
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "product", cascade = {CascadeType.ALL})
    private List<ProductComment> comments;

    @Transient
    private Double rate;

    @Column
    private String code;

    @ManyToMany
    @JoinTable(name = "JOIN_PRODUCTS_CATEGORIES",
        joinColumns = @JoinColumn(name = "PRODUCT_ID"),
        inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
    )
    private List<ProductCategory> categories;

    @OneToMany
    private List<Image> images;

    @JsonBackReference
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "product")
    private Set<Discount> discounts;

    @Column
    private Integer points;

    @Column
    private Integer requirementPoints;

    @JsonManagedReference
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "product")
    private List<OrderItem> items;
}
