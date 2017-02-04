package com.nakva.mvp.Helpers.API;

import com.nakva.mvp.Helpers.API.Model.LoginResponse;

import java.util.HashMap;

import retrofit.Call;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Juancho on 04/02/17.
 * Nakva
 * linanjm90@gmail.com
 */

public interface ApiInterface {

    abstract class LOGIN {
        public static final String PATH = "/login";

        public abstract class PARAMS {
            public static final String EMAIL = "email";
            public static final String PASSWORD = "password";
        }
    }

    @POST(ApiInterface.LOGIN.PATH)
    @FormUrlEncoded
    Call<LoginResponse> login(@FieldMap HashMap<String , String> params);


}
