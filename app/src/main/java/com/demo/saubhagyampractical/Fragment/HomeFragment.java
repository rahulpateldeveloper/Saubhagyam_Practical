package com.demo.saubhagyampractical.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.demo.saubhagyampractical.Adapter.DataListAdapter;
import com.demo.saubhagyampractical.CommonClass.CommonClass;
import com.demo.saubhagyampractical.CommonClass.Constant;
import com.demo.saubhagyampractical.R;
import com.demo.saubhagyampractical.Response.ApiClient;
import com.demo.saubhagyampractical.Response.ApiInterface;
import com.demo.saubhagyampractical.Response.ResponsePostData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    private View view;
    private RecyclerView rvData;
    private CommonClass cc;
    public List<ResponsePostData.DataList> data;
    public List<ResponsePostData.DataList.Post_image> post_image;
    private DataListAdapter dataListAdapter;
    private ArrayList<String> past_iame_array = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        cc = new CommonClass(getContext());
        rvData = view.findViewById(R.id.rvData);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(layoutManager);

        if (cc.isOnline()) {
            getData();
        } else {
            Toast.makeText(getContext(), "No Internet available", Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    private void getData() {
        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponsePostData> call = apiService.getDataList("0", "f4de13610a023f62d54555102bc6d2fe",
                "0,", "0", "eadfe15f08de24a3", "", "Asia/Calcutta", "77");
        call.enqueue(new Callback<ResponsePostData>() {
            @Override
            public void onResponse(Call<ResponsePostData> call, Response<ResponsePostData> response) {
                if (response.isSuccessful()) {
                    if (Integer.valueOf(response.body().flag) == Constant.Response_OK) {
                        data = new ArrayList<>();
                        post_image = new ArrayList<>();
                        data = response.body().data;


                        Log.e("msg==>>", "" + response.body().msg);

                        /*for (int i = 0; i < data.size(); i++) {
                            for (int j = 0; j < data.get(i).post_image.size(); j++) {

                                if (data.get(i).post_id.matches(post_image.get(j).post_id)) {
                                    past_iame_array.add(post_image.get(j).image_url);
                                }

                            }
                        }*/

                        for (int i = 0; i < data.size(); i++) {
                            for (int j = 0; j < data.get(i).post_image.size(); j++) {
                                past_iame_array.add(data.get(i).post_image.get(j).image_url);
                                Log.e("imagesFrafg=>>", "" + data.get(i).post_image.get(j).image_url);
                                Log.e("imagesFrafgSz=>>", "" + past_iame_array);
                            }
                        }

                        dataListAdapter = new DataListAdapter(getContext(), data, past_iame_array);
                        rvData.setAdapter(dataListAdapter);

                    } else {
                        //    cc.showToast(response.body().message);
                    }
                } else {
                    Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponsePostData> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}