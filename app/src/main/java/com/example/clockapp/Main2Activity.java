package com.example.clockapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DateFormat;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity /*implements TimePickerDialog.OnTimeSetListener*/ {

    private Button btn;
    private Button cancel;
    private TextView tv;
    private fornotifications mnotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView b=findViewById(R.id.bottom_nav);
        b.setOnNavigationItemSelectedListener(navlisten);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,new alarm()).commit();



    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlisten=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedfrag=null;
                    switch (menuItem.getItemId())
                    {
                        case R.id.alarm: selectedfrag=new alarm();break;
                        case R.id.timer:selectedfrag=new timer();break;
                        case R.id.stopwatch:selectedfrag=new stopwatch();break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,selectedfrag).commit();
                    return true;
                }
            };

}
