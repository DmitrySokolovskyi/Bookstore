package com.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

@Entity @Data
public class ShoppingCart {

    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private BigDecimal grandTotal;

    @OneToMany(mappedBy = "shoppingCart", cascade = ALL, fetch = LAZY)
    @JsonIgnore
    private List<CartItem> cartItemList;

    @OneToOne(cascade = ALL)
    private User user;
}
