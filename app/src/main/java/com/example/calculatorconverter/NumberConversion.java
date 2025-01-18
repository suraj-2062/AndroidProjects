package com.example.calculatorconverter;

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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class NumberConversion extends AppCompatActivity {
    Spinner spinner1, spinner2;
    List<String> numbers;
    EditText edittext1, edittext2;
//    TextView;
    String input_num, output_num, num1;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numeric_conversion);

        button = findViewById(R.id.button);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        edittext1 = findViewById(R.id.input1);
        edittext2 = findViewById(R.id.input2);

        numbers = Arrays.asList("Binary", "Octal", "Decimal", "Hexadecimal");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, numbers);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, numbers);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                input_num = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                output_num = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edittext1.getText().toString().isEmpty()){
                    edittext2.setText("Please enter number");
                    return;
                }
                switch (input_num) {

                    case "Binary":
                        if(output_num.equals("Octal")){
                            num1 = edittext1.getText().toString();
                            int bin_to_dec=Integer.parseInt(num1,2);
                            String dec_to_oct=Integer.toOctalString(bin_to_dec);
                            edittext2.setText(dec_to_oct);
                        }
                        else if(output_num.equals("Decimal")){
                            num1 = edittext1.getText().toString();
                            int bin_to_dec=Integer.parseInt(num1,2);
                            edittext2.setText(String.valueOf(bin_to_dec));
                        }
                        else if(output_num.equals("Hexadecimal")){
                            num1 = edittext1.getText().toString();
                            int bin_to_dec=Integer.parseInt(num1,2);
                            String dec_to_hex=Integer.toHexString(bin_to_dec);
                            edittext2.setText(dec_to_hex.toUpperCase());
                        }
                        else{
                            num1 = edittext1.getText().toString();
                            edittext2.setText(num1);
                        }
                        break;

                    case "Octal":

                        if(output_num.equals("Binary")){
                            num1 = edittext1.getText().toString();
                            int oct_to_dec=Integer.parseInt(num1,8);
                            String dec_to_bin=Integer.toBinaryString(oct_to_dec);
                            edittext2.setText(dec_to_bin);
                        }
                        else if(output_num.equals("Decimal")){
                            num1 = edittext1.getText().toString();
                            int oct_to_dec=Integer.parseInt(num1,8);
                            edittext2.setText(String.valueOf(oct_to_dec));
                        }
                        else if(output_num.equals("Hexadecimal")){
                            num1 = edittext1.getText().toString();
                            int oct_to_dec=Integer.parseInt(num1,8);
                            String dec_to_hex=Integer.toHexString(oct_to_dec);
                            edittext2.setText(dec_to_hex.toUpperCase());
                        }
                        else{
                            num1 = edittext1.getText().toString();
                            edittext2.setText(num1);
                        }
                        break;

                    case "Decimal":

                        if(output_num.equals("Binary")){
                            num1 = edittext1.getText().toString();
                            String dec_to_bin=Integer.toBinaryString(Integer.parseInt(num1));
                            edittext2.setText(dec_to_bin);
                        }
                        else if(output_num.equals("Octal")){
                            num1 = edittext1.getText().toString();
                            String dec_to_oct=Integer.toOctalString(Integer.parseInt(num1));
                            edittext2.setText(dec_to_oct);
                        }
                        else if(output_num.equals("Hexadecimal")){
                            num1 = edittext1.getText().toString();
                            String dec_to_hex=Integer.toHexString(Integer.parseInt(num1));
                            edittext2.setText(dec_to_hex.toUpperCase());
                        }
                        else{
                            num1 = edittext1.getText().toString();
                            edittext2.setText(num1);
                        }
                        break;

                    case "Hexadecimal":

                        if(output_num.equals("Binary")){
                            num1 = edittext1.getText().toString();
                            int hex_to_dec=Integer.parseInt(num1,16);
                            String hex_to_bin=Integer.toBinaryString(hex_to_dec);
                            edittext2.setText(hex_to_bin);
                        }
                        else if(output_num.equals("Octal")){
                            num1 = edittext1.getText().toString();
                            int hex_to_dec=Integer.parseInt(num1,16);
                            String hex_to_oct=Integer.toOctalString(hex_to_dec);
                            edittext2.setText(hex_to_oct);
                        }
                        else if(output_num.equals("Decimal")){
                            num1 = edittext1.getText().toString();
                            int hex_to_dec=Integer.parseInt(num1,16);
                            edittext2.setText(String.valueOf(hex_to_dec));
                        }
                        else{
                            num1 = edittext1.getText().toString();
                            edittext2.setText(num1);
                        }
                        break;

                    default:
                        break;
                }
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
            }
        });
    }
    public void resetContain(View view){
        spinner1.setSelection(0);
        spinner2.setSelection(0);
        edittext1.setText("");
        edittext2.setText("");
    }
}
