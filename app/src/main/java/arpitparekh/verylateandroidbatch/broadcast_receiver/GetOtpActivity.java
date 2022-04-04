package arpitparekh.verylateandroidbatch.broadcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

import arpitparekh.verylateandroidbatch.databinding.ActivityGetOtpBinding;

public class GetOtpActivity extends AppCompatActivity {

    private ActivityGetOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SmsReceiver receiver = new SmsReceiver(binding.edtOtp);
        IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(receiver,filter);

    }
}