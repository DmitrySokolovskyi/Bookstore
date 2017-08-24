package com.bookstore.domain.security;

import com.bookstore.domain.User;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data @Table(name = "user_role")
public class UserRole {

    @Id @GeneratedValue(strategy = AUTO)
    private Long userRoleId;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "roleId")
    private Role role;

    private UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }
}
