package com.nakva.mvp.Login;

/**
 * Created by Juancho on 28/01/17.
 * Nakva
 * linanjm90@gmail.com
 */

public class LoginPresenter implements ILoginPresenter,
        ILoginModelCallback {


    private final ILoginView mView;
    private final ILoginModel mModel;

    public LoginPresenter(ILoginView mView, ILoginModel mModel) {

        this.mView = mView;
        this.mModel = mModel;
    }

    @Override
    public void onClickLogin() {
        String password;
        String email = this.mView.getEmail();

        if(!this.isEmailValid(email)){
           return;
        }

        password = this.mView.getPassword();
        if (!this.isPasswordValid(password)) {
            return;
        }

        this.mModel.sendLoginRequest(email, password, this);
    }

    private boolean isPasswordValid(String password) {
        if (password.isEmpty()) {
            this.mView.showPasswordEmptyError();
            return false;
        }
        return true;
    }

    private boolean isEmailValid(String email) {
        if(email.isEmpty()){
            this.mView.showEmailEmptyError();
            return false;
        }

        if(!email.contains("@")){
            this.mView.showEmailInvalidError();
            return false;
        }
        return true;
    }

    @Override
    public void onInternalServerError() {
        this.mView.showInternalServerError();
    }

    @Override
    public void onWrongCredentials() {
        this.mView.showWrongCredentialsError();
    }
}
