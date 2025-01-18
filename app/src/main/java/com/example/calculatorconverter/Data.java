package com.example.calculatorconverter;

import android.annotation.SuppressLint;
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

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import kotlin.random.Random;

public class Data extends AppCompatActivity {
    Spinner spinner1,spinner2;
    EditText input_data;
    TextView result;
    String input,output;
    Button calculate,reset;
    List<String>list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);

        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        input_data=findViewById(R.id.input_data);
        result=findViewById(R.id.result);
        calculate=findViewById(R.id.button);
        reset=findViewById(R.id.reset);

        list= Arrays.asList("Byte","KiloByte","MegaByte","GigaByte","TeraByte","PetaByte");

        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

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
                input_data.setText("");
                result.setText("");
            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input_data.getText().toString().isEmpty()){
                    result.setText("Invalid");
                    return;
                }
                BigDecimal value= new BigDecimal(input_data.getText().toString());
                switch (input){
                    case "Byte":
                        result.setText(ByteToOther(value,output));
                        break;
                    case "KiloByte":
                        result.setText(KiloByteToOther(value,output));
                        break;
                    case "MegaByte":
                        result.setText(MegaByteToOther(value,output));
                        break;
                    case "GigaByte":
                        result.setText(GigaByteToOther(value,output));
                        break;
                    case "TeraByte":
                        result.setText(TeraByteToOther(value,output));
                        break;
                    case "PetaByte":
                        result.setText(PetaByteToOther(value,output));
                        break;
                    default:
                        break;
                }
                InputMethodManager ip=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if(ip!=null){
                    ip.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
                }
            }
        });
    }
    public String ByteToOther(BigDecimal value,String str){
        switch (str){
            case "KiloByte":
                BigDecimal k=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.00097625))));
                return k.toString()+" "+getString(R.string.kb);
            case "MegaByte":
                BigDecimal m=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.00000095367432))));
                return m.toString()+" "+getString(R.string.mb);
            case "GigaByte":
                BigDecimal g=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.0000000009313226))));
                return g.toString()+" "+getString(R.string.gb);
            case "TeraByte":
                BigDecimal t=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.0000000000009095))));
                return t.toString()+" "+getString(R.string.tb);
            case "PetaByte":
                BigDecimal p=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.0000000000000009))));
                return p.toString()+" "+getString(R.string.pb);
            default:
                return String.valueOf(value)+" "+getString(R.string.b);
        }
    }
    public String KiloByteToOther(BigDecimal value,String str){
        switch (str){
            case "Byte":
                BigDecimal b=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1024))));
                return b.toString()+" "+getString(R.string.b);
            case "MegaByte":
                BigDecimal m=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.0009765625))));
                return m.toString()+" "+getString(R.string.mb);
            case "GigaByte":
                BigDecimal g=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.00000095367432))));
                return g.toString()+" "+getString(R.string.gb);
            case "TeraByte":
                BigDecimal t=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.0000000009313226))));
                return t.toString()+" "+getString(R.string.tb);
            case "PetaByte":
                BigDecimal p=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.0000000000009095))));
                return p.toString()+" "+getString(R.string.pb);
            default:
                return String.valueOf(value)+" "+getString(R.string.kb);
        }
    }
    public String MegaByteToOther(BigDecimal value,String str){
        switch (str){
            case "Byte":
                BigDecimal b=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1048576))));
                return b.toString()+" "+getString(R.string.b);
            case "KiloByte":
                BigDecimal k=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1024))));
                return k.toString()+" "+getString(R.string.kb);
            case "GigaByte":
                BigDecimal g=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.0009765625))));
                return g.toString()+" "+getString(R.string.gb);
            case "TeraByte":
                BigDecimal t=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.00000095367432))));
                return t.toString()+" "+getString(R.string.tb);
            case "PetaByte":
                BigDecimal p=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.0000000009313226))));
                return p.toString()+" "+getString(R.string.pb);
            default:
                return String.valueOf(value)+" "+getString(R.string.mb);
        }
    }
    public String GigaByteToOther(BigDecimal value,String str){
        switch (str){
            case "Byte":
                BigDecimal b=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1073741824))));
                return b.toString()+" "+getString(R.string.b);
            case "KiloByte":
                BigDecimal k=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1048576))));
                return k.toString()+" "+getString(R.string.kb);
            case "MegaByte":
                BigDecimal m=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1024))));
                return m.toString()+" "+getString(R.string.mb);
            case "TeraByte":
                BigDecimal t=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.0009765625))));
                return t.toString()+" "+getString(R.string.tb);
            case "PetaByte":
                BigDecimal p=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.00000095367432))));
                return p.toString()+" "+getString(R.string.pb);
            default:
                return String.valueOf(value)+" "+getString(R.string.gb);
        }
    }
    public String TeraByteToOther(BigDecimal value,String str){
        switch (str){
            case "Byte":
                BigDecimal b=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1099511627776L))));
                return b.toString()+" "+getString(R.string.b);
            case "KiloByte":
                BigDecimal k=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1073741824))));
                return k.toString()+" "+getString(R.string.kb);
            case "MegaByte":
                BigDecimal m=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1048576))));
                return m.toString()+" "+getString(R.string.mb);
            case "GigaByte":
                BigDecimal g=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1024))));
                return g.toString()+" "+getString(R.string.gb);
            case "PetaByte":
                BigDecimal p=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(0.0009765625))));
                return p.toString()+" "+getString(R.string.pb);
            default:
                return String.valueOf(value)+" "+getString(R.string.tb);
        }
    }
    public String PetaByteToOther(BigDecimal value,String str){
        switch (str){
            case "Byte":
                BigDecimal b=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1125899906842624L))));
                return b.toString()+" "+getString(R.string.b);
            case "KiloByte":
                BigDecimal k=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1099511627776L))));
                return k.toString()+" "+getString(R.string.kb);
            case "MegaByte":
                BigDecimal m=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1073741824))));
                return m.toString()+" "+getString(R.string.mb);
            case "GigaByte":
                BigDecimal g=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1048576))));
                return g.toString()+" "+getString(R.string.gb);
            case "TeraByte":
                BigDecimal t=new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(1024))));
                return t.toString()+" "+getString(R.string.tb);
            default:
                return String.valueOf(value)+" "+getString(R.string.pb);
        }
    }
}