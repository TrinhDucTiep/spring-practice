package com.example.hellospring.springsecurity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "userSecurity")
@Data
public class UserSecurity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;

}
