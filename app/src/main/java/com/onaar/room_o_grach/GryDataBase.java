package com.onaar.room_o_grach;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Gra.class},version = 2)
public abstract class GryDataBase extends RoomDatabase {
    public abstract GraDAO zwrocGryDao();

}
