package com.example.calculatorconverter;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dicount extends AppCompatActivity {
    EditText input_price,dis_per;
    TextView final_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discount);

        input_price=findViewById(R.id.input_price);
        dis_per=findViewById(R.id.dis_per);
        final_price=findViewById(R.id.org_price);

        input_price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!input_price.getText().toString().isEmpty() && !dis_per.getText().toString().isEmpty()){
                    double original=Double.parseDouble(input_price.getText().toString());
                    double discount=Double.parseDouble(dis_per.getText().toString());
                    double result=original-(original*(discount/100));
                    final_price.setText(String.format("%.2f",result));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        dis_per.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!input_price.getText().toString().isEmpty() && !dis_per.getText().toString().isEmpty()){
                    double original=Double.parseDouble(input_price.getText().toString());
                    double discount=Double.parseDouble(dis_per.getText().toString());
                    double result=original*discount/100;
                    final_price.setText(String.format("%.2f",result));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}