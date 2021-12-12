package API_package;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofitClient
{


    private static Retrofit retrofit=null;
    private static Gson gson = null;

    private static String BASE_URL = "http://meangsungjoo.000webhostapp.com/loginregister/";

    private MyRetrofitClient()
    {

    }
    public static Retrofit getRetrofit()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }


}
