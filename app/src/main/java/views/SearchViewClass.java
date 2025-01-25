package views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

import java.util.Arrays;
import java.util.List;

public class SearchViewClass extends AppCompatActivity {

    SearchView searchview;
    ListView listview;
    List<String > list;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchview_class);


        searchview=findViewById(R.id.searchview);
        listview=findViewById(R.id.listview);

        list= Arrays.asList("C++","C","JAVA","PYTHON","JAVA SCRIPT","HTML","CSS","ANDROID STUDIO");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(views.SearchViewClass.this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(adapter);

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }
}