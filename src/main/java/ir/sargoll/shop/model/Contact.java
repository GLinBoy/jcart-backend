package ir.sargoll.shop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
