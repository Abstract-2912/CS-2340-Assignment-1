package com.example.cs_2340_assignment_1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDataAccessObject {

    @Query("SELECT * FROM courses")
    List<Constants> loadAllTask(); // returns a list of task object

    @Insert
    void insertTask(Constants course);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(Constants course);

    @Delete
    void deleteTask(Constants course);

}