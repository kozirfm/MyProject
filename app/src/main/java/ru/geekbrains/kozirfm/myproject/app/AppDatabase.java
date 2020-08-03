package ru.geekbrains.kozirfm.myproject.app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.geekbrains.kozirfm.myproject.model.data.Hit;
import ru.geekbrains.kozirfm.myproject.model.db.PhotosDao;

@Database(entities = {Hit.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PhotosDao getPhotosDao();
}
