package toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.calculatorconverter.R;
import com.google.android.material.navigation.NavigationView;

public class navigationActivity extends AppCompatActivity {

    DrawerLayout drawerlayout;
    NavigationView navigationview;
    Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        drawerlayout=findViewById(R.id.drawerlayout);
        toolbar=findViewById(R.id.toolbar);
        navigationview=findViewById(R.id.navigationview);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this
        ,drawerlayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.account){
                    Toast.makeText(navigationActivity.this, "Account", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.setting){
                    Toast.makeText( navigationActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.logout){
                    Toast.makeText(navigationActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                }
                drawerlayout.closeDrawers();
                return true;
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerlayout.isDrawerOpen(GravityCompat.START)) {
                    drawerlayout.closeDrawer(GravityCompat.START);
                } else{
                    finish();
                }
            }
        });
    }
}