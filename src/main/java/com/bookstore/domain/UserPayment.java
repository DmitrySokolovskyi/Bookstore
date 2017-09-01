package com.bookstore.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;

@Entity @Data
public class UserPayment {

    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String type;
    private String cardName;
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int cvc;
    private String holderName;
    private boolean defaultPayment;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(cascade = ALL, mappedBy = "userPayment")
    private UserBilling userBilling;
}
