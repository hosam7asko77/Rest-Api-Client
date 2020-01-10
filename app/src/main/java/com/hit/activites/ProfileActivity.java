package com.hit.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.hit.R;
import com.hit.Storage.SharedPrefManager;
import com.hit.model.User;

public class ProfileActivity extends AppCompatActivity {
private TextView textName,textId,textCourse,textEmail,textAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textId=findViewById(R.id.id);
        textName=findViewById(R.id.name);
        textCourse=findViewById(R.id.course);
        textEmail=findViewById(R.id.email);
        textAge=findViewById(R.id.age);
        User user= SharedPrefManager.getInstance(this).getUser();
        textName.setText(user.getName());
        textCourse.setText(user.getCourse());
        textEmail.setText(user.getEmail());
        textAge.setText(user.getAge().toString().trim());


    }
}
