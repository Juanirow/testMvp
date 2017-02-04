package com.nakva.mvp.Login;

import android.os.Handler;

/**
 * Created by Juancho on 04/02/17.
 * Nakva
 * linanjm90@gmail.com
 */

public class LoginModelMock implements ILoginModel {

    private Handler mHandler;

    public LoginModelMock() {
        this.mHandler = new Handler();
    }

    @Override
    public void sendLoginRequest(String email, String password,
                                 ILoginModelCallback callback) {

        final ILoginModelCallback c = callback;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                c.onInternalServerError();
            }
        }, 2000);
    }
}
