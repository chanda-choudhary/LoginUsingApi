package com.example.user.loginusingapi.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL="http://ramchandraavsare.in/";
    public static final String LOGIN_URL="/api/userregistration/userlogin?";
    public static final String REGISTRATION_URL="/api/userregistration/userregistration";


    public static Retrofit retrofit=null;

    /**
     * This method return instance of the Retrofit.
     * @return Retrofit instance
     */
    public static Retrofit getApiClient(){
        if (retrofit==null){
            OkHttpClient.Builder builder=new OkHttpClient.Builder();
            OkHttpClient okHttpClient=builder.build();
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient).build();
        }
        return retrofit;
    }
}
