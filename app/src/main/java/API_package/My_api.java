package API_package;
import com.example.ui_login_project.MY_USER_Data;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Field;


public interface My_api
{

    @FormUrlEncoded
    @POST("signup.php")
    Call<MY_USER_Data> createNewAcount(@Field("name") String username,@Field("email") String pass, @Field("password") String email);

    @FormUrlEncoded
    @POST("login.php")
    Call<MY_USER_Data> logIn(@Field("email") String email,@Field("password") String pass);



}
