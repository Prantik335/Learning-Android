package com.prantik.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class DiceRollActivity extends AppCompatActivity {
    private ImageView diceImage;
    private Button rollDiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        diceImage = findViewById(R.id.dice_image);
        rollDiceButton = findViewById(R.id.roll_dice_button);

        rollDiceButton.setOnClickListener(this::rollDice);
    }

    private void rollDice(View view) {
        int randomNum = new Random().nextInt(6) + 1;

        int imageId = R.drawable.six;

        switch (randomNum) {
            case 1:
                imageId = R.drawable.one;
                break;
            case 2:
                imageId = R.drawable.two;
                break;
            case 3:
                imageId = R.drawable.three;
                break;
            case 4:
                imageId = R.drawable.four;
                break;
            case 5:
                imageId = R.drawable.five;
        }

        diceImage.setImageResource(imageId);
    }
}