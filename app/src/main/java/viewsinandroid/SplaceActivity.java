package viewsinandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

public class SplaceActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splace);

        Intent intent=new Intent(getApplicationContext(),SplaceMainMainActivity.class);
        new Handler().postDelayed( new Runnable(){
            @Override
            public void run() {
               startActivity(intent);
            }
        },1000);
    }
}