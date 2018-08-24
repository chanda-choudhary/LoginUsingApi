package com.example.user.loginusingapi.view;

import android.support.annotation.StringRes;

import com.example.user.loginusingapi.model.LoginResponse;
import com.example.user.loginusingapi.model.RegistrationResponse;

public interface RegistrationActivityView {
    void userRegistrationSuccess(RegistrationResponse response);
    void userRegistrationFailure(String errMessage);
    void setEmptyFirstNameErrorMessage(@StringRes int resId);
    void setEmptyLastNameErrorMessage(@StringRes int resId);
    void setEmptyEmailErrorMessage(@StringRes int resId);
    void setEmptyContactErrorMessage(@StringRes int resId);
    void setEmptyPasswordErrorMessage(@StringRes int resId);
}
