package com.example.calculatorconverter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
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

public class Area extends AppCompatActivity {

    Spinner spinner1,spinner2;
    String input,output;
    TextView result;
    Button calculate,reset;
    EditText unit_value;
    List<String>list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area);

        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        result=findViewById(R.id.result);
        calculate=findViewById(R.id.button);
        reset=findViewById(R.id.reset);
        unit_value=findViewById(R.id.unit_value);

        list= Arrays.asList("Kilometer","Meter","Centimeter","Millimeter","Inch","Mile","Foot","Yard");

        ArrayAdapter<String>sp1=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list);
        sp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(sp1);

        ArrayAdapter<String>sp2=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list);
        sp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(sp2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                input=spinner1.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                output=spinner2.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner1.setSelection(0);
                spinner2.setSelection(0);
                unit_value.setText("");
                result.setText("");
            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(unit_value.getText().toString().isEmpty()){
                    result.setText("Invalid");
                    return;
                }

                double value=Double.parseDouble(unit_value.getText().toString());
                switch(input){
                    case "Kilometer":
                        if(output.equals("Meter")){
                            double m=value*1000;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Centimeter")){
                            double m=value*1000;
                            m=m*100;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Millimeter")){
                            double m=value*1000;
                            m=m*100;
                            m=m*10;
                            result.setText(String.valueOf(m));
                        }
                        else if (output.equals("Mile")) {
                            double m=value/1.61;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Inch")){
                            double inch=2.54;
                            double cm=value*1000;
                            cm=cm*100;
                            cm=cm/inch;
                            result.setText(String.valueOf(cm));
                        }
                        else if(output.equals("Foot")){
                            double foot=12*2.54;
                            double cm=value*1000*100;
                            cm=cm/foot;
                            result.setText(String.valueOf(cm));
                        }
                        else if(output.equals("Yard")){
                            double yard=36*2.54;
                            double cm=value*1000*100;
                            cm=cm/yard;
                            result.setText(String.valueOf(cm));
                        }
                        else{
                            result.setText(String.valueOf(value));
                        }
                        break;

                    case "Meter":

                        if(output.equals("Kilometer")){
                            double m=value/1000;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Centimeter")){
                            double m=value/1000;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Millimeter")){
                            double m=value*1000;
                            result.setText(String.valueOf(m));
                        }
                        else if (output.equals("Mile")) {
                            double m=value/1000;
                            m=m/1.61;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Inch")){
                            double inch=2.54;
                            double cm=value*100;
                            cm=cm/inch;
                            result.setText(String.valueOf(cm));
                        }
                        else if(output.equals("Foot")){
                            double foot=12*2.54;
                            double cm=value*100;
                            cm=cm/foot;
                            result.setText(String.valueOf(cm));
                        }
                        else if(output.equals("Yard")){
                            double yard=36*2.54;
                            double cm=value*100;
                            cm=cm/yard;
                            result.setText(String.valueOf(cm));
                        }
                        else{
                            result.setText(String.valueOf(value));
                        }
                        break;

                    case "Centimeter":
                        if(output.equals("Kilometer")){
                            double m=value/100000;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Meter")){
                            double m=value/100;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Millimeter")){
                            double m=value/10;
                            result.setText(String.valueOf(m));
                        }
                        else if (output.equals("Mile")) {
                            double mile=1.61*1000*100;
                            double m=value/mile;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Inch")){
                            double inch=2.54;
                            double cm=value/inch;
                            result.setText(String.valueOf(cm));
                        }
                        else if(output.equals("Foot")){
                            double foot=12*2.54;
                            double cm=value/foot;
                            result.setText(String.valueOf(cm));
                        }
                        else if(output.equals("Yard")){
                            double yard=36*2.54;
                            double cm=value/yard;
                            result.setText(String.valueOf(cm));
                        }
                        else{
                            result.setText(String.valueOf(value));
                        }
                        break;

                    case "Millimeter":

                        if(output.equals("Kilometer")){
                            double mm=1*1000*100*10;
                            mm=value/mm;
                            result.setText(String.valueOf(mm));
                        }
                        else if(output.equals("Meter")){
                            double mm=1*100*10;
                            mm=value/mm;
                            result.setText(String.valueOf(mm));
                        }
                        else if(output.equals("Centimeter")){
                            double mm=value/10;
                            result.setText(String.valueOf(mm));
                        }
                        else if (output.equals("Mile")) {
                            double mile=1.61*1000*100*10;
                            double mm=value/mile;
                            result.setText(String.valueOf(mm));
                        }
                        else if(output.equals("Inch")){
                            double inch=2.54*10;
                            double cm=value/inch;
                            result.setText(String.valueOf(cm));
                        }
                        else if(output.equals("Foot")){
                            double foot=12*2.54*10;
                            double cm=value/foot;
                            result.setText(String.valueOf(cm));
                        }
                        else if(output.equals("Yard")){
                            double yard=36*2.54*10;
                            double cm=value/yard;
                            result.setText(String.valueOf(cm));
                        }
                        else{
                            result.setText(String.valueOf(value));
                        }
                        break;

                    case "Mile":

                        if(output.equals("Kilometer")){
                            double m=1.61*1000;
                            value=value*1000;
                            double km=value/m;
                            result.setText(String.valueOf(km));
                        }
                        else if(output.equals("Meter")){
                            double m=value*1000;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Centimeter")){
                            double cm=value*1000*100;
                            result.setText(String.valueOf(cm));
                        }
                        else if (output.equals("Millimeter")) {
                            double mile=value*1000*100*10;
                            result.setText(String.valueOf(mile));
                        }
                        else if(output.equals("Inch")){
                            double inch=2.54;
                            double cm=value*1000*100;
                            cm=cm/inch;
                            result.setText(String.valueOf(cm));
                        }
                        else if(output.equals("Foot")){
                            double foot=12*2.54;
                            double cm=value*1000*100;
                            cm=cm/foot;
                            result.setText(String.valueOf(cm));
                        }
                        else if(output.equals("Yard")){
                            double yard=36*2.54;
                            double cm=value*1000*100;
                            cm=cm/yard;
                            result.setText(String.valueOf(cm));
                        }
                        else{
                            result.setText(String.valueOf(value));
                        }

                        break;

                    case "Inch":

                        if(output.equals("Kilometer")){
                            double km=value*2.54/100000;
                            result.setText(String.valueOf(km));
                        }
                        else if(output.equals("Meter")){
                            double m=value*2.54/100;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Centimeter")){
                            double cm=value*2.54;
                            result.setText(String.valueOf(cm));
                        }
                        else if (output.equals("Millimeter")) {
                            double mm=value*2.54*10;
                            result.setText(String.valueOf(mm));
                        }
                        else if(output.equals("Mile")){
                            value=value*2.54;
                            double mile=value/100000;
                            result.setText(String.valueOf(mile));
                        }
                        else if(output.equals("Foot")){
                            double cm=12*2.54;
                            value=value*2.54;
                            double f=value/cm;
                            result.setText(String.valueOf(f));
                        }
                        else if(output.equals("Yard")){
                            double yard=36*2.54;
                            double cm=(value*2.54)/yard;
                            result.setText(String.valueOf(cm));
                        }
                        else{
                            result.setText(String.valueOf(value));
                        }
                        break;

                    case "Foot":

                        if(output.equals("Kilometer")){
                            value=value*12*2.54;
                            double km=value/100000;
                            result.setText(String.valueOf(km));
                        }
                        else if(output.equals("Meter")){
                            value=value*12*2.54;
                            double m=value/100;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Centimeter")){
                            double cm=value*12*2.54;
                            result.setText(String.valueOf(cm));
                        }
                        else if (output.equals("Millimeter")) {
                            double mm=value*12*2.54*10;
                            result.setText(String.valueOf(mm));
                        }
                        else if(output.equals("Mile")){
                            value=value*12*2.54;
                            double cm=1.61*1000*100;
                            double mile=value/cm;
                            result.setText(String.valueOf(mile));
                        }
                        else if(output.equals("Inch")){
                            value=value*12;
                            result.setText(String.valueOf(value));
                        }
                        else if(output.equals("Yard")){
                            value=value/36;
                            result.setText(String.valueOf(value));
                        }
                        else{
                            result.setText(String.valueOf(value));
                        }
                        break;

                    case "Yard":

                        if(output.equals("Kilometer")){
                            double yard=value*36*2.54;
                            value=yard/100000;
                            result.setText(String.valueOf(value));
                        }
                        else if(output.equals("Meter")){
                            double yard=value*36*2.54;
                            double m=yard/100;
                            result.setText(String.valueOf(m));
                        }
                        else if(output.equals("Centimeter")){
                            double yard=value*36*2.54;
                            result.setText(String.valueOf(yard));
                        }
                        else if (output.equals("Millimeter")) {
                            double mm=value*36*2.54*10;
                            result.setText(String.valueOf(mm));
                        }
                        else if(output.equals("Mile")){
                            value=value*36*2.54/1000;
                            double mile=value/1.61*1000;
                            result.setText(String.valueOf(mile));
                        }
                        else if(output.equals("Inch")){
                            value=value*36;
                            result.setText(String.valueOf(value));
                        }
                        else if(output.equals("Foot")){
                            value=value*12;
                            result.setText(String.valueOf(value));
                        }
                        else{
                            result.setText(String.valueOf(value));
                        }
                        break;

                    default:
                        break;
                }
                InputMethodManager ip=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if(ip!=null){
                    ip.hideSoftInputFromWindow(view.getWindowToken(),0);
                }
            }
        });

    }
}