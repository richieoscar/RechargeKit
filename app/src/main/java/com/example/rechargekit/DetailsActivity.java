package com.example.rechargekit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    private Button done;
    private EditText phoneNumber;
    private EditText rechargePin;
    private EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        amount = findViewById(R.id.editText_amount);
        rechargePin = findViewById(R.id.editText__recharge_pin);
        phoneNumber = findViewById(R.id.editText_phone_number);
        done = findViewById(R.id.button_done);

        getData();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DetailsActivity.this,MainActivity.class));
    }

    private void getData(){
        done.setOnClickListener((view)->{
            String codeEnd = "#";
          String airtimeAmount=  amount.getText().toString();
           String airtimeRechargePin = rechargePin.getText().toString();



           if(TextUtils.isEmpty(amount.getText())){
               amount.setError("Field is Empty");
               return;
           }
           if(TextUtils.isEmpty(rechargePin.getText())){
               rechargePin.setError("Field is Empty");
               return;
           }

         //  String code = RechargeCodes.getAirtelRechargeCode() +airtimeRechargePin +codeEnd;
           String code = String.format("%s %s %s",RechargeCodes.getAirtelRechargeCode(), airtimeRechargePin, codeEnd);

            Uri uri = Uri.parse("tel:" +code );
           Intent dialer = new Intent(Intent.ACTION_DIAL,uri);
           startActivity(dialer);





        });

    }
}