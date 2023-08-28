package com.azhar.catering.database;

import android.content.Context;

import androidx.room.Room;

/**
 * Created by Azhar Rivaldi on 14-07-2023
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

public class DatabaseClient {

    private static DatabaseClient mInstance;
    AppDatabase mAppDatabase;

    //untuk penamaan database
    private DatabaseClient(Context context) {
        mAppDatabase = Room.databaseBuilder(context, AppDatabase.class, "catering_db")
                .fallbackToDestructiveMigration()
                .build();
    }

    //untuk sync data secara realtime
    public static synchronized DatabaseClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(context);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

}
