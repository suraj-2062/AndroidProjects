package com.example.calculatorconverter;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

import android.annotation.SuppressLint;
import android.content.Context;
import android.icu.math.BigDecimal;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class Time extends AppCompatActivity {
    Spinner spinner1,spinner2;
    EditText input;
    TextView result;
    String input_value,output_value;
    List<String>list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        input=findViewById(R.id.input);
        result=findViewById(R.id.result);

        list=Arrays.asList("Year","Week","Day","Hour","Minute","Second","Millisecond","Microsecond","Picosecond");

        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                input_value=spinner1.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                output_value=spinner2.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!input.getText().toString().isEmpty()) {
                    double value = Double.parseDouble(input.getText().toString());
                    switch (input_value) {
                        case "Year":
                            result.setText(yearToOther(value, output_value));
                            break;
                        case "week":
                            result.setText(weekToOther(value, output_value));
                            break;
                        case "Day":
                            result.setText(dayToOther(value, output_value));
                            break;
                        case "Hour":
                            result.setText(hourToOther(value, output_value));
                            break;
                        case "Minute":
                            result.setText(minuteToOther(value, output_value));
                            break;
                        case "Second":
                            result.setText(secondToOther(value, output_value));
                            break;
                        case "Millisecond":
                            result.setText(millisecondToOther(value, output_value));
                            break;
                        case "Microsecond":
                            result.setText(microsecondToOther(value, output_value));
                            break;
                        case "Pecosecond":
                            result.setText(picosecondToOther(value, output_value));
                            break;
                        default:
                            break;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public String yearToOther(double value,String output){
        switch (output){
            case "Week":
                return String.valueOf(value*52.143)+" "+getString(R.string.week);
            case "Day":
                return String.valueOf(value*365.25)+" "+getString(R.string.day);
            case "Hour":
                return String.valueOf(value*8766)+" "+getString(R.string.hour);
            case "Minute":
                return String.valueOf(value*525960)+" "+getString(R.string.minute);
            case "Second":
                return String.valueOf(value*31557600)+" "+getString(R.string.second);
            case "Millisecond":
                return String.valueOf(value*31557600000L)+" "+getString(R.string.milliseconds);
            case "Microsecond":
                return String.valueOf(value*31557600000000L)+" "+getString(R.string.microseconds);
            case "Picosecond":
                return String.valueOf(value*31557600000000000L)+" "+getString(R.string.picoseconds);
            default:
                return String.valueOf(value)+" "+getString(R.string.year);
        }
    }
    public String weekToOther(double value,String output){
        switch (output){
            case "Year":
                return String.valueOf(value*	0.019165)+" "+getString(R.string.year);
            case "Day":
                return String.valueOf(value*7)+" "+getString(R.string.day);
            case "Hour":
                return String.valueOf(value*168)+" "+getString(R.string.hour);
            case "Minute":
                return String.valueOf(value*10080)+" "+getString(R.string.minute);
            case "Second":
                return String.valueOf(value*604800)+" "+getString(R.string.second);
            case "Millisecond":
                return String.valueOf(value*604800000L)+" "+getString(R.string.milliseconds);
            case "Microsecond":
                return String.valueOf(value*604800000000L)+" "+getString(R.string.microseconds);
            case "Picosecond":
                return String.valueOf(value*604800000000000L)+" "+getString(R.string.picoseconds);
            default:
                return String.valueOf(value)+" "+getString(R.string.week);
        }
    }
    public String dayToOther(double value,String output){
        switch (output) {
            case "Year":
                return String.valueOf(value * 0.002738) + " " + getString(R.string.year);
            case "Week":
                return String.valueOf(value * 0.142857) + " " + getString(R.string.week);
            case "Hour":
                return String.valueOf(value * 24) + " " + getString(R.string.hour);
            case "Minute":
                return String.valueOf(value * 1440) + " " + getString(R.string.minute);
            case "Second":
                return String.valueOf(value * 86400) + " " + getString(R.string.second);
            case "Millisecond":
                return String.valueOf(value * 86400000L) + " " + getString(R.string.milliseconds);
            case "Microsecond":
                return String.valueOf(value * 86400000000L) + " " + getString(R.string.microseconds);
            case "Picosecond":
                return String.valueOf(value * 86400000000000L) + " " + getString(R.string.picoseconds);
            default:
                return String.valueOf(value) + " " + getString(R.string.day);
        }
    }
    public String hourToOther(double value,String output){
        switch (output) {
            case "Year":
                return String.valueOf(value * 0.000114) + " " + getString(R.string.year);
            case "Week":
                return String.valueOf(value * 0.005952) + " " + getString(R.string.week);
            case "Day":
                return String.valueOf(value * 0.041667) + " " + getString(R.string.day);
            case "Minute":
                return String.valueOf(value * 60) + " " + getString(R.string.minute);
            case "Second":
                return String.valueOf(value * 3600) + " " + getString(R.string.second);
            case "Millisecond":
                return String.valueOf(value * 3600000) + " " + getString(R.string.milliseconds);
            case "Microsecond":
                return String.valueOf(value * 3600000000L) + " " + getString(R.string.microseconds);
            case "Picosecond":
                return String.valueOf(value * 3600000000000L) + " " + getString(R.string.picoseconds);
            default:
                return String.valueOf(value) + " " + getString(R.string.hour);
        }
    }
    public String minuteToOther(double value,String output){
        switch (output) {
            case "Year":
                return String.valueOf(value * 0.000002) + " " + getString(R.string.year);
            case "Week":
                return String.valueOf(value * 0.000099) + " " + getString(R.string.week);
            case "Day":
                return String.valueOf(value * 0.000694) + " " + getString(R.string.day);
            case "hour":
                return String.valueOf(value * 0.016667) + " " + getString(R.string.hour);
            case "Second":
                return String.valueOf(value * 60) + " " + getString(R.string.second);
            case "Millisecond":
                return String.valueOf(value * 60000) + " " + getString(R.string.milliseconds);
            case "Microsecond":
                return String.valueOf(value * 60000000L) + " " + getString(R.string.microseconds);
            case "Picosecond":
                return String.valueOf(value * 60000000000L) + " " + getString(R.string.picoseconds);
            default:
                return String.valueOf(value) + " " + getString(R.string.minute);
        }
    }
    public String secondToOther(double value,String output){
        switch (output) {
            case "Year":
                return String.valueOf(value * 3.17E-8) + " " + getString(R.string.year);
            case "Week":
                return String.valueOf(value * 1.65E-6) + " " + getString(R.string.week);
            case "Day":
                return String.valueOf(value * 1.16E-5) + " " + getString(R.string.day);
            case "hour":
                return String.valueOf(value * 0.000278) + " " + getString(R.string.hour);
            case "Minute":
                return String.valueOf(value * 0.016667) + " " + getString(R.string.minute);
            case "Millisecond":
                return String.valueOf(value * 1000) + " " + getString(R.string.milliseconds);
            case "Microsecond":
                return String.valueOf(value * 1000000L) + " " + getString(R.string.microseconds);
            case "Picosecond":
                return String.valueOf(value * 1000000000L) + " " + getString(R.string.picoseconds);
            default:
                return String.valueOf(value) + " " + getString(R.string.second);
        }
    }
    public String millisecondToOther(double value,String output){
        switch (output) {
            case "Year":
                return String.valueOf(value * 3.17E-11) + " " + getString(R.string.year);
            case "Week":
                return String.valueOf(value * 1.65E-9) + " " + getString(R.string.week);
            case "Day":
                return String.valueOf(value * 1.16E-8) + " " + getString(R.string.day);
            case "hour":
                return String.valueOf(value * 2.78E-7) + " " + getString(R.string.hour);
            case "Minute":
                return String.valueOf(value * 1.67E-5) + " " + getString(R.string.minute);
            case "Second":
                return String.valueOf(value * 0.001) + " " + getString(R.string.second);
            case "Microsecond":
                return String.valueOf(value * 1000) + " " + getString(R.string.microseconds);
            case "Picosecond":
                return String.valueOf(value * 1000000000L) + " " + getString(R.string.picoseconds);
            default:
                return String.valueOf(value) + " " + getString(R.string.milliseconds);
        }
    }
    public String microsecondToOther(double value,String output){
        switch (output) {
            case "Year":
                return String.valueOf(value * 3.17E-14) + " " + getString(R.string.year);
            case "Week":
                return String.valueOf(value * 1.65E-12) + " " + getString(R.string.week);
            case "Day":
                return String.valueOf(value * 1.16E-11) + " " + getString(R.string.day);
            case "hour":
                return String.valueOf(value * 2.78E-9) + " " + getString(R.string.hour);
            case "Minute":
                return String.valueOf(value * 1.67E-7) + " " + getString(R.string.minute);
            case "Second":
                return String.valueOf(value * 1E-6) + " " + getString(R.string.second);
            case "Millisecond":
                return String.valueOf(value * 0.001) + " " + getString(R.string.milliseconds);
            case "Picosecond":
                return String.valueOf(value * 1000000) + " " + getString(R.string.picoseconds);
            default:
                return String.valueOf(value) + " " + getString(R.string.microseconds);
        }
    }
    public String picosecondToOther(double value,String output){
        switch (output) {
            case "Year":
                return String.valueOf(value * 3.17E-20) + " " + getString(R.string.year);
            case "Week":
                return String.valueOf(value * 1.65E-18) + " " + getString(R.string.week);
            case "Day":
                return String.valueOf(value * 1.16E-17) + " " + getString(R.string.day);
            case "hour":
                return String.valueOf(value * 2.78E-16) + " " + getString(R.string.hour);
            case "Minute":
                return String.valueOf(value * 1.67E-14) + " " + getString(R.string.minute);
            case "Second":
                return String.valueOf(value * 1E-12) + " " + getString(R.string.second);
            case "Millisecond":
                return String.valueOf(value * 1E-9) + " " + getString(R.string.milliseconds);
            case "Microsecond":
                return String.valueOf(value * 1E-6) + " " + getString(R.string.microseconds);
            default:
                return String.valueOf(value) + " " + getString(R.string.picoseconds);
        }
    }
}