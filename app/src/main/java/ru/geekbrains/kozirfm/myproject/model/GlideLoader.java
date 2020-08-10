package ru.geekbrains.kozirfm.myproject.model;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideLoader {

    public void loadPhoto(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}
