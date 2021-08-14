package com.demo.saubhagyampractical.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.demo.saubhagyampractical.R;
import com.demo.saubhagyampractical.Response.ResponsePostData;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DataListAdapter extends RecyclerView.Adapter {
    public List<ResponsePostData.DataList> data;
    public List<ResponsePostData.DataList> hgvghgvhvhjvbjbvjbvjbvhvhvhgv;
    private Context mContext;
    private ArrayList<String> past_iame_array = new ArrayList<>();

    public DataListAdapter(Context mContext, List<ResponsePostData.DataList> data, ArrayList<String> past_iame_array) {
        this.mContext = mContext;
        this.data = data;
        this.past_iame_array = past_iame_array;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data_list, parent, false);
        return new MenuViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        MenuViewHolder holder = (MenuViewHolder) viewHolder;

        holder.tvRestName.setText(data.get(position).name);
        holder.tvLocation.setText(data.get(position).location_name);
        holder.tvfeedBack.setText(data.get(position).feedback);
        holder.tvLike.setText(data.get(position).like_count);
        holder.tvComment.setText(data.get(position).comment_count);
        holder.tvShare.setText(data.get(position).share_count);
        holder.tvViewCount.setText(data.get(position).view_count);
        holder.tvFollowCount.setText(data.get(position).followers_count);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_home);
        requestOptions.error(R.drawable.ic_home);

        Glide.with(mContext)
                .setDefaultRequestOptions(requestOptions)
                .load(data.get(position).user_profile_pic)
                .into(holder.civImage);

        Glide.with(mContext)
                .setDefaultRequestOptions(requestOptions)
                .load(past_iame_array.get(position))
                .into(holder.ivPostImg);

        Log.e("picss==>>", "" + data.get(position).user_profile_pic);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class MenuViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRestName, tvLocation, tvfeedBack, tvLike, tvComment, tvShare, tvViewCount, tvFollowCount;
        private CircleImageView civImage;
        private ImageView ivPostImg;

        MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRestName = itemView.findViewById(R.id.tvRestName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            civImage = itemView.findViewById(R.id.civImage);
            ivPostImg = itemView.findViewById(R.id.ivPostImg);
            tvfeedBack = itemView.findViewById(R.id.tvfeedBack);
            tvLike = itemView.findViewById(R.id.tvLike);
            tvComment = itemView.findViewById(R.id.tvComment);
            tvShare = itemView.findViewById(R.id.tvShare);
            tvViewCount = itemView.findViewById(R.id.tvViewCount);
            tvFollowCount = itemView.findViewById(R.id.tvFollowCount);
        }
    }
}