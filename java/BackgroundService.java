package com.csi.blindsense;
 
import java.util.Locale;
 
import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
 
import android.widget.Toast;
 
 
public class BackgroundService extends Service implements SensorEventListener {
Sensor proxSensor;
SensorManager sm;
 
TextToSpeech speaker;
@Override
public IBinder onBind(Intent intent) {
    return null;
}
 
@Override
public void onCreate() {
    Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
    sm=(SensorManager)getSystemService(SENSOR_SERVICE);
    proxSensor=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
     
    
    speaker=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
     
    @Override
    public void onInit(int status) {
        if(status != TextToSpeech.ERROR){
              speaker.setLanguage(Locale.US);
             }
    }
  });
    sm.registerListener(this, proxSensor, SensorManager.SENSOR_DELAY_NORMAL);
}
@Override
public void onAccuracyChanged(Sensor sensor, int accuracy) {
    // TODO Auto-generated method stub
 
}
 
@Override
public void onSensorChanged(SensorEvent event) {
    // TODO Auto-generated method stub
    Toast.makeText(this, "dfgfd sfdsf", Toast.LENGTH_LONG).show();
 
    if (event.values[0] == 0&&!speaker.isSpeaking())
         speaker.speak("Alert", TextToSpeech.QUEUE_FLUSH, null);
}
@Override
public void onDestroy() {
    Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
}
 
@Override
public void onStart(Intent intent, int startid) {
    Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
}
 
    }
