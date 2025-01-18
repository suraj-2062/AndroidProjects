package com.example.calculatorconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Spannable;
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

public class Currancy extends AppCompatActivity {
    Spinner spinner1,spinner2;
    EditText input_value;
    TextView result;
    String input_curr,output_curr;
    Button calculate,reset;
    List<String>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currancy);

        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        input_value=findViewById(R.id.input_currency);
        result=findViewById(R.id.result);
        calculate=findViewById(R.id.button);
        reset=findViewById(R.id.reset);

        list= Arrays.asList("Kuwaiti Dinar","Bahraini Dinar","Omani Rial","Jordanian Dinar","Gibraltar Pound","British Pound","Swiss Franc","Euro","United State Dollar","Indian Rupee","Pakistani Rupee","Chinese Yuan");

        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                input_curr=spinner1.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                output_curr=spinner2.getItemAtPosition(i).toString();
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
                input_value.setText("");
                result.setText("");

            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(input_value.getText().toString().isEmpty()){
                    result.setText("Invalid");
                    return;
                }
                double value=Double.parseDouble(input_value.getText().toString());
                switch (input_curr){
                    case "Kuwaiti Dinar":
                        if(output_curr.equals("Brahraini Dinar")){
                            result.setText(getString(R.string.kwd)+String.valueOf(value*1.23));
                        } else if (output_curr.equals("Omani Rial")) {
                            result.setText(getString(R.string.omr)+String.valueOf(value*1.26));
                        } else if (output_curr.equals("Jordanian Dinar")) {
                            result.setText(getString(R.string.jod)+String.valueOf(value*2.34));
                        } else if (output_curr.equals("Gibraltar Pound")) {
                            result.setText(getString(R.string.gip)+String.valueOf(value*2.53));
                        } else if (output_curr.equals("British Pound")) {
                            result.setText(getString(R.string.gbp)+String.valueOf(value*2.56));
                        } else if (output_curr.equals("Swiss Franc")) {
                            result.setText(getString(R.string.chf)+String.valueOf(value*3.02));
                        } else if (output_curr.equals("Euro")) {
                            result.setText(getString(R.string.eur)+String.valueOf(value*3.30));
                        } else if (output_curr.equals("United State Dollar")) {
                            result.setText(getString(R.string.usd)+String.valueOf(value*3.25));
                        } else if (output_curr.equals("Indian Rupee")) {
                            result.setText(getString(R.string.inr)+String.valueOf(value*270.5));
                        } else if (output_curr.equals("Pakistani Rupee")) {
                            result.setText(getString(R.string.pkr)+String.valueOf(value*997.5));
                        } else if (output_curr.equals("Chinese Yuan")) {
                            result.setText(getString(R.string.cny)+String.valueOf(value*23.2));
                        }
                        else {
                            result.setText(getString(R.string.kwd)+String.valueOf(value));
                        }
                        break;

                    case "Bahraini Dinar":
                        if(output_curr.equals("Kuwaiti Dinar")){
                            result.setText(getString(R.string.kwd)+String.valueOf(value*0.81));
                        } else if (output_curr.equals("Omani Rial")) {
                            result.setText(getString(R.string.omr)+String.valueOf(value*1.02));
                        } else if (output_curr.equals("Jordanian Dinar")) {
                            result.setText(getString(R.string.jod)+String.valueOf(value*1.9));
                        } else if (output_curr.equals("Gibraltar Pound")) {
                            result.setText(getString(R.string.gip)+String.valueOf(value*2.06));
                        } else if (output_curr.equals("British Pound")) {
                            result.setText(getString(R.string.gbp)+String.valueOf(value*2.08));
                        } else if (output_curr.equals("Swiss Franc")) {
                            result.setText(getString(R.string.chf)+String.valueOf(value*2.46));
                        } else if (output_curr.equals("Euro")) {
                            result.setText(getString(R.string.eur)+String.valueOf(value*2.7));
                        } else if (output_curr.equals("United State Dollar")) {
                            result.setText(getString(R.string.usd)+String.valueOf(value*2.65));
                        } else if (output_curr.equals("Indian Rupee")) {
                            result.setText(getString(R.string.inr)+String.valueOf(value*219.8));
                        } else if (output_curr.equals("Pakistani Rupee")) {
                            result.setText(getString(R.string.pkr)+String.valueOf(value*810));
                        } else if (output_curr.equals("Chinese Yuan")) {
                            result.setText(getString(R.string.cny)+String.valueOf(value*18.8));
                        }
                        else {
                            result.setText(getString(R.string.bhd)+String.valueOf(value));
                        }
                        break;

                    case "Omani Rial":
                        if(output_curr.equals("Kuwaiti Dinar")){
                            result.setText("KWD : "+String.valueOf(value*0.79));
                        } else if (output_curr.equals("Bahraini Dinar")) {
                            result.setText("BHD : "+String.valueOf(value*0.98));
                        } else if (output_curr.equals("Jordanian Dinar")) {
                            result.setText("JOD : "+String.valueOf(value*1.86));
                        } else if (output_curr.equals("Gibraltar Pound")) {
                            result.setText("GIP : "+String.valueOf(value*2.02));
                        } else if (output_curr.equals("British Pound")) {
                            result.setText("GBP : "+String.valueOf(value*2.05));
                        } else if (output_curr.equals("Swiss Franc")) {
                            result.setText("CHF : "+String.valueOf(value*2.42));
                        } else if (output_curr.equals("Euro")) {
                            result.setText("CHF : "+String.valueOf(value*2.66));
                        } else if (output_curr.equals("United State Dollar")) {
                            result.setText("USD : "+String.valueOf(value*2.6));
                        } else if (output_curr.equals("Indian Rupee")) {
                            result.setText("INR : "+String.valueOf(value*215.7));
                        } else if (output_curr.equals("Pakistani Rupee")) {
                            result.setText("PKR : "+String.valueOf(value*795));
                        } else if (output_curr.equals("Chinese Yuan")) {
                            result.setText("CNY : "+String.valueOf(value*18.4));
                        }
                        else {
                            result.setText("OMR : "+String.valueOf(value));
                        }
                        break;

                    case "Jordanian Dinar":
                        if(output_curr.equals("Kuwaiti Dinar")){
                            result.setText(getString(R.string.kwd)+String.valueOf(value*0.43));
                        } else if (output_curr.equals("Bahraini Dinar")) {
                            result.setText(getString(R.string.bhd)+String.valueOf(value*0.53));
                        } else if (output_curr.equals("Omani Rial")) {
                            result.setText(getString(R.string.omr)+String.valueOf(value*0.54));
                        } else if (output_curr.equals("Gibraltar Pound")) {
                            result.setText(getString(R.string.gip)+String.valueOf(value*1.09));
                        } else if (output_curr.equals("British Pound")) {
                            result.setText(getString(R.string.gbp)+String.valueOf(value*1.11));
                        } else if (output_curr.equals("Swiss Franc")) {
                            result.setText(getString(R.string.chf)+String.valueOf(value*1.31));
                        } else if (output_curr.equals("Euro")) {
                            result.setText(getString(R.string.eur)+String.valueOf(value*1.44));
                        } else if (output_curr.equals("United State Dollar")) {
                            result.setText(getString(R.string.usd)+String.valueOf(value*1.42));
                        } else if (output_curr.equals("Indian Rupee")) {
                            result.setText(getString(R.string.inr)+String.valueOf(value*118.9));
                        } else if (output_curr.equals("Pakistani Rupee")) {
                            result.setText(getString(R.string.pkr)+String.valueOf(value*435));
                        } else if (output_curr.equals("Chinese Yuan")) {
                            result.setText(getString(R.string.cny)+String.valueOf(value*10.1));
                        }
                        else {
                            result.setText(getString(R.string.jod)+String.valueOf(value));
                        }
                        break;

                    case "Gibraltar Pound":
                        if(output_curr.equals("Kuwaiti Dinar")){
                            result.setText(getString(R.string.kwd)+String.valueOf(value*0.4));
                        } else if (output_curr.equals("Bahraini Dinar")) {
                            result.setText(getString(R.string.bhd)+String.valueOf(value*0.49));
                        } else if (output_curr.equals("Omani Rial")) {
                            result.setText(getString(R.string.omr)+String.valueOf(value*0.5));
                        } else if (output_curr.equals("Jordanian Dinar")) {
                            result.setText(getString(R.string.jod)+String.valueOf(value*0.91));
                        } else if (output_curr.equals("British Pound")) {
                            result.setText(getString(R.string.gbp)+String.valueOf(value*1.01));
                        } else if (output_curr.equals("Swiss Franc")) {
                            result.setText(getString(R.string.chf)+String.valueOf(value*1.21));
                        } else if (output_curr.equals("Euro")) {
                            result.setText(getString(R.string.eur)+String.valueOf(value*1.33));
                        } else if (output_curr.equals("United State Dollar")) {
                            result.setText(getString(R.string.usd)+String.valueOf(value*1.3));
                        } else if (output_curr.equals("Indian Rupee")) {
                            result.setText(getString(R.string.inr)+String.valueOf(value*108.6));
                        } else if (output_curr.equals("Pakistani Rupee")) {
                            result.setText(getString(R.string.pkr)+String.valueOf(value*397));
                        } else if (output_curr.equals("Chinese Yuan")) {
                            result.setText(getString(R.string.cny)+String.valueOf(value*9.2));
                        }
                        else {
                            result.setText(getString(R.string.gbp)+String.valueOf(value));
                        }
                        break;

                    case "British Pound":
                        if(output_curr.equals("Kuwaiti Dinar")){
                            result.setText(getString(R.string.kwd)+String.valueOf(value*0.39));
                        } else if (output_curr.equals("Bahraini Dinar")) {
                            result.setText(getString(R.string.bhd)+String.valueOf(value*0.48));
                        } else if (output_curr.equals("Omani Rial")) {
                            result.setText(getString(R.string.omr)+String.valueOf(value*0.49));
                        } else if (output_curr.equals("Jordanian Dinar")) {
                            result.setText(getString(R.string.jod)+String.valueOf(value*0.9));
                        } else if (output_curr.equals("Gibraltar Pound")) {
                            result.setText(getString(R.string.gip)+String.valueOf(value*0.99));
                        } else if (output_curr.equals("Swiss Franc")) {
                            result.setText(getString(R.string.chf)+String.valueOf(value*1.19));
                        } else if (output_curr.equals("Euro")) {
                            result.setText(getString(R.string.eur)+String.valueOf(value*1.31));
                        } else if (output_curr.equals("United State Dollar")) {
                            result.setText(getString(R.string.usd)+String.valueOf(value*1.28));
                        } else if (output_curr.equals("Indian Rupee")) {
                            result.setText(getString(R.string.inr)+String.valueOf(value*107.2));
                        } else if (output_curr.equals("Pakistani Rupee")) {
                            result.setText(getString(R.string.pkr)+String.valueOf(value*392));
                        } else if (output_curr.equals("Chinese Yuan")) {
                            result.setText(getString(R.string.cny)+String.valueOf(value*9.1));
                        }
                        else {
                            result.setText(getString(R.string.gbp)+String.valueOf(value));
                        }
                        break;

                    case "Swiss Franc":
                        if(output_curr.equals("Kuwaiti Dinar")){
                            result.setText(getString(R.string.kwd)+String.valueOf(value*0.33));
                        } else if (output_curr.equals("Bahraini Dinar")) {
                            result.setText(getString(R.string.bhd)+String.valueOf(value*0.41));
                        } else if (output_curr.equals("Omani Rial")) {
                            result.setText(getString(R.string.omr)+String.valueOf(value*0.41));
                        } else if (output_curr.equals("Jordanian Dinar")) {
                            result.setText(getString(R.string.jod)+String.valueOf(value*0.76));
                        } else if (output_curr.equals("Gibraltar Pound")) {
                            result.setText(getString(R.string.gip)+String.valueOf(value*0.83));
                        } else if (output_curr.equals("British Pound")) {
                            result.setText(getString(R.string.gbp)+String.valueOf(value*0.84));
                        } else if (output_curr.equals("Euro")) {
                            result.setText(getString(R.string.eur)+String.valueOf(value*1.1));
                        } else if (output_curr.equals("United State Dollar")) {
                            result.setText(getString(R.string.usd)+String.valueOf(value*1.08));
                        } else if (output_curr.equals("Indian Rupee")) {
                            result.setText(getString(R.string.inr)+String.valueOf(value*91.3));
                        } else if (output_curr.equals("Pakistani Rupee")) {
                            result.setText(getString(R.string.pkr)+String.valueOf(value*329));
                        } else if (output_curr.equals("Chinese Yuan")) {
                            result.setText(getString(R.string.cny)+String.valueOf(value*7.7));
                        }
                        else {
                            result.setText(getString(R.string.chf)+String.valueOf(value));
                        }
                        break;

                    case "Euro":
                        if(output_curr.equals("Kuwaiti Dinar")){
                            result.setText(getString(R.string.kwd)+String.valueOf(value*0.3));
                        } else if (output_curr.equals("Bahraini Dinar")) {
                            result.setText(getString(R.string.bhd)+String.valueOf(value*0.37));
                        } else if (output_curr.equals("Omani Rial")) {
                            result.setText(getString(R.string.omr)+String.valueOf(value*0.38));
                        } else if (output_curr.equals("Jordanian Dinar")) {
                            result.setText(getString(R.string.jod)+String.valueOf(value*0.69));
                        } else if (output_curr.equals("Gibraltar Pound")) {
                            result.setText(getString(R.string.gip)+String.valueOf(value*0.75));
                        } else if (output_curr.equals("British Pound")) {
                            result.setText(getString(R.string.gbp)+String.valueOf(value*0.76));
                        } else if (output_curr.equals("Swiss Franc")) {
                            result.setText(getString(R.string.chf)+String.valueOf(value*0.91));
                        } else if (output_curr.equals("United State Dollar")) {
                            result.setText(getString(R.string.usd)+String.valueOf(value*0.98));
                        } else if (output_curr.equals("Indian Rupee")) {
                            result.setText(getString(R.string.inr)+String.valueOf(value*83));
                        } else if (output_curr.equals("Pakistani Rupee")) {
                            result.setText(getString(R.string.pkr)+String.valueOf(value*298));
                        } else if (output_curr.equals("Chinese Yuan")) {
                            result.setText(getString(R.string.cny)+String.valueOf(value*7));
                        }
                        else {
                            result.setText(getString(R.string.eur)+String.valueOf(value));
                        }
                        break;

                    case "United State Dollar":
                        if(output_curr.equals("Kuwaiti Dinar")){
                            result.setText(getString(R.string.kwd)+String.valueOf(value*0.31));
                        } else if (output_curr.equals("Bahraini Dinar")) {
                            result.setText(getString(R.string.bhd)+String.valueOf(value*0.38));
                        } else if (output_curr.equals("Omani Rial")) {
                            result.setText(getString(R.string.omr)+String.valueOf(value*0.38));
                        } else if (output_curr.equals("Jordanian Dinar")) {
                            result.setText(getString(R.string.jod)+String.valueOf(value*0.7));
                        } else if (output_curr.equals("Gibraltar Pound")) {
                            result.setText(getString(R.string.gip)+String.valueOf(value*0.77));
                        } else if (output_curr.equals("British Pound")) {
                            result.setText(getString(R.string.gbp)+String.valueOf(value*0.78));
                        } else if (output_curr.equals("Swiss Franc")) {
                            result.setText(getString(R.string.chf)+String.valueOf(value*0.93));
                        } else if (output_curr.equals("Euro")) {
                            result.setText(getString(R.string.eur)+String.valueOf(value*1.02));
                        } else if (output_curr.equals("Indian Rupee")) {
                            result.setText(getString(R.string.inr)+String.valueOf(value*85));
                        } else if (output_curr.equals("Pakistani Rupee")) {
                            result.setText(getString(R.string.pkr)+String.valueOf(value*304));
                        } else if (output_curr.equals("Chinese Yuan")) {
                            result.setText(getString(R.string.cny)+String.valueOf(value*7.2));
                        }
                        else {
                            result.setText(getString(R.string.usd)+String.valueOf(value));
                        }
                        break;
                    case "Pakistani Rupee":
                        if(output_curr.equals("Kuwaiti Dinar")){
                            result.setText(getString(R.string.kwd)+String.valueOf(value*0.001));
                        } else if (output_curr.equals("Bahraini Dinar")) {
                            result.setText(getString(R.string.bhd)+String.valueOf(value*0.001));
                        } else if (output_curr.equals("Omani Rial")) {
                            result.setText(getString(R.string.omr)+String.valueOf(value*0.001));
                        } else if (output_curr.equals("Jordanian Dinar")) {
                            result.setText(getString(R.string.jod)+String.valueOf(value*0.002));
                        } else if (output_curr.equals("Gibraltar Pound")) {
                            result.setText(getString(R.string.gip)+String.valueOf(value*0.002));
                        } else if (output_curr.equals("British Pound")) {
                            result.setText(getString(R.string.gbp)+String.valueOf(value*0.002));
                        } else if (output_curr.equals("Swiss Franc")) {
                            result.setText(getString(R.string.chf)+String.valueOf(value*0.003));
                        } else if (output_curr.equals("Euro")) {
                            result.setText(getString(R.string.eur)+String.valueOf(value*0.003));
                        } else if (output_curr.equals("Indian Rupee")) {
                            result.setText(getString(R.string.inr)+String.valueOf(value*0.28));
                        } else if (output_curr.equals("United State Dollar")) {
                            result.setText(getString(R.string.usd)+String.valueOf(value*0.003));
                        } else if (output_curr.equals("Chinese Yuan")) {
                            result.setText(getString(R.string.cny)+String.valueOf(value*0.023));
                        }
                        else {
                            result.setText(getString(R.string.pkr)+String.valueOf(value));
                        }
                        break;

                    case "Chinese Yuan":
                        if(output_curr.equals("Kuwaiti Dinar")){
                            result.setText(getString(R.string.kwd)+String.valueOf(value*0.04));
                        } else if (output_curr.equals("Bahraini Dinar")) {
                            result.setText(getString(R.string.bhd)+String.valueOf(value*0.05));
                        } else if (output_curr.equals("Omani Rial")) {
                            result.setText(getString(R.string.omr)+String.valueOf(value*0.05));
                        } else if (output_curr.equals("Jordanian Dinar")) {
                            result.setText(getString(R.string.jod)+String.valueOf(value*0.09));
                        } else if (output_curr.equals("Gibraltar Pound")) {
                            result.setText(getString(R.string.gip)+String.valueOf(value*0.1));
                        } else if (output_curr.equals("British Pound")) {
                            result.setText(getString(R.string.gbp)+String.valueOf(value*0.1));
                        } else if (output_curr.equals("Swiss Franc")) {
                            result.setText(getString(R.string.chf)+String.valueOf(value*0.13));
                        } else if (output_curr.equals("Euro")) {
                            result.setText(getString(R.string.eur)+String.valueOf(value*0.14));
                        } else if (output_curr.equals("Indian Rupee")) {
                            result.setText(getString(R.string.inr)+String.valueOf(value*12.3));
                        } else if (output_curr.equals("United State Dollar")) {
                            result.setText(getString(R.string.usd)+String.valueOf(value*0.14));
                        } else if (output_curr.equals("Pakistani Rupee")) {
                            result.setText(getString(R.string.pkr)+String.valueOf(value*43.5));
                        }
                        else {
                            result.setText(getString(R.string.cny)+String.valueOf(value));
                        }
                        break;

                    case "Indian Rupee":
                        if(output_curr.equals("Kuwaiti Dinar")){
                            result.setText(getString(R.string.kwd)+String.valueOf(value*0.004));
                        } else if (output_curr.equals("Bahraini Dinar")) {
                            result.setText(getString(R.string.bhd)+String.valueOf(value*0.005));
                        } else if (output_curr.equals("Omani Rial")) {
                            result.setText(getString(R.string.omr)+String.valueOf(value*0.005));
                        } else if (output_curr.equals("Jordanian Dinar")) {
                            result.setText(getString(R.string.jod)+String.valueOf(value*0.008));
                        } else if (output_curr.equals("Gibraltar Pound")) {
                            result.setText(getString(R.string.gip)+String.valueOf(value*0.009));
                        } else if (output_curr.equals("British Pound")) {
                            result.setText(getString(R.string.gbp)+String.valueOf(value*0.009));
                        } else if (output_curr.equals("Swiss Franc")) {
                            result.setText(getString(R.string.chf)+String.valueOf(value*0.011));
                        } else if (output_curr.equals("Euro")) {
                            result.setText(getString(R.string.eur)+String.valueOf(value*0.012));
                        } else if (output_curr.equals("Chinese Yuan")) {
                            result.setText(getString(R.string.cny)+String.valueOf(value*0.082));
                        } else if (output_curr.equals("United State Dollar")) {
                            result.setText(getString(R.string.usd)+String.valueOf(value*0.012));
                        } else if (output_curr.equals("Pakistani Rupee")) {
                            result.setText(getString(R.string.pkr)+String.valueOf(value*3.57));
                        }
                        else {
                            result.setText(getString(R.string.inr)+String.valueOf(value));
                        }
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
}