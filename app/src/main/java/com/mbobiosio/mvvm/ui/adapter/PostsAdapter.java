package com.mbobiosio.mvvm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mbobiosio.mvvm.R;
import com.mbobiosio.mvvm.model.PostItems;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * MVVM-Retrofit-RecyclerVIew
 * Created by Mbuodile Obiosio on Jun 11, 2020
 * https://twitter.com/cazewonder
 * Nigeria.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostVH> {

    private static final String TAG = PostsAdapter.class.getSimpleName();

    private static Context mContext;
    private ArrayList<PostItems> mDataList;


    @NonNull
    @Override
    public PostVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        mContext = parent.getContext();
        return new PostVH(view);
    }

    @Override
    public void onBindViewHolder(PostVH holder, int position) {
        PostItems data = mDataList.get(position);
        holder.set(data);
    }

    @Override
    public int getItemCount() {
        if (mDataList == null) {
            return 0;
        }
        return mDataList.size();
    }

    public void setDataList(ArrayList<PostItems> dataList) {
        this.mDataList = dataList;
        notifyDataSetChanged();
    }

    public static class PostVH extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.userId)
        TextView mUserId;
        @BindView(R.id.detail)
        TextView mDetail;
        @BindView(R.id.post_item)
        CardView mPostItem;

        public PostVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void set(PostItems data) {
            //UI setting code
            mUserId.setText(String.valueOf(data.getId()));
            mTitle.setText(data.getTitle());
            mDetail.setText(data.getBody());
            
            mPostItem.setOnClickListener(v -> {
                Toast.makeText(mContext, "Clicked "+data.getId(), Toast.LENGTH_SHORT).show();
            });
        }
    }
}