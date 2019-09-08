package com.example.samplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;
    TextView resultTextView;
    String operator;

    double num1;
    double num2;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumber = findViewById(R.id.firstNumberET);
        secondNumber = findViewById(R.id.secondNumberET);
        resultTextView = findViewById(R.id.resultTextView);
        result = 0;
    }

    public void onClickHandler(View view) {
        switch (view.getId()) {
            case R.id.plusBtn:
                operator = "+";
                printToast("Addition");
                break;

            case R.id.minusBtn:
                operator = "-";
                printToast("Subtraction");
                break;

            case R.id.multiplyBtn:
                operator = "*";
                printToast("Multiplication");
                break;

            case R.id.divideBtn:
                operator = "/";
                printToast("Division");
                break;

            case R.id.equalBtn:
                calculate(operator);
                break;

            case R.id.clearBtn:
                firstNumber.setText("");
                secondNumber.setText("");
                resultTextView.setText("");
                break;
        }
    }

    private void printToast(String operation) {
        Toast.makeText(this, operation, Toast.LENGTH_SHORT).show();
    }


    private void calculate(String operator) {

        if (firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "Invalid Input, cannot be calculated.", Toast.LENGTH_SHORT).show();
        } else {
            num1 = Integer.valueOf(firstNumber.getText().toString());
            num2 = Integer.valueOf(secondNumber.getText().toString());

            switch (operator) {
                case "+":
                    if (result != 0) {
                        result = 0;
                        result = num1 + num2;
                    } else {
                        result = num1 + num2;
                    }
                    break;

                case "-":
                    if (result != 0) {
                        result = 0;
                        result = num1 - num2;
                    } else {
                        result = num1 - num2;
                    }
                    break;

                case "*":
                    if (result != 0) {
                        result = 0;
                        result = num1 * num2;
                    } else {
                        result = num1 * num2;
                    }
                    break;

                case "/":
                    if (num2 == 0) {
                        Toast.makeText(this, "Invalid input for number 2, cannot divide with zero.", Toast.LENGTH_LONG).show();
                    } else {
                        if (result != 0) {
                            result = 0;
                            result = num1 / num2;
                        } else {
                            result = num1 / num2;
                        }
                    }
                    break;
            }
            resultTextView.setText(new DecimalFormat("##.###").format(result));
        }
    }
}
