package demosharedpreference;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

public class ProfileScreen extends AppCompatActivity {
    SessionManager sessionManager;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_screen);

        sessionManager=new SessionManager(getApplicationContext());
        name=findViewById(R.id.name);
        String user_name=sessionManager.getSessionDetail("session_name");
        name.setText(user_name);
    }
    public void logout(View view){
        sessionManager.clearSession();
    }
}