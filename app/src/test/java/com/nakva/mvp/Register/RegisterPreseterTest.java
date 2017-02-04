package com.nakva.mvp.Register;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by Juancho on 04/02/17.
 * Nakva
 * linanjm90@gmail.com
 */
public class RegisterPreseterTest {

    @Mock
    IRegisterView mView;

    @Mock
    IRegisterModel mModel;

    IRegisterPresenter mPresenter;

    public RegisterPreseterTest() {
        MockitoAnnotations.initMocks(this);

        mPresenter = new RegisterPreseter(this.mView, this.mModel);
    }

    @Test
    public void shouldShowErrorWhenEmailEmpty() throws Exception {
        Mockito.when(this.mView.getEmail()).thenReturn("");

        this.mPresenter.onClickRegisterBtn();

        Mockito.verify(this.mView).getEmail();
        Mockito.verify(this.mView).showEmailErorrEmptyMsg();
    }

    @Test
    public void shouldShowErrorEmailInvalid() throws Exception {
        Mockito.when(this.mView.getEmail()).thenReturn("adsfadsf");

        this.mPresenter.onClickRegisterBtn();
        Mockito.verify(this.mView).getEmail();
        Mockito.verify(this.mView).showEmailErrorInvalidMsg();
    }
}