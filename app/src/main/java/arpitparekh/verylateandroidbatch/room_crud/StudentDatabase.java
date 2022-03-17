package arpitparekh.verylateandroidbatch.room_crud;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    abstract StudentDao studentDao();

}
