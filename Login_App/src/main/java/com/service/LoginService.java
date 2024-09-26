package com.service;
import com.model.Login;



public interface LoginService {

    void signup(Login login);

    boolean signin(String emailid, String password, String typeofuser);

}

