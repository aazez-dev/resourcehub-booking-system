package com.aazizdev.resourcehub.dto;

public class ForgetPassword {
    private String email;

    public ForgetPassword(){

    }
    public ForgetPassword(String email){
        this.email = email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

}
