package com.example.calculatorconverter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Age extends AppCompatActivity {

    List<String>month_name;
    List<Integer>dates;
    Spinner spinner1,spinner2,spinner3,spinner4;
    EditText edittext1,edittext2;
    String birth_month,curr_month;
    int birth_year,curr_year,birth_date,curr_date;
    Button button,reset;

    TextView years,months,weeks,days,hours,minuets,seconds;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.age);

        reset=findViewById(R.id.reset);
        button=findViewById(R.id.calculate_age);
        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        spinner3=findViewById(R.id.spinner3);
        spinner4=findViewById(R.id.spinner4);
        edittext1=findViewById(R.id.dob_year);
        edittext2=findViewById(R.id.curr_year);

        years=findViewById(R.id.years);
        months=findViewById(R.id.months);
        weeks=findViewById(R.id.weeks);
        days=findViewById(R.id.days);
        hours=findViewById(R.id.hours);
        minuets=findViewById(R.id.minutes);
        seconds=findViewById(R.id.seconds);


        month_name=Arrays.asList("Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec");
        dates= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);

        ArrayAdapter<String> sp1=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,month_name);
        sp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(sp1);

        ArrayAdapter<String> sp3=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,month_name);
        sp3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(sp3);

        ArrayAdapter<Integer>sp2=new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item,dates);
        sp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(sp2);

        ArrayAdapter<Integer>sp4=new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item,dates);
        sp4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(sp4);

        // For taking date month from spinner
         spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 birth_month=adapterView.getItemAtPosition(i).toString();
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });

         spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 curr_month=adapterView.getItemAtPosition(i).toString();
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });
         spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 birth_date=Integer.parseInt(adapterView.getItemAtPosition(i).toString());

             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });
         spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 curr_date=Integer.parseInt(adapterView.getItemAtPosition(i).toString());

             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int years_in_age=0,months_in_age=0,weeks_in_age=0,days_in_age=0,hours_in_age=0,minutes_in_age=0,seconds_in_age=0;
                int birth_yr,curr_yr,year_diff=0,month_diff=0,days_diff=0,d_month=1,c_month=1;

                Map<String,Integer> map=new HashMap<>();
                map.put("Jan",1);
                map.put("Feb",2);
                map.put("March",3);
                map.put("April",4);
                map.put("May",5);
                map.put("June",6);
                map.put("July",7);
                map.put("Aug",8);
                map.put("Sep",9);
                map.put("Oct",10);
                map.put("Nov",11);
                map.put("Dec",12);

                if(edittext1.getText().toString().isEmpty() && edittext2.getText().toString().isEmpty()){
                    birth_year=0;
                    curr_year=0;
                }
                else {
                    birth_yr = Integer.parseInt(edittext1.getText().toString());
                    curr_yr = Integer.parseInt(edittext2.getText().toString());
                    year_diff = Math.abs(birth_yr - curr_yr);
                }





                if(map.containsKey(birth_month) && map.containsKey(curr_month)){
                    d_month=map.get(birth_month);
                    c_month=map.get(curr_month);
                    month_diff=(c_month-d_month);
                    if(month_diff<0){
                        year_diff=year_diff-1;
                        month_diff=month_diff+12;

                    }
                }

                if(curr_date-birth_date<0){
                    month_diff=month_diff-1;
                   days_diff=(curr_date-birth_date)+30;
                }
                else{
                    days_diff=curr_date-birth_date;
                }

                years_in_age=year_diff;
                months_in_age=(year_diff *12)+month_diff;
                weeks_in_age=(year_diff*52)+(month_diff*4)+(days_diff/7);
                days_in_age=(year_diff*365)+(month_diff*30)+days_diff;
                hours_in_age=days_in_age*24;
                minutes_in_age=hours_in_age*60;
                seconds_in_age=minutes_in_age*60;


                years.setText(years_in_age+" : Total Number of Years in Age.");
                months.setText(months_in_age+" : Total Number of Months in Age.");
                weeks.setText(weeks_in_age+" : Total Number of Weeks in Age");
                days.setText(days_in_age+" : Total Number of Days in Age");
                hours.setText(hours_in_age+" : Total Number of Hours in Age");
                minuets.setText(minutes_in_age+" : Total Number of Minutes in Age");
                seconds.setText(seconds_in_age+" : Total Number of Seconds in Age");


                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });


         // For reset the selected contains
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner1.setSelection(0);
                spinner2.setSelection(0);
                spinner3.setSelection(0);
                spinner4.setSelection(0);
                edittext1.setText("");
                edittext2.setText("");
                birth_month="";
                curr_month="";
                birth_date=0;
                curr_date=0;
                birth_year=0;
                curr_year=0;

                years.setText("");
                months.setText("");
                weeks.setText("");
                days.setText("");
                hours.setText("");
                minuets.setText("");
                seconds.setText("");
            }
        });
    }

}