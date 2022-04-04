package arpitparekh.verylateandroidbatch.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class WifiReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        try {

            if(Settings.Global.getInt(context.getContentResolver(),Settings.Global.WIFI_ON)!=0){

                Toast.makeText(context, "Wifi On", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Wifi Off", Toast.LENGTH_SHORT).show();
            }
        } catch (Settings.SettingNotFoundException e) {
            Log.i("wifi",e.toString());
        }

    }
}
