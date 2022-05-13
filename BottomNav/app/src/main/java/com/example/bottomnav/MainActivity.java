package com.example.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentHome fragmentHome;
    private FragmentMypage fragmentMypage;
    private FragmentSetting fragmentSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentHome = new FragmentHome();
        fragmentMypage = new FragmentMypage();
        fragmentSetting = new FragmentSetting();

        //final FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.replace(R.id.frame_layout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                int id = item.getItemId();

                switch (id){
                    case R.id.menu_Home:
                        transaction.replace(R.id.frame_layout,fragmentHome).commitAllowingStateLoss();
                        break;
                    case R.id.menu_MyPage:
                        transaction.replace(R.id.frame_layout,fragmentMypage).commitAllowingStateLoss();
                        break;
                    case R.id.menu_Setting:
                        transaction.replace(R.id.frame_layout,fragmentSetting).commitAllowingStateLoss();
                        break;
                }

                return true;
            }
        });
    }
}