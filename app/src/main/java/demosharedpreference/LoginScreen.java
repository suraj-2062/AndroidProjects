package demosharedpreference;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

public class LoginScreen extends AppCompatActivity {
    EditText email,password;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        sessionManager=new SessionManager(getApplicationContext());
    }
    public void login(View view){
        String user_email=email.getText().toString();
        String user_password=password.getText().toString();

        if(user_email.equals("meenasuraj4455@gmail.com") && user_password.equals("123456789")){
            sessionManager.createSession("Suraj Meena","meenasuraj4455@gmail.com","7898100787");
            Intent intent=new Intent(getApplicationContext(),ProfileScreen.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Email id and Password dint match !", Toast.LENGTH_SHORT).show();
        }
    }
    public void openRegisterScreen(View view){
        Intent intent=new Intent(getApplicationContext(),RegisterScreen.class);
        startActivity(intent);
    }
}