package com.example.evenementenkalenderbe.model;

import jakarta.persistence.*;


import lombok.Data;
import org.jetbrains.annotations.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    @NotNull
    private String username;

    @Column(nullable = false)
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;


    @Column(nullable = false)
    private boolean enabled = true;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "boolean default false")
    private boolean newsletter;

    @ManyToOne
    private EventCreator eventCreator;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;
    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();



    public User() {

    }

    public void addAuthority(Authority authority) {
        authorities.add(authority);
        authority.setUsername(this.getUsername());
    }
}
