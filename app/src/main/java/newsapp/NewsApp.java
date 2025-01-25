package newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import newsapp.GetNews;
import com.example.calculatorconverter.R;

import java.util.ArrayList;

public class NewsApp extends AppCompatActivity {

    RecyclerView recycler_view;
    ArrayList<GetData> list=new ArrayList<>();
    Context context;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_app);

        recycler_view=findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        new NewsApp.FetchTask().execute();
    }
    private class FetchTask extends AsyncTask<Void, Void, ArrayList<GetData>> {

        @Override
        protected ArrayList<GetData> doInBackground(Void... voids) {
            GetNews obj = new GetNews();
            ArrayList<GetData> tempList;
            try {
                tempList=obj.getList();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return tempList;
        }

        @Override
        protected void onPostExecute(ArrayList<GetData> result) {
            super.onPostExecute(result);
            list = result;

            // Set the adapter with the fetched data
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(list, newsapp.NewsApp.this);
            recycler_view.setAdapter(adapter);
        }
    }
}