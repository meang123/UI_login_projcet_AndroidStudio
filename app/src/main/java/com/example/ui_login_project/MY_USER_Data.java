package com.example.ui_login_project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MY_USER_Data
{

    @SerializedName("name")
    private String name;


    @SerializedName("email")
    private String email;

    @SerializedName("result_code")
    private int result_code;

    @SerializedName("status")
    private String status;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getResult_code() {
        return result_code;
    }

    public String getStatus() {
        return status;
    }
}
