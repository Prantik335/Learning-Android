package com.prantik.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView counterText;
    private Button plusButton, minusButton, resetButton, showHideButton;
    private ImageView imageMeme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.counter_text);
        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        resetButton = findViewById(R.id.reset_button);
        imageMeme = findViewById(R.id.image_meme);
        showHideButton = findViewById(R.id.show_hide_button);

        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

        showHideButton.setOnClickListener(view ->
        {
            if(imageMeme.getVisibility() == View.VISIBLE) {
                imageMeme.setVisibility(View.GONE);
            } else {
                imageMeme.setVisibility(View.VISIBLE);
            }
        });

    }



    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        int id = view.getId();
        int counter = Integer.parseInt(counterText.getText().toString());
        String counterTxt;

        switch (id) {
            case R.id.plus_button:
                counterTxt = (++counter) + "";
                counterText.setText(counterTxt);
                break;
            case R.id.minus_button:
                if (counter > 0) {
                    counterTxt = (--counter) + "";
                    counterText.setText(counterTxt);
                }
                break;
            case R.id.reset_button:
                counterText.setText("0");
                break;
            default:
                break;
        }
    }
}