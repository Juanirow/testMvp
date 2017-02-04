package com.nakva.mvp.Login;

import android.util.Log;

import com.nakva.mvp.Helpers.API.ApiAdapter;
import com.nakva.mvp.Helpers.API.ApiInterface;
import com.nakva.mvp.Helpers.API.Model.LoginResponse;

import java.util.HashMap;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Juancho on 04/02/17.
 * Nakva
 * linanjm90@gmail.com
 */

public class LoginModel implements ILoginModel, Callback<LoginResponse> {

    private ILoginModelCallback callback;
    private static final String TAG = "LoginModel";

    @Override
    public void sendLoginRequest(String email, String password,
                                 ILoginModelCallback callback) {

        Call<LoginResponse> call;
        HashMap<String, String> params;
        this.callback = callback;

        params = new HashMap<>();
        params.put(ApiInterface.LOGIN.PARAMS.EMAIL, email);
        params.put(ApiInterface.LOGIN.PARAMS.PASSWORD, password);

        call = ApiAdapter.getAdapter().login(params);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Response<LoginResponse> response, Retrofit retrofit) {
        if(response.isSuccess()){
            Log.d(TAG, "onResponse: ya shingamos mi token es "
                    + response.body().getToken());

        }
        else{
            this.callback.onWrongCredentials();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        this.callback.onInternalServerError();
    }
}
