package com.bookstore.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.AUTO;

@Entity @Data
public class BillingAddress {

    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String billingAddressName;
    private String billingAddressStreet1;
    private String billingAddressStreet2;
    private String billingAddressCity;
    private String billingAddressState;
    private String billingAddressCountry;
    private String billingAddressZipcode;

    @OneToOne
    private Order order;
}
