package ru.geekbrains.kozirfm.myproject.app;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {

    private static AppComponent appComponent;

    private static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = generateAppComponent();
        appDatabase = generateAppDatabase();
    }

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    private AppDatabase generateAppDatabase(){
        return Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_database")
                .build();
    }

    public AppComponent generateAppComponent() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule())
                .build();
    }

}
