package arpitparekh.verylateandroidbatch.room_crud;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "studenttable")
public class Student {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "address")
    String address;

    @ColumnInfo(name = "age")
    int age;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "name = " + name+
                "\naddress = " + address;

    }
}
