package com.example.android.chongzhe_cardiobook;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

//Dao stands for Data Access Object
@Dao

public interface NoteDao {
    @Insert
    void insert(Note note);
    @Update
    void update(Note note);
    @Delete
    void delete(Note note);

    @Query("DELETE FROM MEASUREMENT_TABLE")
    void deleteAllNotes();

    @Query("SELECT * FROM MEASUREMENT_TABLE OrDER BY priority DESC")
    LiveData<List<Note>>getAllNotes();

}
