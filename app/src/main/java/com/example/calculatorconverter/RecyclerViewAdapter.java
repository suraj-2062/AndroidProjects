
package com.example.calculatorconverter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<GetData> list;
    Context context;
    public RecyclerViewAdapter(ArrayList<GetData> list,Context context) {
        this.list = list;
        this.context=context;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.cardview,parent,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        GetData data=list.get(position);
        holder.title.setText(data.getTitle());
        holder.content.setText(data.getContents());
        holder.source_url.setOnClickListener(view -> {
            Intent intent=new Intent(view.getContext(),RecyclerViewAdapter.class);
            intent.putExtra("url",data.getSource_url());
            view.getContext().startActivity(intent);
        });

        new Thread(() -> {
            Bitmap bitmap = getBitmapFromURL(data.getImage_url());
            holder.image_url.post(() -> {
                if (bitmap != null) {
                    holder.image_url.setImageBitmap(bitmap);
                } else {
                    holder.image_url.setImageResource(R.drawable.icon);
                }
            });
        }).start();
//        Glide.with(context).load(data.getImage_url()).into(holder.image_url);
    }
    public int getItemCount() {
        return list.size();
    }
    public static Bitmap getBitmapFromURL(String imgUrl) {
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

}
