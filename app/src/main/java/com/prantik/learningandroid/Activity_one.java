package com.prantik.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Activity_one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Button button_one = findViewById(R.id.button_one);

        button_one.setOnClickListener(view -> {
            Intent intent = new Intent(this, Activity_two.class);
            intent.putExtra("name", "Prantik");
            intent.putExtra("age", 15);
            intent.putExtra("message", "You can't see me");
            
            startActivity(intent);
        });
    }
}