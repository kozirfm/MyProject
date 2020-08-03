package ru.geekbrains.kozirfm.myproject.model.db;

import androidx.room.Dao;
import androidx.room.Insert;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import ru.geekbrains.kozirfm.myproject.model.data.Hit;

@Dao
public interface PhotosDao {

    @Insert
    Single<List<Long>> insert(List<Hit> hits);

}
