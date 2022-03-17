package arpitparekh.verylateandroidbatch.room_crud;

import android.content.Context;

import androidx.room.Room;

public class UtilityHelper {

    static StudentDatabase getInstance(Context context){

        StudentDatabase database = Room.databaseBuilder(context,StudentDatabase.class,"studentdatabse")
                .allowMainThreadQueries()
                .build();

        return database;

    }

}
