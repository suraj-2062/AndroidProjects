package newsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.calculatorconverter.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView image_url;
    public TextView title,content,source_url;
    public ViewHolder(View view) {
        super(view);
        image_url=view.findViewById(R.id.image_url);
        title=view.findViewById(R.id.title);
        content=view.findViewById(R.id.content);
        source_url=view.findViewById(R.id.source_url);
    }
}
