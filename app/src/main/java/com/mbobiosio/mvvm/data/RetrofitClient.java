package com.mbobiosio.mvvm.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mbobiosio.mvvm.util.Constants;
import com.mbobiosio.mvvm.model.PostItems;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * MVVM-Retrofit-RecyclerVIew
 * Created by Mbuodile Obiosio on Jun 11, 2020
 * https://twitter.com/cazewonder
 * Nigeria.
 */
public class RetrofitClient {

    private APIService mAPIService;
    private static RetrofitClient mClient;

    public RetrofitClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mAPIService = retrofit.create(APIService.class);
    }

    public static RetrofitClient getClient() {
        if (null == mClient) {
            mClient = new RetrofitClient();
        }
        return mClient;
    }

    public Call<ArrayList<PostItems>> getPosts() {
        return mAPIService.getPosts();
    }
}
