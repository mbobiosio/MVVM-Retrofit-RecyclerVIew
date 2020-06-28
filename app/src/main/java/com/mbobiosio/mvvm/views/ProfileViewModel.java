package com.mbobiosio.mvvm.views;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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
    private AppRepository repository;

    private MutableLiveData<User> mUser = new MutableLiveData<>();
    private LiveData<User> mUserLiveData = mUser;

    public ProfileViewModel() {
        repository = new AppRepository();
    }

    public LiveData<User> getUserObservable() {
        return mUserLiveData;
    }

    public void getUser(int user, int id) {
        repository.userProfile(user, id, mUser);
    }
}
