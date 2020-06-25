package com.mbobiosio.mvvm.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import com.mbobiosio.mvvm.R;
import com.mbobiosio.mvvm.model.User;
import com.mbobiosio.mvvm.views.ProfileViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserProfile extends AppCompatActivity {

    @BindView(R.id.username)
    TextView mUsername;
    @BindView(R.id.name)
    TextView mFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);

        final ProfileViewModel viewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        userProfile(viewModel);

    }

    private void userProfile(ProfileViewModel viewModel) {
        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                mUsername.setText(user.getUsername());
                mFullName.setText(user.getName());
            }
        });
    }
}