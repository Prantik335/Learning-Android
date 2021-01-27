package com.prantik.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_two extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);
        String message = intent.getStringExtra("message");

        TextView dataTextView = findViewById(R.id.data_text_view);
        String data = "Name: " + name + "\nAge: " + age + "\nMessage: " + message;
        dataTextView.setText(data);

        Button buttonTwo = findViewById(R.id.button_two);
        buttonTwo.setOnClickListener(this::goToMainActivity);
    }

    private void goToMainActivity(View view) {
        startActivity(new Intent(this, ListViewActivity.class));
        finish();
    }
}