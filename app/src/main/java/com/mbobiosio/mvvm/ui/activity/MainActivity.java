package com.mbobiosio.mvvm.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mbobiosio.mvvm.R;
import com.mbobiosio.mvvm.model.PostItems;
import com.mbobiosio.mvvm.ui.adapter.PostsAdapter;
import com.mbobiosio.mvvm.views.PostsViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.posts)
    RecyclerView mPosts;

    PostsViewModel mPostsViewModel;
    PostsAdapter mPostsAdapter = new PostsAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPostsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        mPostsViewModel.getPosts();

        mPosts.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mPosts.setAdapter(mPostsAdapter);

        mPostsViewModel.mLiveData.observe(this, new Observer<ArrayList<PostItems>>() {
            @Override
            public void onChanged(ArrayList<PostItems> postItems) {
                mPostsAdapter.setDataList(postItems);
            }
        });
    }
}