package com.hit.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hit.model.DefaultResponse;
import com.hit.R;
import com.hit.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText editEmail,editName,editPassword,editCourse,editAge;
    private Button buttonSignIn;
    private TextView textLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=findViewById(R.id.userName);
        editEmail=findViewById(R.id.email);
        editPassword=findViewById(R.id.password);
        editCourse=findViewById(R.id.course);
        editAge=findViewById(R.id.age);
        buttonSignIn=findViewById(R.id.signIn);
        textLogin=findViewById(R.id.login);
    buttonSignIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            userSignIn();
        }
    });
    }
    private void userSignIn(){
        String name=editName.getText().toString().trim();
        String email=editEmail.getText().toString().trim();
        String password=editPassword.getText().toString().trim();
        String course=editCourse.getText().toString().trim();
        String age=editAge.getText().toString().trim();
        if (name.isEmpty()){
            editName.setError("Name is required");
            editName.requestFocus();
            return;
        }
        if (course.isEmpty()){
            editCourse.setError("Course is required");
            editCourse.requestFocus();
            return;
        }
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
            editName.setError("password is required");
            editName.requestFocus();
            return;
        }
        if (password.length()<4){
            editName.setError("password should be 4 character long");
            editName.requestFocus();
            return;
        }
        if (age.isEmpty()){
            editAge.setError("Age is required");
            editAge.requestFocus();
            return;
        }
        Call<DefaultResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .createUser(name,course,email,password,age);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if(response.code()==201){
                    DefaultResponse dr=response.body();
                    Toast.makeText(MainActivity.this,dr.getMsg(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"User Exist",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();

            }
        });
    }
}
