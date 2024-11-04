package com.example.expenseproj.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private String email;
    private String passwordHash;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)

    private List<Expense> expenses;
}
