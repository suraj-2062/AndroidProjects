
package viewsinandroid;
import android.os.Bundle;
import android.widget.GridView;


import androidx.appcompat.app.AppCompatActivity;
import com.example.calculatorconverter.R;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    GridView gridview;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridview=findViewById(R.id.gridview);
        ArrayList<Details>list=new ArrayList<Details>();

        list.add(new Details(R.drawable.age,"age"));
        list.add(new Details(R.drawable.area,"Area"));
        list.add(new Details(R.drawable.data,"Data"));
        list.add(new Details(R.drawable.number_con,"Number Conversion"));
        list.add(new Details(R.drawable.currency,"Currency"));
        list.add(new Details(R.drawable.discount,"Discount"));
        list.add(new Details(R.drawable.bmi,"BMI"));
        list.add(new Details(R.drawable.time,"Time"));
        list.add(new Details(R.drawable.mass,"Mass"));

        GridviewAdapter adapter=new GridviewAdapter(this,list);
        gridview.setAdapter(adapter);
    }
}