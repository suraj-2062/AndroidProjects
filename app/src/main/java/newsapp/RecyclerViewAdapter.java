package newsapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.calculatorconverter.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<GetData> list;
    Context context;
    public RecyclerViewAdapter(ArrayList<GetData> list, Context context) {
        this.list = list;
        this.context=context;
    }
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cardview,parent,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        GetData data=list.get(position);
        holder.title.setText(data.getTitle());
        holder.content.setText(data.getContents());
        holder.source_url.setOnClickListener(view -> {
            Intent intent=new Intent(view.getContext(), WebviewActivity.class);


            intent.putExtra("url",data.getSource_url());
            view.getContext().startActivity(intent); // Problem...
        });

        new Thread(() -> {
            Bitmap bitmap;
            try {
                bitmap = getBitmapFromURL(data.getImage_url());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Bitmap finalBitmap = bitmap;
            holder.image_url.post(() -> {
                if (finalBitmap != null) {
                    holder.image_url.setImageBitmap(finalBitmap);
                } else {
                    holder.image_url.setImageResource(R.drawable.icon);
                }
            });
        }).start();
       // Glide.with(context).load(data.getImage_url()).into(holder.image_url);
    }
    public int getItemCount() {
        return list.size();
    }
    public static Bitmap getBitmapFromURL(String imgUrl){
        try {
            URL url = new URL(imgUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
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

}
