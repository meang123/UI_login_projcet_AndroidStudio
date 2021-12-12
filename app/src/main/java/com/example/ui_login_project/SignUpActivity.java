package com.example.ui_login_project;



import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import API_package.MyRetrofitClient;
import API_package.My_api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity
{
    EditText et_name,et_email,et_pass;
    String name="",email="",pass="";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);


        Button btn_new = findViewById(R.id.buttonAcount);


        btn_new.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                createNewAcount();
            }
        });
    }

    private void createNewAcount()
    {
        et_name = (EditText)findViewById(R.id.editName);
        et_email = (EditText)findViewById(R.id.editEmail);
        et_pass = (EditText)findViewById(R.id.editPass);

        name = et_name.getText().toString();
        email = et_email.getText().toString();
        pass =et_pass.getText().toString();


        if(TextUtils.isEmpty(name))
        {
            et_name.setError("Please Enter NAME!");
            et_name.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(email))
        {
            et_email.setError("Please Enter EMAIL!");
            et_email.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(pass))
        {
            et_pass.setError("Please Enter PASSWORD!");
            et_pass.requestFocus();
            return;
        }



        Call<MY_USER_Data> call = MyRetrofitClient.getRetrofit().create(My_api.class).createNewAcount(name,email,pass);


        call.enqueue(new Callback<MY_USER_Data>() {

            @Override
            public void onResponse(Call<MY_USER_Data> call, Response<MY_USER_Data> response)
            {

                if(response.code()==200)
                {

                    if(response.body().getStatus().equals("ok")) {
                        if(response.body().getResult_code()==1)
                        {
                            Toast.makeText(SignUpActivity.this, "Success Sign up You can login", Toast.LENGTH_LONG).show();
                            onBackPressed();
                            finish();
                        }
                        else
                        {
                            Toast.makeText(SignUpActivity.this, "User aleady exist!!", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(SignUpActivity.this, "Error!", Toast.LENGTH_LONG).show();
                    }

                }
                else
                {
                    Toast.makeText(SignUpActivity.this, "Error!", Toast.LENGTH_LONG).show();

                }


            }

            @Override
            public void onFailure(Call<MY_USER_Data> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
