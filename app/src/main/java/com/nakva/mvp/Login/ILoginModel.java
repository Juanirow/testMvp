package com.nakva.mvp.Login;

/**
 * Created by Juancho on 28/01/17.
 * Nakva
 * linanjm90@gmail.com
 */

public interface ILoginModel {

    void sendLoginRequest(String email, String password,
                          ILoginModelCallback callback);
}
