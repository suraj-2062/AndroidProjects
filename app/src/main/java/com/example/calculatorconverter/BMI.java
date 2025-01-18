package com.example.calculatorconverter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMI extends AppCompatActivity {

    ImageView male,female;
    EditText age,weight,height;
    TextView show_result,select_gender;
    Button button,reset;
    double get_wt,get_ht,get_age;
    String get_male,get_female;
    LinearLayout main;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        reset=findViewById(R.id.reset);
        button=findViewById(R.id.calculate_bmi);
        main=findViewById(R.id.bmi_show);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);

        age=findViewById(R.id.age);
        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);

        show_result=findViewById(R.id.result);
        select_gender=findViewById(R.id.select_gender);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetData(view);
                select_gender.setText(" Male");
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetData(view);
                select_gender.setText(" Female");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!age.getText().toString().isEmpty() && !weight.getText().toString().isEmpty() && !height.getText().toString().isEmpty()){
                    get_age=Integer.parseInt(age.getText().toString());
                    get_wt=Integer.parseInt(weight.getText().toString());
                    get_ht=Integer.parseInt(height.getText().toString());

                    double ht_meter=get_ht/100;

                    double bmi=get_wt/(ht_meter*ht_meter);

                    if (bmi < 18.5) {
                        main.setBackgroundColor(Color.parseColor("#E30635"));
                        show_result.setText(" You are Underweight");
                    } else if (bmi >= 25 && bmi<29.9) {
                        main.setBackgroundColor(Color.parseColor("#50B529"));
                        show_result.setText(" You are Overweight");
                    } else if(bmi>=18.5 && bmi<24.9) {
                        main.setBackgroundColor(Color.parseColor("#D1C10C"));
                        show_result.setText(" You have a Normal Weight");
                    }
                    else {
                        main.setBackgroundColor(Color.RED);
                        show_result.setText("Obesity");
                    }
                }
                InputMethodManager ip=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if(ip!=null){
                    ip.hideSoftInputFromWindow(view.getWindowToken(),0);
                }
            }
        });
    }
    public void resetData(View view){
        age.setText("");
        weight.setText("");
        height.setText("");
        select_gender.setText("");
        male.clearColorFilter();
        female.clearColorFilter();
    }
}