package com.prantik.learningandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {
    EditText phoneTextField, smsTextField;
    Button sendSmsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        phoneTextField = findViewById(R.id.sms_phone_textField);
        smsTextField = findViewById(R.id.sms_textField);
        sendSmsButton = findViewById(R.id.send_button);

        sendSmsButton.setOnClickListener(view -> {
            int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

            if (permission == PackageManager.PERMISSION_GRANTED) {
                // We can send sms
                sendSms();
            } else {
                // We have to ask for permission
                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.SEND_SMS},
                        333
                );
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 333) {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "Please give permission to send sms", Toast.LENGTH_LONG).show();
            } else {
                sendSms();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    private void sendSms() {
        SmsManager smsManager = SmsManager.getDefault();

        smsManager.sendTextMessage(
                phoneTextField.getText().toString().trim(),
                null,
                smsTextField.getText().toString(),
                null,
                null
        );

        Toast.makeText(this, "SMS sent", Toast.LENGTH_SHORT).show();
    }

}