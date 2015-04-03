package com.csi.blindsense;
 
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
 
 
public class MainActivity extends Activity implements OnClickListener {
Button buttonStart, buttonStop;
 
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
 
buttonStart = (Button) findViewById(R.id.buttonStart);
buttonStop = (Button) findViewById(R.id.buttonStop);
 
buttonStart.setOnClickListener(this);
buttonStop.setOnClickListener(this);
}
 
public void onClick(View src) {
switch (src.getId()) {
case R.id.buttonStart:
  startService(new Intent(this, BackgroundService.class));
 
  break;
case R.id.buttonStop:
  stopService(new Intent(this, BackgroundService.class));
  break;
}
}
}
