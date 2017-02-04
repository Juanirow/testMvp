package com.nakva.mvp.Register;

import com.nakva.mvp.Helpers.InputsValidator;

/**
 * Created by Juancho on 04/02/17.
 * Nakva
 * linanjm90@gmail.com
 */

public class RegisterPreseter implements IRegisterPresenter {

    IRegisterView mView;
    IRegisterModel mModel;


    public RegisterPreseter(IRegisterView mView, IRegisterModel mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

    @Override
    public void onClickRegisterBtn() {
        String email;

        email = this.mView.getEmail();
        if(!this.verifyEmail(email)) return;
    }

    private boolean verifyEmail(String email){
        if(!InputsValidator.isTextNotEmpty(email)){
            this.mView.showEmailErorrEmptyMsg();
           return false;
        }

        if(!InputsValidator.isEmailFormatValid(email)){
            this.mView.showEmailErrorInvalidMsg();
            return false;
        }

        return true;
    }
}
