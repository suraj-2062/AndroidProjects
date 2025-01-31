package toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

public class ToolBarActivity extends AppCompatActivity {

    Toolbar toolbar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        toolbar=findViewById(R.id.toolbar);

        // Step 1
        setSupportActionBar(toolbar);
        // Step 2
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setTitle("Title");
        toolbar.setSubtitle("Subtitle");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_manu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid=item.getItemId();

        if(itemid==R.id.back){
            Toast.makeText(this, "you clicked on back icon", Toast.LENGTH_SHORT).show();
        }
        else if (itemid==R.id.navigation){
            Toast.makeText(this, "you clicked on Navigation icon", Toast.LENGTH_SHORT).show();
        }
        else if (itemid==R.id.download){
            Toast.makeText(this, "you clicked on Download icon", Toast.LENGTH_SHORT).show();
        }
        else if (itemid==R.id.forward){
            Toast.makeText(this, "you clicked on Forward icon", Toast.LENGTH_SHORT).show();
        }
        else if (itemid==R.id.accessibility){
            Toast.makeText(this, "you clicked on Accessibility icon", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "You clicked Home icon" , Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}