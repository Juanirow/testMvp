package com.nakva.mvp.Login;

/**
 * Created by Juancho on 28/01/17.
 * Nakva
 * linanjm90@gmail.com
 */

public interface ILoginView {

    String getEmail();

    void showEmailEmptyError();

    void showEmailInvalidError();

    String getPassword();

    void showPasswordEmptyError();

    void showInternalServerError();

    void showWrongCredentialsError();
}
