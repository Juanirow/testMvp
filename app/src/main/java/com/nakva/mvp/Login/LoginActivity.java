package com.nakva.mvp.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.nakva.mvp.Injectors.Injector;
import com.nakva.mvp.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Juancho on 04/02/17.
 * Nakva
 * linanjm90@gmail.com
 */

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.input_email)
    EditText inputEmail;

    @BindView(R.id.input_password)
    EditText inputPassword;

    @BindView(R.id.label_error)
    TextView labelError;


    ILoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        this.mPresenter = new LoginPresenter(this, Injector.provideInjector());
    }

    @Override
    public String getEmail() {
        return this.inputEmail.getText().toString().trim();
    }

    @Override
    public void showEmailEmptyError() {
        this.labelError.setText(R.string.error_empty_email);
    }

    @Override
    public void showEmailInvalidError() {
        this.labelError.setText(R.string.email_invalido);
    }

    @Override
    public String getPassword() {
        return this.inputPassword.getText().toString().trim();
    }

    @Override
    public void showPasswordEmptyError() {
        this.labelError.setText(R.string.error_password_empty);
    }

    @Override
    public void showInternalServerError() {
        this.labelError.setText(R.string.internal_error);

    }

    @Override
    public void showWrongCredentialsError() {

    }

    @OnClick(R.id.btn_login)
    public void onClickLogin(){
        this.mPresenter.onClickLogin();
    }
}

