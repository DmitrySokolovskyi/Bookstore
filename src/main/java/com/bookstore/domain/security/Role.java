package com.bookstore.domain.security;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Data
public class Role {

    @Id
    private int roleId;
    private String name;

    @OneToMany(mappedBy = "role", cascade = ALL, fetch = LAZY)
    private Set<UserRole> userRoles = new HashSet<>();
}
