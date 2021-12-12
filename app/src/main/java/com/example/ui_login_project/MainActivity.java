package com.example.ui_login_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import API_package.MyRetrofitClient;
import API_package.My_api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    EditText etemail,etpass;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        TextView createnewac = findViewById(R.id.createnewac);

        etemail = findViewById(R.id.etemail);
        etpass = findViewById(R.id.mypass);

        Button btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logIn();

            }
        });

        createnewac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });
    }

    private void logIn()
    {
        String email = etemail.getText().toString();
        String pass = etpass.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            etemail.setError("Pleaes Enter Email");
            etemail.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(pass))
        {
            etpass.setError("Please Enter Password");
            etpass.requestFocus();
            return;
        }



        Call<MY_USER_Data> call = MyRetrofitClient.getRetrofit().create(My_api.class).logIn(email,pass);


        call.enqueue(new Callback<MY_USER_Data>() {
            @Override
            public void onResponse(Call<MY_USER_Data> call, Response<MY_USER_Data> response)
            {
                if(response.code()==200)
                {
                    if(response.body().getStatus().equals("ok"))
                    {

                        if(response.body().getResult_code()==1)
                        {

                            String my_name = response.body().getName();
                            String my_email = response.body().getEmail();
                            Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                            intent.putExtra("name", my_name);
                            intent.putExtra("email", my_email);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {

                            Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<MY_USER_Data> call, Throwable t) {

            }
        });
    }

}