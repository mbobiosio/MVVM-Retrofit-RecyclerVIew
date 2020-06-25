package com.mbobiosio.mvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mbobiosio.mvvm.data.APIService;
import com.mbobiosio.mvvm.data.ProfileAPIBuilder;
import com.mbobiosio.mvvm.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * MVVM-Retrofit-RecyclerVIew
 * Created by Mbuodile Obiosio on Jun 25, 2020
 * https://twitter.com/cazewonder
 * Nigeria.
 */
public class AppRepository {

    private APIService mAPIService;

    public AppRepository() {
        mAPIService = ProfileAPIBuilder.getClient().create(APIService.class);
    }

    public LiveData<User> userProfile(int user, int id) {
        final MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

        mAPIService.getUserProfile(user, id)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                        userMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {

                    }
                });

        return userMutableLiveData;

    }

}
