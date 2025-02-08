package downloadmanager;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.calculatorconverter.R;

import java.io.File;

public class DownloadFileActivity extends AppCompatActivity {
    EditText url;
    Button download;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_file);

        url=findViewById(R.id.url);
        download=findViewById(R.id.button);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUrl = url.getText().toString().trim();

                if (!getUrl.isEmpty()) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(getUrl));
                    String title = URLUtil.guessFileName(getUrl, null, null);
                    request.setTitle(title);
                    request.setDescription("Please wait, file is downloading...");

                    String cookie = CookieManager.getInstance().getCookie(getUrl);
                    request.addRequestHeader("Cookie", cookie);
                    request.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");

                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        request.setDestinationInExternalFilesDir(DownloadFileActivity.this, Environment.DIRECTORY_DOWNLOADS, title);
                    } else {
                        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title);
                    }

                    DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                    if (downloadManager != null) {
                        long downloadId = downloadManager.enqueue(request);
                        Toast.makeText(DownloadFileActivity.this, "Download Started", Toast.LENGTH_SHORT).show();

                        new Thread(() -> {
                            try {
                                Thread.sleep(2000);
                                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                                        Uri.fromFile(new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), title))));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }).start();
                    }
                }
                else {
                    Toast.makeText(DownloadFileActivity.this, "Please Enter a Valid URL", Toast.LENGTH_SHORT).show();
                }

                InputMethodManager ip=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if(ip!=null){
                    ip.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
                }
                url.setText("");
            }
        });
    }
}