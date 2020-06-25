package com.mbobiosio.mvvm.views;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mbobiosio.mvvm.AppRepository;
import com.mbobiosio.mvvm.model.User;

/**
 * MVVM-Retrofit-RecyclerVIew
 * Created by Mbuodile Obiosio on Jun 25, 2020
 * https://twitter.com/cazewonder
 * Nigeria.
 */
public class ProfileViewModel extends ViewModel {

    private LiveData<User> mUserLiveData = null;

    public ProfileViewModel() {
        AppRepository repository = new AppRepository();
        mUserLiveData = repository.userProfile(1, 1);
    }

    public LiveData<User> getUser() {
        return mUserLiveData;
    }

}
