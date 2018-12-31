package com.glinboy.jcart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
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
