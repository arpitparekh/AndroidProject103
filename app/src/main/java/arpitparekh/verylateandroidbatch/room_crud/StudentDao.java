package arpitparekh.verylateandroidbatch.room_crud;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    // Dao data access object

    @Insert
    void insertData(Student student);

    @Update
    void updateData(Student student);

    @Delete
    void deleteData(Student student);

    @Query("select * from studenttable")
    List<Student> fetchData();

    @Query("select * from studenttable where name = :name")
    List<Student> fetchParticularData(String name);

    @Insert
    void insertWholeList(List<Student> list);

    @Update
    void updateWholeList(List<Student>list);

//    @Query("drop table studenttable")
//    void deleteTable(Student student);

    @Delete
    void deleteData(List<Student> list);

    @Query("select * from studenttable where age > :age")
    List<Student> getData(int age);


}
