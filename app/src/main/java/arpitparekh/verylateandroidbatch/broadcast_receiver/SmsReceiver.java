package arpitparekh.verylateandroidbatch.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    EditText editText;

    SmsReceiver(EditText editText){

        this.editText = editText;

    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Aiivo msg", Toast.LENGTH_SHORT).show();

        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){

            SmsMessage[] smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

            for(SmsMessage sms : smsMessages){

                String msg = sms.getMessageBody();

                String otp = msg.split(": ")[1];

                editText.setText(otp);

            }


        }

    }
}
