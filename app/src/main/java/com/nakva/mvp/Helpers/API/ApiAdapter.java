package com.nakva.mvp.Helpers.API;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Juancho on 04/02/17.
 * Nakva
 * linanjm90@gmail.com
 */

public class ApiAdapter {

    public static final String URL_BASE = "http://192.168.1.65:3000";
    public static ApiInterface API_INTERFACE = null;

    public static ApiInterface getAdapter(){
        if(API_INTERFACE == null){
            OkHttpClient client = new OkHttpClient();
            HttpLoggingInterceptor interceptro;
            interceptro = new HttpLoggingInterceptor();
            interceptro.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.interceptors().add(interceptro);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            API_INTERFACE = retrofit.create(ApiInterface.class);
        }
        return API_INTERFACE;
    }
}
