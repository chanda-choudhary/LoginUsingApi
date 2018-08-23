package com.example.user.loginusingapi.view;

import android.support.annotation.StringRes;

import com.example.user.loginusingapi.model.LoginResponse;

public interface LoginActivityView {
    void userLoginSuccess(LoginResponse response);
    void userLoginFailure(String errMessage);
    void setEmptyUsernameErrorMessage(@StringRes int resId);
    void setEmptyPasswordErrorMessage(@StringRes int resId);
}
