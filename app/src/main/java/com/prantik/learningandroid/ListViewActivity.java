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
            "Login Form - Constraint Layout"
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
                default:
                    Toast.makeText(this, options[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
