package switcher;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

public class SwitcherActivity extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    Button next;
    int arr[]={R.drawable.waterfallveiw,R.drawable.lakeview,R.drawable.treeview,R.drawable.mountainview};
    int len=arr.length;
    int count=-1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switcher);

        imageSwitcher=findViewById(R.id.img_switcher);
        next=findViewById(R.id.button);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView switcherImageView=new ImageView(getApplicationContext());
                switcherImageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.FILL_PARENT,ActionBar.LayoutParams.FILL_PARENT));
                switcherImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                switcherImageView.setImageResource(R.drawable.waterfallveiw);
                return switcherImageView;
            }
        });

        Animation aniOut= AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation aniIn=AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        imageSwitcher.setOutAnimation(aniOut);
        imageSwitcher.setInAnimation(aniIn);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if(count==len){
                    count=0;
                    imageSwitcher.setImageResource(arr[count]);
                }
                else{
                    imageSwitcher.setImageResource(arr[count]);
                }
            }
        });
    }
}