package com.example.modelviewview_modelmvvmgettingstarted.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.modelviewview_modelmvvmgettingstarted.R;
import com.example.modelviewview_modelmvvmgettingstarted.databinding.ActivityMain2Binding;
import com.example.modelviewview_modelmvvmgettingstarted.databinding.ActivityMainBinding;
import com.example.modelviewview_modelmvvmgettingstarted.databinding.ActivityMainBindingImpl;
import com.example.modelviewview_modelmvvmgettingstarted.pojoClass.Users;
import com.example.modelviewview_modelmvvmgettingstarted.view_model.MainActivity_2_ViewModel;

public class Main2Activity extends AppCompatActivity {
    //data Binding Class
    ActivityMain2Binding binding_2;

    //Model view Class
    MainActivity_2_ViewModel mainActivity_2_viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding_2 = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        //connect with model View
        mainActivity_2_viewModel = ViewModelProviders.of(this).get(MainActivity_2_ViewModel.class);

        /*binding_2.showToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainActivity_2_viewModel.gettext("imran","tamim").observe(Main2Activity.this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        Toast.makeText(Main2Activity.this, ""+s, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        })*/;

//get all data From modelView Class
        mainActivity_2_viewModel.getAllUser_LiveData().observe(this, new Observer<Users[]>() {
            @Override
            public void onChanged(@Nullable Users[] users) {
                Toast.makeText(Main2Activity.this, "size  - = "+users.length, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
