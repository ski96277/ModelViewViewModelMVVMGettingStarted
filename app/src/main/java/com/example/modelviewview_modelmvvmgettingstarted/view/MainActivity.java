package com.example.modelviewview_modelmvvmgettingstarted.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.modelviewview_modelmvvmgettingstarted.R;
import com.example.modelviewview_modelmvvmgettingstarted.pojoClass.UserInformation;
import com.example.modelviewview_modelmvvmgettingstarted.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        UserInformation userInformation = new UserInformation("Imran", "Imran.bu96@gmail.com");
        activityMainBinding.setUser(userInformation);
    }

    public void NextActivity(View view) {

        startActivity(new Intent(this,Main2Activity.class));
    }
}
