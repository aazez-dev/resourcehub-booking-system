package com.aazizdev.resourcehub.dto;

public class AuthResponse {


    private String message;
    private String fullName;
    private String role;


    public AuthResponse (){

    }

    public AuthResponse (String message,String fullName, String role){
        this.fullName = fullName;
        this.role = role;
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getFullName(){
        return fullName;
    }

    public void setRole(String roel){
        this.role = role;
    }
    public String getRole(){
        return role;
    }



}
