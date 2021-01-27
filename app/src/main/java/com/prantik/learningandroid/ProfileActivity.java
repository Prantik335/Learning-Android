package com.prantik.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    private EditText phoneTextField, nameTextField, emailTextField, addressTextField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameTextField = findViewById(R.id.name_textField3);
        emailTextField = findViewById(R.id.email_textField3);
        phoneTextField = findViewById(R.id.phone_textField3);
        addressTextField = findViewById(R.id.address_textField3);
        submitButton = findViewById(R.id.submit_button3);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");

        System.out.println(name + " " + email + " " + phone + " " + address);

        nameTextField.setText(name);
        emailTextField.setText(email);
        phoneTextField.setText(phone);
        addressTextField.setText(address);

        submitButton.setOnClickListener(view -> {
            startActivity(new Intent(this, ListViewActivity.class));
            finish();
        });
    }
}