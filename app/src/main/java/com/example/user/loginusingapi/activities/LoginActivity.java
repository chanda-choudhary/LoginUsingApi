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
import com.example.user.loginusingapi.contract.LoginActivityContract;
import com.example.user.loginusingapi.model.LoginResponse;
import com.example.user.loginusingapi.presenter.LoginActivityPresenter;
import com.example.user.loginusingapi.view.LoginActivityView;

public class LoginActivity extends AppCompatActivity implements LoginActivityView{

    EditText edtContact;
    EditText edtPassword;
    Button btnLogin;
    TextView tvRegisterHere;

    private LoginActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtContact=findViewById(R.id.edt_contact);
        edtPassword=findViewById(R.id.edt_password);
        btnLogin=findViewById(R.id.btn_login);
        tvRegisterHere=findViewById(R.id.tv_register_here);

        presenter=new LoginActivityContract(this);

        tvRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=edtContact.getText().toString().trim();
                String pass=edtPassword.getText().toString().trim();
                presenter.loginOpration(phone,pass);
            }
        });
    }

    @Override
    public void userLoginSuccess(LoginResponse response) {
        Toast.makeText(this, response.getData().getUserName(),Toast.LENGTH_LONG).show();
        String userName=response.getData().getUserName();
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("username",userName);
        startActivity(intent);
    }

    @Override
    public void userLoginFailure(String errMessage) {
        Toast.makeText(this, errMessage,Toast.LENGTH_LONG).show();

    }
    @Override
    public void setEmptyUsernameErrorMessage(int resId) {
        edtContact.setError(getString(resId));
    }
    @Override
    public void setEmptyPasswordErrorMessage(int resId) {
        edtPassword.setError(getString(resId));
    }
}
