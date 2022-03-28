package arpitparekh.verylateandroidbatch.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import arpitparekh.verylateandroidbatch.databinding.ActivityMyServiceBinding;

public class MyServiceActivity extends AppCompatActivity {

    private ActivityMyServiceBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnPlayMusic.setOnClickListener(view -> {

            Intent i = new Intent(this,MusicService.class);
            startService(i);

        });

    }
}