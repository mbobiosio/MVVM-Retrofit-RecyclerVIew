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

    private ProfileViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        userProfile();

    }

    private void userProfile() {
        viewModel.getUserObservable().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    mUsername.setText(user.getUsername());
                    mFullName.setText(user.getName());
                } else {
                    mUsername.setText("Error");
                    mFullName.setText("Error");
                }
            }
        });

        viewModel.getUser(1, 1);
    }

    public void changeUser(android.view.View view) {
        java.util.Random random = new java.util.Random();
        int user = random.nextInt(2) + 1;
        int id = random.nextInt(5) + 1;
        viewModel.getUser(user, id);
    }
}