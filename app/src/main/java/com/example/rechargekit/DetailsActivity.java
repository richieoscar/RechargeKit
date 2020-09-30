package com.example.rechargekit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        EditText amount = findViewById(R.id.editText_amount);
        EditText rechargePin = findViewById(R.id.editText__recharge_pin);
        EditText phoneNumber = findViewById(R.id.editText_phone_number);
        Button done = findViewById(R.id.button_done);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DetailsActivity.this,MainActivity.class));
    }
}