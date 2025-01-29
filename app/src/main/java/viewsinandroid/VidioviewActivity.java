package viewsinandroid;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

public class VidioviewActivity extends AppCompatActivity {
    VideoView vidioview;
    Button button;
    MediaController mediaController;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vidioview);

        vidioview=findViewById(R.id.vidioview);
        button=findViewById(R.id.button);

        //vidioview.setVideoPath("app/src/main/res/raw/song");

        mediaController=new MediaController(this);
        mediaController.setAnchorView(vidioview);
        mediaController.setMediaPlayer(vidioview);
        vidioview.setMediaController(mediaController);

        Uri videoUri = Uri.parse("https://www.youtube.com/watch?v=rnCikyhg6M8&list=RDrnCikyhg6M8&start_radio=1");
        vidioview.setVideoURI(videoUri);

        //vidioview.start();

//        button.setOnClickListener(view -> {
//            vidioview.start();
//        });
    }
}