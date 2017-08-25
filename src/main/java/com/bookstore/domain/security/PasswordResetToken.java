package com.bookstore.domain.security;

import com.bookstore.domain.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
public class PasswordResetToken {

    private static final int EXPIRATION = 60 * 24;

    @Id @GeneratedValue(strategy = AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private Date expiryDate;

    public PasswordResetToken() {
    }

    public PasswordResetToken(final String token, final User user) {
        super();

        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public void updateToken(final String token) {
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }
}
