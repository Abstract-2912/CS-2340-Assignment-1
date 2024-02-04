package com.example.cs_2340_assignment_1;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Constants.class},version = 1,exportSchema = false)

public abstract class AppDataBase extends RoomDatabase {

    public static final String LOG_TAG = AppDataBase.class.getSimpleName();
    public static final Object LOCK = new Object();
    public static final String DATABASE_NAME = "course_list";
    private static AppDataBase sInstance;

    public static AppDataBase getsInstance(Context context){
        if (sInstance== null) {
            synchronized (LOCK){
                Log.d(LOG_TAG,"creating new database");

                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                                AppDataBase.class,AppDataBase.DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build();
            }
        }

        Log.d(LOG_TAG,"getting the database instance");

        return sInstance;

    }

    public abstract CourseDataAccessObject taskDao();

}

