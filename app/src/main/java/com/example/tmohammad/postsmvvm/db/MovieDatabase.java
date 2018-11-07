package com.example.tmohammad.postsmvvm.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.tmohammad.postsmvvm.model.Movie;

/**
 * Database schema that holds the list of movies.
 *
 * @author Kaushik N Sanji
 */
@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    private static volatile MovieDatabase INSTANCE;

    public static MovieDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MovieDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    private static MovieDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                MovieDatabase.class,
                "Github.db"
        ).build();
    }

    //movieDao is a DAO class annotated with @Dao
    public abstract MovieDAO movieDao();
}
