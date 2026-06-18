package com.aazizdev.resourcehub.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.management.relation.Role;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users")

public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "admin_id")
    private UUID adminId;

    @Column(name = "email", nullable = false,unique = true)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String  role;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;


    public  AppUser() {
    }

    //set and get userId
    public void setUserId(UUID userId){
        this.userId = userId;
    }
    public UUID getUserId(){
        return userId;
    }

    //set and get adminId
    public void setAdminId(UUID adminId){
        this.adminId = adminId;
    }
    public UUID getAdminId(){
        return adminId;
    }

    //set and get email
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    //set and get fullName
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getFullName(){
        return fullName;
    }

    //set and get password
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    //set and get role
    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }

    //set and get status
    public void setStatus(Boolean status){
        this.status = status;
    }
    public Boolean getStatus(){
        return status;
    }

    //Just get createdAt
    public Instant getCreatedAt(){
        return createdAt;
    }

    //Just get updatedAt
    public Instant getUpdatedAt(){
        return updatedAt;
    }






}



