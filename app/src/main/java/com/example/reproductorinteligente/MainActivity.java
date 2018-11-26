package com.example.reproductorinteligente;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    MediaPlayer mediaPlayer=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);

        sensorManager.registerListener((SensorEventListener) this,sensorManager.getDefaultSensor
                (Sensor.TYPE_GYROSCOPE),SensorManager.SENSOR_DELAY_NORMAL);

        mediaPlayer=MediaPlayer.create(this,R.raw.cancion);
        mediaPlayer.start();

        
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

                //http://www.aprendeandroid.com/l9/sensores_android_movimiento.htm


                // Creo objeto para saber como esta la pantalla
                Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
                        .getDefaultDisplay();
                int rotation = display.getRotation();

                // El objeto devuelve 3 estados 0,1 y 3
                if (rotation == 0) {
                    //Vertical";
                    mediaPlayer.start();

                } else if (rotation == 1) {
                    //Horizontal Izq.";
                    mediaPlayer.stop();

                } else if (rotation == 3) {
                    mediaPlayer.stop();
                    //Horizontal Der";
                }
        }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
