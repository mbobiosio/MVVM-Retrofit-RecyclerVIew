package com.mbobiosio.mvvm.data;

import com.mbobiosio.mvvm.model.PostItems;
import com.mbobiosio.mvvm.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * MVVM-Retrofit-RecyclerVIew
 * Created by Mbuodile Obiosio on Jun 11, 2020
 * https://twitter.com/cazewonder
 * Nigeria.
 */
public interface APIService {

    @GET("posts")
    Call<ArrayList<PostItems>> getPosts();

    @GET("GetUserByID")
    Call<User> getUserProfile(
            @Query("UserID") Integer userId,
            @Query("myID") Integer myId
    );
}
