package ru.geekbrains.kozirfm.myproject.app;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.geekbrains.kozirfm.myproject.model.GlideLoader;
import ru.geekbrains.kozirfm.myproject.model.Model;
import ru.geekbrains.kozirfm.myproject.model.RetrofitApi;
import ru.geekbrains.kozirfm.myproject.model.db.PhotosDao;

@Module
public class AppModule {

    @Singleton
    @Provides
    Model provideModel() {
        return new Model();
    }

    @Singleton
    @Provides
    RetrofitApi provideRetrofitApi() {
        return new RetrofitApi();
    }

    @Singleton
    @Provides
    PhotosDao providesPhotosDao() {
        return App.getAppDatabase().getPhotosDao();
    }

    @Singleton
    @Provides
    GlideLoader provideGlideLoader() {
        return new GlideLoader();
    }

}
