package com.example.modelviewview_modelmvvmgettingstarted.pojoClass;

public class UserInformation {
    String name;
    String email;

    public UserInformation(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
