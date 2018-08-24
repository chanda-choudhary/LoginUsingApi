package com.example.user.loginusingapi.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.loginusingapi.R;
import com.example.user.loginusingapi.contract.RegistrationActivityContract;
import com.example.user.loginusingapi.model.LoginResponse;
import com.example.user.loginusingapi.model.RegistrationParam;
import com.example.user.loginusingapi.model.RegistrationResponse;
import com.example.user.loginusingapi.presenter.RegistrationActivityPresenter;
import com.example.user.loginusingapi.util.ProgressUtil;
import com.example.user.loginusingapi.view.RegistrationActivityView;

import static com.example.user.loginusingapi.util.ProgressUtil.loadingDialog;

public class RegistrationActivity extends AppCompatActivity implements RegistrationActivityView {

    TextView tvLoginHere;
    EditText edtFirstName;
    EditText edtLastName;
    EditText edtEmailId;
    EditText edtContactNo;
    EditText edtPassword;
    Button btnRegister;

    private RegistrationActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        tvLoginHere=findViewById(R.id.tv_login_here);
        edtFirstName=findViewById(R.id.edt_first_name);
        edtLastName=findViewById(R.id.edt_last_name);
        edtEmailId=findViewById(R.id.edt_email);
        edtContactNo=findViewById(R.id.edt_contact_no);
        edtPassword=findViewById(R.id.edt_password);
        btnRegister=findViewById(R.id.btn_register);

        presenter=new RegistrationActivityContract(this,this);

        tvLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RegistrationParam param=new RegistrationParam();
                param.setFirstName(edtFirstName.getText().toString());
                param.setLastName(edtLastName.getText().toString());
                param.setGetUserName(edtFirstName.getText().toString()+edtLastName.getText().toString());
                param.setGetEmailId(edtEmailId.getText().toString());
                param.setGetContactNo(edtContactNo.getText().toString());
                param.setGetPassword(edtPassword.getText().toString());

                presenter.registrationOperation(param);
            }
        });


    }

    @Override
    public void userRegistrationSuccess(RegistrationResponse response) {
        Toast.makeText(this,"Registration Successfull." ,Toast.LENGTH_LONG).show();
        startActivity(new Intent(this,LoginActivity.class));
    }

    @Override
    public void userRegistrationFailure(String errMessage) {
        Toast.makeText(this, errMessage,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setEmptyFirstNameErrorMessage(int resId) {
        edtFirstName.setError(getString(resId));
    }

    @Override
    public void setEmptyLastNameErrorMessage(int resId) {
        edtLastName.setError(getString(resId));
    }

    @Override
    public void setEmptyEmailErrorMessage(int resId) {
        edtEmailId.setError(getString(resId));
    }

    @Override
    public void setEmptyContactErrorMessage(int resId) {
        edtContactNo.setError(getString(resId));
    }

    @Override
    public void setEmptyPasswordErrorMessage(int resId) {
        edtPassword.setError(getString(resId));
    }
}
