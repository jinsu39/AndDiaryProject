package com.example.diaryproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.diaryproject.MainFragment.CalendarFragment;
import com.example.diaryproject.MainFragment.DiaryFragment;
import com.example.diaryproject.MainFragment.ScheduleFragment;
import com.example.diaryproject.MainFragment.SettingFragment;
import com.example.diaryproject.MainFragment.TamagotchiFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    CalendarFragment calendarFragment;
    ScheduleFragment scheduleFragment;
    DiaryFragment diaryFragment;
    TamagotchiFragment tamagotchiFragment;
    SettingFragment settingFragment;

    int selectedFragment = 0;

    BottomNavigationView bottomNavi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarFragment = new CalendarFragment();
        scheduleFragment = new ScheduleFragment();
        diaryFragment = new DiaryFragment();
        tamagotchiFragment = new TamagotchiFragment();
        settingFragment = new SettingFragment();

        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flMain, calendarFragment);
        selectedFragment = 3;
        fragmentTransaction.commit();

        // bottomNavi 설정 -> 아이템 별 진행
        bottomNavi = findViewById(R.id.bnNavi);
        bottomNavi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.mi_Schedule){
                    if(selectedFragment != 0) {
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flMain, scheduleFragment);
                        fragmentTransaction.commit();
                        selectedFragment = 0;
                    }

                    return true;

                }else if(item.getItemId() == R.id.mi_Diary){
                    if(selectedFragment != 1) {
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flMain, diaryFragment);
                        fragmentTransaction.commit();
                        selectedFragment = 1;
                    }

                    return true;

                }else if(item.getItemId() == R.id.mi_Calendar){
                    if(selectedFragment != 2) {
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flMain, calendarFragment);
                        fragmentTransaction.commit();
                        selectedFragment = 2;
                    }

                    return true;

                }else if(item.getItemId() == R.id.mi_Tamagotchi){
                    if(selectedFragment != 3) {
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flMain, tamagotchiFragment);
                        fragmentTransaction.commit();
                        selectedFragment = 3;
                    }

                    return true;

                }else if(item.getItemId() == R.id.mi_Setting){
                    if(selectedFragment != 4) {
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flMain, settingFragment);
                        fragmentTransaction.commit();
                        selectedFragment = 4;
                    }

                    return true;

                }

                return false;
            }
        });
    }
}
