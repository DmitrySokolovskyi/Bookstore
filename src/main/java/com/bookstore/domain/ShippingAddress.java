package com.bookstore.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity @Data
public class ShippingAddress {

    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String shippingAddressName;
    private String shippingAddressStreet1;
    private String shippingAddressStreet2;
    private String shippingAddressCity;
    private String shippingAddressState;
    private String shippingAddressCountry;
    private String shippingAddressZipcode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
