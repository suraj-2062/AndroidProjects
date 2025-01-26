package viewsinandroid;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.calculatorconverter.R;

import java.util.ArrayList;

public class GridviewAdapter extends ArrayAdapter<Details> {

    public GridviewAdapter(@NonNull Context context,ArrayList<Details>list) {
        super(context,0, list);
    }
    public View getView(int position, View view, ViewGroup parent){
        View v=view;
        if(v==null){
            v= LayoutInflater.from(getContext()).inflate(R.layout.grid_item,parent,false);
        }
        Details details=getItem(position);
        ImageView img=v.findViewById(R.id.imageview);
        TextView txt=v.findViewById(R.id.textview);

        img.setImageResource(details.getImageView());
        txt.setText(details.getTextView());
        return v;
    }
}
