package arpitparekh.verylateandroidbatch.broadcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import arpitparekh.verylateandroidbatch.databinding.ActivityBroadCastBinding;

public class BroadCastActivity extends AppCompatActivity {

    private ActivityBroadCastBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBroadCastBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        IntentFilter filter = new IntentFilter(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(new WifiReceiver(),filter);

    }
}