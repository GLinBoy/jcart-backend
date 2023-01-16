package com.glinboy.jcart.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=true)
public class UserTransaction extends BaseEntity {

    @Column
    private LocalDate date;

    @Column
    private Double price;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", unique = true)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
