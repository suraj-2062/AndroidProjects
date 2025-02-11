package androidservices;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.example.calculatorconverter.R;

public class NotificationActivity extends AppCompatActivity {
    Button button;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        button = findViewById(R.id.button);
        createNotificationChannel();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationActivity.this, "my_channel_id")
                        .setSmallIcon(R.drawable.accessibility)
                        .setContentTitle("Notification Example")
                        .setContentText("This is a notification message")
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManager nm = getSystemService(NotificationManager.class);
                nm.notify(1, builder.build());
            }
        });
    }

    public void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "Channel";
            String description = "Notification Channel Description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel("my_channel_id", name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
            else {
            }
        }
    }
}
