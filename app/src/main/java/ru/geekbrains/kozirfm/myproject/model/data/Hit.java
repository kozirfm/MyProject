package ru.geekbrains.kozirfm.myproject.model.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity(tableName = "table_photos_url")
public class Hit {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @Expose
    public String webformatURL;

    @Expose
    public String downloads;

}
