package androidsensors;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.hardware.SensorEvent;
import android.hardware.Sensor;
import com.example.calculatorconverter.R;

import java.util.List;

public class MainActivity extends Activity {
    SensorManager sensorManager = null;
    TextView textView = null;
    List list;
    SensorEventListener sel = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            textView.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
        }
    };
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        textView =findViewById(R.id.textview);
        list = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if(list.size()>0){
            sensorManager.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(getBaseContext(), "Error: No Accelerometer.", Toast.LENGTH_LONG).show();
        }
    }
    protected void onStop() {
        if(list.size()>0){
            sensorManager.unregisterListener(sel);
        }
        super.onStop();
    }
}