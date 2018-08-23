package com.example.user.loginusingapi.network;

import com.example.user.loginusingapi.model.LoginResponse;
import com.example.user.loginusingapi.model.RegistrationParam;
import com.example.user.loginusingapi.model.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET(ApiClient.LOGIN_URL)
    Call<LoginResponse> userAuthenticate(@Query("contactno") String phone,@Query("password") String pass);

    @POST(ApiClient.REGISTRATION_URL)
    Call<RegistrationResponse> postRegistration(@Body RegistrationParam bodyParameter);
}
