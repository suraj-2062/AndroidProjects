package animation;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.calculatorconverter.R;

public class AnimationActivity extends AppCompatActivity {

    ImageView img;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        img=findViewById(R.id.img);
        Animation animation= AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.bounce);
        img.startAnimation(animation);

        /*Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                img.setVisibility(View.GONE);
            }
        },4000);*/
    }
}