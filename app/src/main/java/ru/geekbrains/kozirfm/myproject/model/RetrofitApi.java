package ru.geekbrains.kozirfm.myproject.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.geekbrains.kozirfm.myproject.model.data.Photos;

public class RetrofitApi {

    public Single<Photos> requestServer() {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        RetrofitService api = new Retrofit.Builder()
                .baseUrl("https://pixabay.com")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(RetrofitService.class);

        return api.getPhoto("9250926-552b631cddef606bad3e807d2");

    }

}
