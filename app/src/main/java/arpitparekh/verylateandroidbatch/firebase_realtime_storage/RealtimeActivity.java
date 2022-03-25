package arpitparekh.verylateandroidbatch.firebase_realtime_storage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import arpitparekh.verylateandroidbatch.databinding.ActivityRealtimeBinding;
import arpitparekh.verylateandroidbatch.databinding.DialogLayoutBinding;

public class RealtimeActivity extends AppCompatActivity {

    private ActivityRealtimeBinding binding;
    private DialogLayoutBinding binding1;
    private DatabaseReference ref;
    ArrayList<Note> notes;
    ArrayList<String> keys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRealtimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notes = new ArrayList<>();
        keys = new ArrayList<>();

        ref = FirebaseDatabase.getInstance().getReference("notes");

        ArrayAdapter<Note> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,notes);

        binding.realtimeDatabase.setAdapter(adapter);

        binding.btnSubmit.setOnClickListener(view -> {

            String title = binding.edtTitle.getText().toString();
            String body = binding.edtBody.getText().toString();

            Note note = new Note(title,body);

            ref.push().setValue(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Snackbar.make(binding.btnSubmit,"Note Added", Snackbar.LENGTH_SHORT).show();
                }
            });
        });

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                notes.clear();

                for(DataSnapshot childsnap : snapshot.getChildren()){

                    Note note =  childsnap.getValue(Note.class);

                    keys.add(childsnap.getKey());

                    notes.add(note);

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.realtimeDatabase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                binding1 = DialogLayoutBinding.inflate(getLayoutInflater());

                String key = keys.get(pos);
                Note note = notes.get(pos);

                binding1.edtTitleDialog.setText(note.title);
                binding1.edtBodyDialog.setText(note.body);

                new AlertDialog.Builder(RealtimeActivity.this)
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ref.child(key).removeValue();
                            }
                        }).setNegativeButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        new AlertDialog.Builder(RealtimeActivity.this)
                                .setView(binding1.getRoot())
                                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        String title = binding1.edtTitleDialog.getText().toString();
                                        String body = binding1.edtBodyDialog.getText().toString();

                                        Note n = new Note(title,body);

                                        ref.child(key).setValue(n);

                                    }
                                }).create().show();

                    }
                }).create().show();

            }
        });

    }
}