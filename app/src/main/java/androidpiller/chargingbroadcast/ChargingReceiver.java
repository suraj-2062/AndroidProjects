package androidpiller.chargingbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class ChargingReceiver extends BroadcastReceiver {
    int level;
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())){
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
            int status=intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);

            String currstatus;
            if(status==BatteryManager.BATTERY_STATUS_NOT_CHARGING){
                currstatus="Battery Not Charging";
            }
            else if(status==BatteryManager.BATTERY_STATUS_CHARGING){
                currstatus="Battery is Charging";
            }
            else if(status==BatteryManager.BATTERY_STATUS_FULL){
                currstatus="Battery is Full";
            }
            else if(status==BatteryManager.BATTERY_STATUS_DISCHARGING){
                currstatus="Battery is Discharging";
            }
            else{
                currstatus="unknown status";
            }
            String massage ="Battery Level : "+ level+"%\n"+currstatus;
            Toast.makeText(context, massage, Toast.LENGTH_SHORT).show();
        }

    }
}
