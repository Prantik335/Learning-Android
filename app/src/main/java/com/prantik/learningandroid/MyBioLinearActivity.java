package com.prantik.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MyBioLinearActivity extends AppCompatActivity {

    private EditText phoneTextField, nameTextField, emailTextField, addressTextField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bio_linear);

        phoneTextField = findViewById(R.id.phone_textField2);
        nameTextField = findViewById(R.id.name_textField2);
        emailTextField = findViewById(R.id.email_textField2);
        addressTextField = findViewById(R.id.address_textField2);
        submitButton = findViewById(R.id.submit_button2);

        submitButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, ProfileActivity.class);

            intent.putExtra("name", nameTextField.getText().toString());
            intent.putExtra("phone", phoneTextField.getText().toString());
            intent.putExtra("email", emailTextField.getText().toString());
            intent.putExtra("address", addressTextField.getText().toString());

            startActivity(intent);
        });
    }
}