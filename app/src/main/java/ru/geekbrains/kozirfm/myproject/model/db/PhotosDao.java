package ru.geekbrains.kozirfm.myproject.model.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import ru.geekbrains.kozirfm.myproject.model.data.Hit;

@Dao
public interface PhotosDao {

    @Query("SELECT * FROM table_photos_url")
    Single<List<Hit>> getAll();

    @Query("SELECT webformatURL FROM table_photos_url WHERE id = :id")
    Single<String> getWebformatUrl(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<List<Long>> insert(List<Hit> hits);

}
