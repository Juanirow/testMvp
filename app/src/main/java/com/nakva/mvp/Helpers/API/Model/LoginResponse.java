package com.nakva.mvp.Helpers.API.Model;

/**
 * Created by Juancho on 04/02/17.
 * Nakva
 * linanjm90@gmail.com
 */

public class LoginResponse {

    String email;
    String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
