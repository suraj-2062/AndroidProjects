package androidpiller;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.example.calculatorconverter.R;

public class MyServices extends Service {
    MediaPlayer player;
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=MediaPlayer.create(this, R.raw.tune);
        player.setLooping(true);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, "Music started", Toast.LENGTH_SHORT).show();
        player.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Music Stoped", Toast.LENGTH_SHORT).show();
        player.stop();
    }
}
