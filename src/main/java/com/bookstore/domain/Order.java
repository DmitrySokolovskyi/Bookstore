package com.bookstore.domain;

import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;

@Entity @Data
@Table(name = "user_order")
public class Order {

    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private Date orderDate;
    private Date shippingDate;
    private String shippingMethod;
    private String orderStatus;
    private BigDecimal orderTotal;

    @OneToMany(mappedBy = "order", cascade = ALL)
    private List<CartItem> cartItemList;

    @OneToOne(cascade = ALL)
    private ShippingAddress shippingAddress;

    @OneToOne(cascade = ALL)
    private Payment payment;

    @ManyToOne
    private User user;
}
