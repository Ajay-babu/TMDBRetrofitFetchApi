package com.ajay.tmdbapplication;

import android.content.Context;
import android.widget.Toast;

public class Utility {

    public static final String KEY = "8f9c8284f8308268d7209afdb219a454";
    public static final String  IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

    public static void showShortToast(Context context, String msg){
        Toast.makeText(context,  msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
