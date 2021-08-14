package com.demo.saubhagyampractical.CommonClass;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;


public class CommonClass {
    private static final String TAG = CommonClass.class.getSimpleName();
    private Context context;
    private Activity activity;


    public CommonClass(Context context) {
        this.context = context;
        this.activity = (Activity) context;
    }

    public CommonClass(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public boolean isOnline() {
        return Utility.isOnline(context);
    }

   /* public void showAlert(@NonNull String message) {
        MessageUtils.showAlert(activity, message);
    }*/

}