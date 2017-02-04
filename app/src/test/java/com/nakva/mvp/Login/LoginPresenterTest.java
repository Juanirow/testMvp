package com.nakva.mvp.Login;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by Juancho on 28/01/17.
 * Nakva
 * linanjm90@gmail.com
 */
public class LoginPresenterTest {

    @Mock
    ILoginView mView;

    @Mock
    ILoginModel mModel;

    ILoginPresenter mPresenter;

    public LoginPresenterTest() {
        MockitoAnnotations.initMocks(this);

        this.mPresenter = new LoginPresenter(mView, mModel);
    }

    @Test
    public void shouldEmailNotEmpty() throws Exception {
        Mockito.when(this.mView.getEmail()).thenReturn("");

        this.mPresenter.onClickLogin();

        Mockito.verify(this.mView).getEmail();
        Mockito.verify(this.mView).showEmailEmptyError();
    }

    @Test
    public void shouldShowErrorWhenEmailIsNotValid() throws Exception {
        Mockito.when(this.mView.getEmail()).thenReturn("asñlasd");

        this.mPresenter.onClickLogin();

        Mockito.verify(this.mView).getEmail();
        Mockito.verify(this.mView).showEmailInvalidError();
    }

    @Test
    public void shouldShowErrorWhenPasswordEmpty() throws Exception {
        Mockito.when(this.mView.getEmail()).thenReturn("asñ@lasd");
        Mockito.when(this.mView.getPassword()).thenReturn("");

        this.mPresenter.onClickLogin();

        Mockito.verify(this.mView).getEmail();
        Mockito.verify(this.mView).getPassword();
        Mockito.verify(this.mView).showPasswordEmptyError();

    }

    @Test
    public void shouldShowInternalServerError() throws Exception {
        ArgumentCaptor<ILoginModelCallback> callbackCaptor
                = ArgumentCaptor.forClass(ILoginModelCallback.class);

        String email = "unEmail@nakva.com";
        String password = "nailah";

        Mockito.when(this.mView.getEmail()).thenReturn(email);
        Mockito.when(this.mView.getPassword()).thenReturn(password);

        this.mPresenter.onClickLogin();

        Mockito.verify(this.mView).getEmail();
        Mockito.verify(this.mView).getPassword();

        Mockito.verify(this.mModel).sendLoginRequest(
                Mockito.eq(email),
                Mockito.eq(password),
                callbackCaptor.capture()
        );

        callbackCaptor.getValue().onInternalServerError();

        Mockito.verify(this.mView).showInternalServerError();

    }


    @Test
    public void shoulShowWrongCredentialsError() throws Exception {
        ArgumentCaptor<ILoginModelCallback> callbackCaptor
                = ArgumentCaptor.forClass(ILoginModelCallback.class);

        String email = "unEmail@nakva.com";
        String password = "nailah";

        Mockito.when(this.mView.getEmail()).thenReturn(email);
        Mockito.when(this.mView.getPassword()).thenReturn(password);

        this.mPresenter.onClickLogin();

        Mockito.verify(this.mView).getEmail();
        Mockito.verify(this.mView).getPassword();

        Mockito.verify(this.mModel).sendLoginRequest(
                Mockito.eq(email),
                Mockito.eq(password),
                callbackCaptor.capture()
        );

        callbackCaptor.getValue().onWrongCredentials();

        Mockito.verify(this.mView).showWrongCredentialsError();

    }
}