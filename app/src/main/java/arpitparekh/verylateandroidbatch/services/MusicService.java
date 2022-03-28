package arpitparekh.verylateandroidbatch.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import arpitparekh.verylateandroidbatch.R;

public class MusicService extends Service {

    private MediaPlayer mp;

    @Override
    public void onCreate() {

        mp = MediaPlayer.create(this, R.raw.music);
        mp.setVolume(100,100);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mp.stop();
        super.onDestroy();
    }
}
