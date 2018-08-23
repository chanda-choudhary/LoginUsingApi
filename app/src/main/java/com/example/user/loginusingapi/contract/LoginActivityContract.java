package com.example.user.loginusingapi.contract;

import com.example.user.loginusingapi.R;
import com.example.user.loginusingapi.activities.LoginActivity;
import com.example.user.loginusingapi.model.LoginResponse;
import com.example.user.loginusingapi.network.ApiClient;
import com.example.user.loginusingapi.network.ApiInterface;
import com.example.user.loginusingapi.presenter.LoginActivityPresenter;
import com.example.user.loginusingapi.view.LoginActivityView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivityContract implements LoginActivityPresenter{
    LoginActivityView activityView;
    public LoginActivityContract(LoginActivityView activityView) {
        this.activityView=activityView;
    }

    @Override
    public void loginOpration(String phone, String pass) {
        if (phone.isEmpty()){
            activityView.setEmptyUsernameErrorMessage(R.string.empty_phone_error);
            return;
        }
        if (pass.isEmpty()){
            activityView.setEmptyPasswordErrorMessage(R.string.empty_password_error);
            return;
        }
        ApiClient.getApiClient().create(ApiInterface.class).userAuthenticate(phone, pass).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getStatus()){
                        activityView.userLoginSuccess(response.body());
                    }
                    else {
                        activityView.userLoginFailure("Check your phone no. and password");
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                call.cancel();
                activityView.userLoginFailure("Request Fail");
            }
        });
    }
}
