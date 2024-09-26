package com.model;
import org.springframework.stereotype.Component;



@Component

public class Login {

    private String emailid;

    private String password;

    private String typeofuser;



    // Getters and Setters

    public String getEmailid() {

        return emailid;

    }



    public void setEmailid(String emailid) {

        this.emailid = emailid;

    }



    public String getPassword() {

        return password;

    }



    public void setPassword(String password) {

        this.password = password;

    }



    public String getTypeofuser() {

        return typeofuser;

    }



    public void setTypeofuser(String typeofuser) {

        this.typeofuser = typeofuser;

    }

}
