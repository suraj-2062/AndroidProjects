package com.example.calculatorconverter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsApp extends AppCompatActivity {

    RecyclerView recycler_view;
    ArrayList<GetData>list=new ArrayList<>();
    Context context;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsapp);

        recycler_view=findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        new FetchTask().execute();
    }
    private class FetchTask extends AsyncTask<Void, Void, ArrayList<GetData>> {

        @Override
        protected ArrayList<GetData> doInBackground(Void... voids) {
            GetNews obj = new GetNews();
            ArrayList<GetData> tempList = new ArrayList<>();
            try {
                tempList = obj.getList();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return tempList;
        }

        @Override
        protected void onPostExecute(ArrayList<GetData> result) {
            super.onPostExecute(result);
            list = result;

            // Set the adapter with the fetched data
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(list, NewsApp.this);
            recycler_view.setAdapter(adapter);
        }
    }


}