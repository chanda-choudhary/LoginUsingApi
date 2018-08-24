package com.example.user.loginusingapi.contract;

import android.app.ProgressDialog;
import android.content.Context;
import android.telecom.Call;

import com.example.user.loginusingapi.R;
import com.example.user.loginusingapi.activities.RegistrationActivity;
import com.example.user.loginusingapi.model.RegistrationParam;
import com.example.user.loginusingapi.model.RegistrationResponse;
import com.example.user.loginusingapi.network.ApiClient;
import com.example.user.loginusingapi.network.ApiInterface;
import com.example.user.loginusingapi.presenter.RegistrationActivityPresenter;
import com.example.user.loginusingapi.util.ProgressUtil;
import com.example.user.loginusingapi.view.RegistrationActivityView;

import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivityContract implements RegistrationActivityPresenter {
    RegistrationActivityView activityView;
    Context context;
    ProgressDialog progressDialog;
    public RegistrationActivityContract(RegistrationActivityView activityView, Context context) {
        this.activityView=activityView;
        this.context=context;
        this.progressDialog=ProgressUtil.loadingDialog(context);
    }

    @Override
    public void registrationOperation(RegistrationParam param) {
        if (param.getFirstName().isEmpty()){
            activityView.setEmptyFirstNameErrorMessage(R.string.empty_first_name_error);
            return;
        }
        if (param.getLastName().isEmpty()){
            activityView.setEmptyLastNameErrorMessage(R.string.empty_last_name_error);
            return;
        }
        if (param.getGetEmailId().isEmpty()){
            activityView.setEmptyEmailErrorMessage(R.string.empty_email_error);
            return;
        }
        if (param.getGetContactNo().isEmpty()){
            activityView.setEmptyContactErrorMessage(R.string.empty_contact_no_error);
            return;
        }
        if (param.getGetPassword().isEmpty()){
            activityView.setEmptyPasswordErrorMessage(R.string.empty_password_error);
            return;
        }
        progressDialog.show();
        ApiClient.getApiClient().create(ApiInterface.class).postRegistration(param).enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(retrofit2.Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()){
                    if (response.body().getStatus()){
                        activityView.userRegistrationSuccess(response.body());
                    }
                    else {
                        activityView.userRegistrationFailure("Registration fail..");
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<RegistrationResponse> call, Throwable t) {
                progressDialog.dismiss();
                call.cancel();
                activityView.userRegistrationFailure("Request Fail");
            }
        });
    }
}
