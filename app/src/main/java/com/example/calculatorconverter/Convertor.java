package com.example.calculatorconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Convertor extends AppCompatActivity {
    ImageView temperature,discount,area,time,bmi,age,currency,numeric,data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convertor);

        temperature=findViewById(R.id.temp);
        discount=findViewById(R.id.discount);
        area=findViewById(R.id.area);
        time=findViewById(R.id.time);
        bmi=findViewById(R.id.bmi);
        age=findViewById(R.id.age);
        data=findViewById(R.id.data);
        currency=findViewById(R.id.currency);
        numeric=findViewById(R.id.bin_con);
        discount=findViewById(R.id.discount);

        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Convertor.this,Temperature.class);
                startActivity(intent);
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Convertor.this,Data.class);
                startActivity(intent);
            }
        });

        discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Convertor.this,Dicount.class);
                startActivity(intent);
            }
        });
        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Convertor.this,Currancy.class);
                startActivity(intent);
            }
        });

        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Convertor.this,Area.class);
                startActivity(intent);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Convertor.this,Time.class);
                startActivity(intent);
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Convertor.this,BMI.class);
                startActivity(intent);
            }
        });
        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Convertor.this,Age.class);
                startActivity(intent);
            }
        });
        numeric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Convertor.this,NumberConversion.class);
                startActivity(intent);
            }
        });
    }
}