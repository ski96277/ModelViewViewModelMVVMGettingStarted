package com.example.modelviewview_modelmvvmgettingstarted.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.modelviewview_modelmvvmgettingstarted.model.UserRepository;
import com.example.modelviewview_modelmvvmgettingstarted.pojoClass.Users;

public class MainActivity_2_ViewModel extends AndroidViewModel {
    UserRepository userRepository;

    //constrator
    public MainActivity_2_ViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    /*MutableLiveData<String> stringMutableLiveData;

    public MutableLiveData<String> gettext(String a, String b) {

        if (stringMutableLiveData == null) {
        stringMutableLiveData=new MutableLiveData<>();
        }
        stringMutableLiveData.setValue(a);

        return stringMutableLiveData;
    }*/
    //get all userdata
    public LiveData<Users[]> getAllUser_LiveData() {
        return userRepository.getUserData();
    }

}
