package layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

public class Framelayout extends AppCompatActivity {
    EditText email,password;
    Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framelayout);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString()!=null && password.getText().toString()!=null){
                    Toast.makeText(Framelayout.this,email.getText().toString()+" "+password.getText().toString(),Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Framelayout.this, "Please enter email and passwod ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}