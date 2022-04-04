package arpitparekh.verylateandroidbatch.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import arpitparekh.verylateandroidbatch.databinding.ActivitySensorBinding;


public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private ActivitySensorBinding binding;
    SensorManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySensorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        manager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);

        Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT);

        ArrayList<Sensor> list = (ArrayList<Sensor>) manager.getSensorList(Sensor.TYPE_ALL);

        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {


            binding.getRoot().setBackgroundColor(Color.rgb(random(),random(),random()));

        Log.i("eventLogCustom",String.valueOf(sensorEvent.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    int random(){

        Random r = new Random();

        return  r.nextInt(256);

    }

}