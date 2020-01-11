package com.hit.activites;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hit.R;
import com.hit.activites.fragment.HomeFragment;
import com.hit.activites.fragment.SettingFragment;
import com.hit.activites.fragment.UserFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainProfileActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
        BottomNavigationView navigationView=findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       Fragment fragment=null;
        switch (menuItem.getItemId()){
            case R.id.home_nv:
                fragment=new HomeFragment();
                break;
            case R.id.usernv:
                fragment =new UserFragment();
                break;
            case R.id.setting_nv:
                fragment =new SettingFragment();
                break;
        }
        if(fragment !=null){
            displayFragment(fragment);
        }
        return false;
    }
    public  void displayFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,fragment)
                .commit();

    }
}
