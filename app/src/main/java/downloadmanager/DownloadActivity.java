package downloadmanager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadActivity extends AppCompatActivity {
    private EditText url;
    private Button download,location;
    private Uri pickedFileUrl;
    View view;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        url=findViewById(R.id.url);
        download=findViewById(R.id.button);
        location=findViewById(R.id.location);

        location.setOnClickListener(v -> filePick());

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUrl=url.getText().toString();
                if(!getUrl.isEmpty()){
                    if(pickedFileUrl!=null){
                        fileDownload(getUrl,pickedFileUrl);
                    }
                    else{
                        Toast.makeText(DownloadActivity.this, "Please picked file name", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(DownloadActivity.this, "Please enter Url than after download possible", Toast.LENGTH_SHORT).show();
                }
                view=getCurrentFocus();
                if(view!=null){
                    InputMethodManager ip=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    ip.hideSoftInputFromWindow(view.getWindowToken(),0);
                }
                url.setText("");
            }
        });
    }

    private void filePick(){
        String fileName= URLUtil.guessFileName(url.getText().toString(),null,null);
        Intent intent=new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TITLE,fileName);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        filePickerLauncher.launch(intent);
    }
    private final ActivityResultLauncher<Intent>filePickerLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result ->{
        if(result.getResultCode()==RESULT_OK && result.getData()!=null){
            pickedFileUrl=result.getData().getData();
            Toast.makeText(this, "File location selected", Toast.LENGTH_SHORT).show();
        }
    });
    private void fileDownload(String fileUrl,Uri urllcation){
        new Thread(()->{
            try {
                URL getUrl=new URL(fileUrl);
                HttpURLConnection connection=(HttpURLConnection) getUrl.openConnection();
                connection.connect();

                if(connection.getResponseCode()!=HttpURLConnection.HTTP_OK){
                    runOnUiThread(()->{
                        Toast.makeText(this, "Download Failed", Toast.LENGTH_SHORT).show();
                        return;
                    });
                }
                InputStream inputStream=connection.getInputStream();
                OutputStream outputStream=getContentResolver().openOutputStream(urllcation);
                
                if(outputStream==null){
                    runOnUiThread(()-> {
                        Toast.makeText(this, "Error writing file", Toast.LENGTH_SHORT).show();
                        return;
                    });
                }
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.flush();
                outputStream.close();
                inputStream.close();

                runOnUiThread(() -> Toast.makeText(this, "Download Complete", Toast.LENGTH_SHORT).show());
            }
            catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(this, "Download failed", Toast.LENGTH_SHORT).show());
            }

        }).start();
    }
}