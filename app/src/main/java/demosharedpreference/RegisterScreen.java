package demosharedpreference;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

public class RegisterScreen extends AppCompatActivity {
    EditText name,email,password,phone;
    Button register;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);

        sessionManager=new SessionManager(getApplicationContext());
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        register=findViewById(R.id.button);


    }
    public void register(View view){
        String user_name=name.getText().toString();
        String user_email=email.getText().toString();
        String user_password=password.getText().toString();
        String user_phone=phone.getText().toString();

        sessionManager.createSession(user_name,user_email,user_phone);
        Intent intent=new Intent(this,ProfileScreen.class);
        startActivity(intent);
    }
    public void openLoginScreen(View view){
        Intent intent=new Intent(this,LoginScreen.class);
        startActivity(intent);
    }
}