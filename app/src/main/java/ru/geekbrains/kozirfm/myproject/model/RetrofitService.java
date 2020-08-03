package ru.geekbrains.kozirfm.myproject.model;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.geekbrains.kozirfm.myproject.model.data.Photos;

public interface RetrofitService {
    @GET("api")
    Single<Photos> getPhoto(@Query("key") String key);
}
