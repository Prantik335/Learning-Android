package com.prantik.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyConverterActivity extends AppCompatActivity implements View.OnClickListener {

    Button convertButton;
    private EditText dollarTextField;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        convertButton = findViewById(R.id.convert_button);
        dollarTextField = findViewById(R.id.dollar_textField);
        resultTextView = findViewById(R.id.result_text);

        convertButton.setOnClickListener(this);

        dollarTextField.setOnEditorActionListener((textView, i, keyEvent) -> {
            convert();
            return false;
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.convert_button) {
            convert();
        }
    }

    private void convert() {
        if (!dollarTextField.getText().toString().isEmpty()) {
            double dollar = Double.parseDouble(dollarTextField.getText().toString());
            String taka = dollarToTaka(dollar) + " BDT";
            resultTextView.setText(taka);
        } else {
            Toast.makeText(this, "Enter an amount of dollar!", Toast.LENGTH_SHORT).show();
        }
    }

    private double dollarToTaka(double dollar) {
        return dollar * 84.5;
    }
}