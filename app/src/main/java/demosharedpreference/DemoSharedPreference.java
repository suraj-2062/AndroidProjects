package demosharedpreference;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

public class DemoSharedPreference extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_shared_preference);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SessionManager sessionManager=new SessionManager(getApplicationContext());
                boolean flag=sessionManager.sessionCheck();
                if(flag){
                    Intent intent=new Intent(getApplicationContext(),ProfileScreen.class);
                    startActivity(intent);
                }
                else{
                    Intent intent=new Intent(getApplicationContext(),LoginScreen.class);
                    startActivity(intent);
                }
            }
        },2000);
    }
}