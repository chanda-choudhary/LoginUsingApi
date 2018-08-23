package com.example.user.loginusingapi.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.loginusingapi.R;
import com.example.user.loginusingapi.model.RegistrationParam;

public class RegistrationActivity extends AppCompatActivity {

    TextView tvLoginHere;
    EditText edtFirstName;
    EditText edtLastName;
    EditText edtEmailId;
    EditText edtContactNo;
    EditText edtPassword;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        tvLoginHere=findViewById(R.id.tv_login_here);

        tvLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        RegistrationParam param=new RegistrationParam();

    }
}
