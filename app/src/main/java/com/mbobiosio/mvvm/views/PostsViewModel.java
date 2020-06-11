package com.mbobiosio.mvvm.views;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mbobiosio.mvvm.data.RetrofitClient;
import com.mbobiosio.mvvm.model.PostItems;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * MVVM-Retrofit-RecyclerVIew
 * Created by Mbuodile Obiosio on Jun 11, 2020
 * https://twitter.com/cazewonder
 * Nigeria.
 */
public class PostsViewModel extends ViewModel {

    public MutableLiveData<ArrayList<PostItems>> mLiveData = new MutableLiveData<>();
    MutableLiveData<String> mPosts = new MutableLiveData<>();

    public void getPosts() {
        RetrofitClient.getClient().getPosts().enqueue(new Callback<ArrayList<PostItems>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<PostItems>> call, @NonNull Response<ArrayList<PostItems>> response) {
                mLiveData.setValue(response.body());
                Log.d("TAG", response.body().toString());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<PostItems>> call, @NonNull Throwable t) {
                Log.d("Error ", t.getMessage());
            }
        });
    }
}
