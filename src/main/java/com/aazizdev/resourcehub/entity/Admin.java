package com.aazizdev.resourcehub.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "Admin_id")
    private UUID adminId;

    @OneToOne
    @Column(name = "user_id")
    private UUID user;
}
