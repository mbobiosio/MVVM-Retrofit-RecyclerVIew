package com.mbobiosio.mvvm.data;

import com.mbobiosio.mvvm.model.PostItems;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * MVVM-Retrofit-RecyclerVIew
 * Created by Mbuodile Obiosio on Jun 11, 2020
 * https://twitter.com/cazewonder
 * Nigeria.
 */
public interface APIService {

    @GET("posts")
    Call<ArrayList<PostItems>> getPosts();
}
