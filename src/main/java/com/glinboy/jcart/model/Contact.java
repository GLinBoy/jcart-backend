package com.glinboy.jcart.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=true)
public class Contact extends BaseEntity {

    @Column
    String email;

    @ManyToOne
    @JoinColumn (name="ADDRESS_ID")
    UserAddress address;

    @ManyToMany
    @JoinTable(name = "JOIN_CONTACTS_ADDRESSES",
            joinColumns = @JoinColumn(name = "ADDRESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "CONTACT_ID")
    )
    List<UserAddress> agencies;
}
