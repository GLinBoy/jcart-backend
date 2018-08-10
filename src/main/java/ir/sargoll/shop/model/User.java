package ir.sargoll.shop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter @Setter
public class User extends BaseEntity {
    @Column
    private String name;

    @Column
    private String family;

    @Column (unique = true)
    private String email;

    @Column (unique = true)
    private String mobile;

    @Column
    private String password;

    @Column
    private Boolean isDeleted;

    @JsonManagedReference
    @OneToMany (fetch= FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.ALL})
    private List<UserAddress> addresses;

    @Transient
    private Double level;

    @ManyToMany
    @JoinTable(name = "JOIN_USERS_GROUPS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID")
    )
    private List<UserGroup> groups;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.ALL})
    private List<Discount> discounts;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.ALL})
    private List<Order> orders;

    @OneToOne
    @JoinColumn(name = "SETTING_ID")
    private Setting setting;

    @Enumerated(EnumType.STRING)
    private UserGender gender;

    @Column
    private Boolean verifiedEmail;

    @Column
    private Boolean verifiedMobile;

    @Transient
    private Long wallet;
}
