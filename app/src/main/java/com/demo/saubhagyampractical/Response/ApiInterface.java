package com.demo.saubhagyampractical.Response;


import com.demo.saubhagyampractical.CommonClass.Constant;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST(Constant.WEBSERVICE_API_PATH)
    Call<ResponsePostData> getDataList(@Field("device_type") String device_type,
                                       @Field("access_token") String access_token,
                                       @Field("offset") String offset,
                                       @Field("lang") String lang,
                                       @Field("device_token") String device_token,
                                       @Field("register_id") String register_id,
                                       @Field("timezone") String timezone,
                                       @Field("user_id") String user_id);


}