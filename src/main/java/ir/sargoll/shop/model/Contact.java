package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter @Setter
public class Contact extends BaseEntity {

    @Column
    String email;

    @ManyToOne
    @JoinColumn (name="ADDRESS_ID")
    UserAddress address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CONTACT_ADDRESS",
            joinColumns = @JoinColumn(name = "ADDRESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "CONTACT_ID")
    )
    List<UserAddress> agencies;
}
