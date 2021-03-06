package com.prantik.learningandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private String[] options = {
            "Introduction",
            "My Bio App - Relative Layout",
            "My Bio App - Linear Layout",
            "Login Form - Constraint Layout",
            "Dice Roll App",
            "SMS App",
            "Currency Converter App",
            "Passing data between two activity"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, options);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent;
            switch (i) {
                case 0:
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(this, MyBioActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    startActivity(new Intent(this, MyBioLinearActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(this, LoginFormActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(this, DiceRollActivity.class));
                    break;
                case 5:
                    startActivity(new Intent(this, SmsActivity.class));
                    break;
                case 6:
                    startActivity(new Intent(this, CurrencyConverterActivity.class));
                    break;
                case 7:
                    startActivity(new Intent(this, Activity_one.class));
                    break;
                default:
                    Toast.makeText(this, options[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
