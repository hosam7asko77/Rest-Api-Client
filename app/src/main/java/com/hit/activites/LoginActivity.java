package com.hit.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hit.R;
import com.hit.Storage.SharedPrefManager;
import com.hit.api.RetrofitClient;
import com.hit.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editEmail,editPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmail=findViewById(R.id.email);
        editPassword=findViewById(R.id.password);
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.register).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                userLogin();
                break;
            case R.id.register:
                break;
        }

    }

    public void userLogin(){
        String email=editEmail.getText().toString().trim();
        String password=editPassword.getText().toString().trim();
        if (email.isEmpty()){
            editEmail.setError("Email is required");
            editEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Enter Valid email");
            editEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            editPassword.setError("password is required");
            editPassword.requestFocus();
            return;
        }
        if (password.length()<4){
            editPassword.setError("password should be 6 character long");
            editPassword.requestFocus();
            return;
        }
        Call<LoginResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .userLogin(password,email);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse lr=response.body();
                if(!lr.isError()) {
                    Toast.makeText(LoginActivity.this,lr.getMsg(),Toast.LENGTH_LONG).show();
                    SharedPrefManager.getInstance(LoginActivity.this)
                            .saveUser(lr.getUser());
                    Intent intent=new Intent(LoginActivity.this,ProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(LoginActivity.this,lr.getMsg(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        if(SharedPrefManager.getInstance(this).isLogIn()){
            Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }
}
