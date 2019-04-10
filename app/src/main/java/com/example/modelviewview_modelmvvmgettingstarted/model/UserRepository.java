package com.example.modelviewview_modelmvvmgettingstarted.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.modelviewview_modelmvvmgettingstarted.pojoClass.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserRepository {

    String url = "https://api.github.com/users";
    Application application;
    Users[] users;
    MutableLiveData<Users[]> mutableLiveData;

    public UserRepository(Application application) {
        this.application = application;
    }

    //get user data as an array
    public MutableLiveData<Users[]> getUserData() {
        //if MutableLiveData data is null
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
        }

        RequestQueue queue = Volley.newRequestQueue(application);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        users = gson.fromJson(response, Users[].class);
                        mutableLiveData.setValue(users);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
        //return the mutable live data
        return mutableLiveData;

    }
}
