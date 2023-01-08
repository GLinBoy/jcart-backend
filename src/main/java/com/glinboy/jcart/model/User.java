package com.glinboy.jcart.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "USERS")
@EqualsAndHashCode(callSuper=true)
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

    @Column (nullable = false)
    private Boolean isDeleted = Boolean.FALSE;

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

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.ALL})
    private List<Discount> discounts;

    @JsonBackReference
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

    @Column (nullable = false, unique = true)
    private String codeIntroducing;

    @Column
    private String codeReagent;

    @Transient
    private Long wallet;

    @JsonProperty
    public String getFullName() {
        return this.name + " " + this.family;
    }
}
