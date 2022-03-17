package arpitparekh.verylateandroidbatch.room_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.List;

import arpitparekh.verylateandroidbatch.R;
import arpitparekh.verylateandroidbatch.databinding.ActivityRoomListBinding;
import arpitparekh.verylateandroidbatch.databinding.UpdateDialogBinding;

public class RoomListActivity extends AppCompatActivity {

    private ActivityRoomListBinding binding;
    private UpdateDialogBinding dialogBinding;
    List<Student> list;
    StudentDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRoomListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        dao = UtilityHelper.getInstance(this).studentDao();

        getStudentData();

        binding.btnAddData.setOnClickListener(view -> {


            String name = binding.edtNameRoom.getText().toString();
            String address = binding.edtAddress.getText().toString();

            Student s = new Student(name,address);

            dao.insertData(s);

            getStudentData();


        });


        binding.listViewRoomStudentDatabase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Student student = list.get(position);
                dialogBinding = UpdateDialogBinding.inflate(getLayoutInflater());

                dialogBinding.edtNameRoom.setText(student.name);
                dialogBinding.edtEmailRoom.setText(student.address);



                PopupMenu pop = new PopupMenu(RoomListActivity.this,view);

                pop.getMenuInflater().inflate(R.menu.update_delete_menu,pop.getMenu());

                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        if(menuItem.getItemId()==R.id.action_delete){

                            // delete

                            dao.deleteData(student);

                            getStudentData();

                        }else if(menuItem.getItemId()==R.id.action_update){


                            // update

                            new AlertDialog.Builder(RoomListActivity.this)
                                    .setView(dialogBinding.getRoot())
                                    .setPositiveButton("Update Kar chal", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            String name = dialogBinding.edtNameRoom.getText().toString();
                                            String email = dialogBinding.edtEmailRoom.getText().toString();

                                            student.name = name;
                                            student.address = email;

                                            dao.updateData(student);

                                            getStudentData();

                                        }
                                    })
                                    .create().show();

                        }
                        return false;
                    }
                });

                pop.show();


            }
        });

        binding.btnSearch.setOnClickListener(view -> {

            String name = binding.edtName.getText().toString();

            List<Student> list = new ArrayList<>();

            list = dao.fetchParticularData(name);

            StringBuilder emails = new StringBuilder();

            for(Student s : list){

                emails.append(" ").append(s.address);
            }

            binding.tvShow.setText(emails.toString());

        });

    }

    private void getStudentData() {

        list = dao.fetchData();

        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.listViewRoomStudentDatabase.setAdapter(adapter);

    }
}