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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class Temperature extends AppCompatActivity {

    Spinner spinner1, spinner2;
    EditText input_degree;
    TextView result;
    Button calculate, reset;
    String input, output;
    List<String> degree_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature);

        result=findViewById(R.id.result);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        input_degree = findViewById(R.id.unit_degree);
        calculate = findViewById(R.id.button);
        reset = findViewById(R.id.reset);

        degree_list = Arrays.asList("Celsius", "Fahrenheit", "Kelvin", "Rankine", "Reaumar");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, degree_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, degree_list);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                input = spinner1.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                output = spinner2.getItemAtPosition(i).toString();
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
                input_degree.setText("");
                result.setText("");
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input_degree.getText().toString().isEmpty()) {
                    result.setText("invalid");
                    return;
                }
                double value = Double.parseDouble(input_degree.getText().toString());
                switch (input) {
                    case "Celsius":
                        if (output.equals("Fahrenheit")) {
                            result.setText(String.valueOf((value * 9 / 5) + 32));
                        } else if (output.equals("Reaumar")) {
                            result.setText(String.valueOf(value * 4 / 5));
                        } else if (output.equals("Rankine")) {
                            result.setText(String.valueOf((value + 273.15) * 9 / 5));
                        } else if (output.equals("Kelvin")) {
                            result.setText(String.valueOf(value + 273.15));
                        } else {
                            result.setText(String.valueOf(value));
                        }
                        break;

                    case "Fahrenheit":
                        if (output.equals("Celsius")) {
                            result.setText(String.valueOf((value - 32) * 5 / 9));
                        } else if (output.equals("Reaumar")) {
                            result.setText(String.valueOf((value - 32) * 4 / 9));
                        } else if (output.equals("Rankine")) {
                            result.setText(String.valueOf(value + 459.67));
                        } else if (output.equals("Kelvin")) {
                            result.setText(String.valueOf(((value - 32) * 5 / 9) + 273.15));
                        } else {
                            result.setText(String.valueOf(value));
                        }
                        break;

                    case "Kelvin":
                        if (output.equals("Celsius")) {
                            result.setText(String.valueOf(value - 273.15));
                        } else if (output.equals("Reaumar")) {
                            result.setText(String.valueOf((value - 273.15) * 4 / 5));
                        } else if (output.equals("Rankine")) {
                            result.setText(String.valueOf(value * 4 / 5));
                        } else if (output.equals("Fahrenheit")) {
                            result.setText(String.valueOf(((value - 273.15) * 9 / 5) + 32));
                        } else {
                            result.setText(String.valueOf(value));
                        }
                        break;

                    case "Rankine":
                        if (output.equals("Celsius")) {
                            result.setText(String.valueOf((value - 491.67) * 5 / 9));
                        } else if (output.equals("Reaumar")) {
                            result.setText(String.valueOf((value - 491.67) * 4 / 9));
                        } else if (output.equals("Kelvin")) {
                            result.setText(String.valueOf(value * 5 / 9));
                        } else if (output.equals("Fahrenheit")) {
                            result.setText(String.valueOf(value - 459.67));
                        } else {
                            result.setText(String.valueOf(value));
                        }
                        break;

                    case "Reaumar":
                        if (output.equals("Celsius")) {
                            result.setText(String.valueOf(value * 5 / 9));
                        } else if (output.equals("Rankine")) {
                            result.setText(String.valueOf((value * 9 / 4) + 491.67));
                        } else if (output.equals("Kelvin")) {
                            result.setText(String.valueOf((value * 5 / 4) + 273.15));
                        } else if (output.equals("Fahrenheit")) {
                            result.setText(String.valueOf((value * 9 / 4) + 32));
                        } else {
                            result.setText(String.valueOf(value));
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