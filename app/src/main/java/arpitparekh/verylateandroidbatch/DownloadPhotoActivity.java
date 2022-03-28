package arpitparekh.verylateandroidbatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import arpitparekh.verylateandroidbatch.databinding.ActivityDownloadPhotoBinding;

public class DownloadPhotoActivity extends AppCompatActivity {

    private ActivityDownloadPhotoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDownloadPhotoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnDownload.setOnClickListener(view -> {

            new Thread(() -> {

                try {

                    URL url = new URL("https://i.picsum.photos/id/35/536/354.jpg?hmac=jp_Ypjavu2-qfJva-2dR-Mwusv5WWX1CqL5j_o0rPbg");

                    InputStream is = url.openStream();

                    DataInputStream ds = new DataInputStream(is);

                    byte[] arr = new byte[1024];

                    int length;

                    FileOutputStream os = new FileOutputStream(new File(Environment.getExternalStorageDirectory()+"/"+"test.jpg"));

                    while((length=ds.read(arr))>0){

                        os.write(arr,0,length);

                    }
                    ds.close();
                    os.close();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(DownloadPhotoActivity.this, "Download Successful", Toast.LENGTH_SHORT).show();

                        }
                    });


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }).start();

        });

    }
}