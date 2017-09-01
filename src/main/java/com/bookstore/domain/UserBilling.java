package com.bookstore.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;

@Entity @Data
public class UserBilling {

    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String userBillingName;
    private String userBillingStreet1;
    private String userBillingStreet2;
    private String userBillingCity;
    private String userBillingState;
    private String userBillingCountry;
    private String userBillingZipcode;

    @OneToOne(cascade = ALL)
    private UserPayment userPayment;
}
