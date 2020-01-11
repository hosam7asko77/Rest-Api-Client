package com.hit.activites.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hit.R;
import com.hit.Storage.SharedPrefManager;
import com.hit.model.User;


public class HomeFragment extends Fragment {
    private TextView textName,textId,textCourse,textEmail,textAge;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textId=view.findViewById(R.id.id);
        textName=view.findViewById(R.id.name);
        textCourse=view.findViewById(R.id.course);
        textEmail=view.findViewById(R.id.email);
        textAge=view.findViewById(R.id.age);
        User user= SharedPrefManager.getInstance(getActivity()).getUser();
        textName.setText(user.getName());
        textCourse.setText(user.getCourse());
        textEmail.setText(user.getEmail());
        textAge.setText(user.getAge().toString().trim());
    }
}