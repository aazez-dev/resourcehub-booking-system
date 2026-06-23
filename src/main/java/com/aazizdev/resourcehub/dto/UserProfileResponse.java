package com.aazizdev.resourcehub.dto;

import java.time.Instant;
import java.util.UUID;

public class UserProfileResponse {

    private UUID userId;
    private String fullName;
    private String email;
    private Boolean status;
    private String role;
    private Instant joinedDate;

    public UserProfileResponse(){

    }

    public UserProfileResponse(UUID userId, String fullName, String email, Boolean status, String role, Instant joinedDate){

        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.status = status;
        this.role = role;
        this.joinedDate = joinedDate;
    }

    public void setUserId(UUID userId){
        this.userId = userId;
    }
    public UUID getUserId(){return userId;}
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }


    public void setRole(String role){
        this.role = role;
    }
    public void setJoinedDate(Instant joinedDate){
        this.joinedDate = joinedDate;
    }




    public String getFullName(){
        return fullName;
    }

    public String getEmail(){
        return email;
    }

    public String getRole(){
        return role;
    }
    public Boolean getStatus(){
        return status;
    }
    public Instant getJoinedDate(){
        return joinedDate;
    }
}
