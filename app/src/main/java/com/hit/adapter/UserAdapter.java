package com.hit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.R;
import com.hit.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    public List<User> userList;
    public Context context;

    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context)
                .inflate(R.layout.recyclerview,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final User listItems1=userList.get(i);
       viewHolder.textId.setText(listItems1.getId().toString());
        viewHolder.textName.setText(listItems1.getName());
        viewHolder.textCourse.setText(listItems1.getCourse());
        viewHolder.textEmail.setText(listItems1.getEmail());
        viewHolder.textAge.setText(listItems1.getAge().toString());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textId,textName,textCourse,textEmail,textAge;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textId=itemView.findViewById(R.id.tv_id);
            textName=itemView.findViewById(R.id.tv_name);
            textCourse=itemView.findViewById(R.id.tv_course);
            textEmail=itemView.findViewById(R.id.tv_email);
            textAge=itemView.findViewById(R.id.tv_age);
        }
    }
}
