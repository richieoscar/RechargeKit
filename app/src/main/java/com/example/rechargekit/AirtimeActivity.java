package com.example.rechargekit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rechargekit.models.AirtimeRechargeCodes;

public class AirtimeActivity extends AppCompatActivity {

    private Button done;
    private EditText network;
    private EditText rechargePin;
    private EditText amount;
    private Button cardRecharge;
    private Button bankRecharge;
    private static final String TAG = "AirtimeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtime);
       // amount = findViewById(R.id.editText_amount);
        rechargePin = findViewById(R.id.editText__recharge_pin);
        network = findViewById(R.id.editText_network);
        done = findViewById(R.id.button_done);
        cardRecharge = findViewById(R.id.button_card_recharge);
        bankRecharge = findViewById(R.id.button_bank_recharge);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Airtime Recharge");




        getData();
        rechargeCArd();
        bankRecharge();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.detail_menu, menu);
       menu.findItem(R.id.item_menu_airtime).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_menu_home:
                startActivity(new Intent(AirtimeActivity.this, MainActivity.class));
                finish();
                return  true;
            case R.id.item_menu_data:
                startActivity(new Intent(AirtimeActivity.this, DataActivity.class));
                finish();
                return true;

            case R.id.item_menu_transfer:
                startActivity(new Intent(AirtimeActivity.this, TransferActivity.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AirtimeActivity.this,MainActivity.class));
    }

    private void getData(){
        done.setOnClickListener((view)->{
           String airtimeRechargePin = rechargePin.getText().toString();
            final String airtel_id ="airtel";
            final  String mtn_id = "mtn";
            final String glo_id = "glo";
            final String nine_mobile = "9mobile";



           if(TextUtils.isEmpty(rechargePin.getText())){
               rechargePin.setError("Field is Empty");
               return;
           }
           if (TextUtils.isEmpty(network.getText())){
               network.setError("Field is Empty");
               return;
           }
            // VALIDATE FIELDS
            String checkNetwork = network.getText().toString().toLowerCase();

           if(checkNetwork.equals(airtel_id)   && airtimeRechargePin.length()== AirtimeRechargeCodes.getAirtelDigitCodeLength() ){
               String code = String.format("%s%s%s", AirtimeRechargeCodes.getAirtelRechargeCode(), airtimeRechargePin, AirtimeRechargeCodes.getEncodedHash());
               actionCall(code);

               return;

           }
            else if(checkNetwork.equals(mtn_id)  && airtimeRechargePin.length() == AirtimeRechargeCodes.getMtnDigitCodeLength()){
               String code = String.format("%s%s%s", AirtimeRechargeCodes.getMtnRechargeCode(), airtimeRechargePin, AirtimeRechargeCodes.getEncodedHash());
               actionCall(code);
                return;
            }
           else if(checkNetwork.equals(mtn_id)  && airtimeRechargePin.length() == AirtimeRechargeCodes.getMtnDigitCodeSecondLength()){
               String code = String.format("%s%s%s", AirtimeRechargeCodes.getMtnRechargeCode(), airtimeRechargePin, AirtimeRechargeCodes.getEncodedHash());
             // dialCode(code);
               actionCall(code);
               return;
           }

           else if(checkNetwork.equals(glo_id) && airtimeRechargePin.length()==AirtimeRechargeCodes.getGloDigitCodeLength()) {
               String code = String.format("%s%s%s", AirtimeRechargeCodes.getGloRechargeCode(), airtimeRechargePin, AirtimeRechargeCodes.getEncodedHash());
               actionCall(code);
               return;

           }

           else if(checkNetwork.equals(nine_mobile) && airtimeRechargePin.length()==AirtimeRechargeCodes.getNineMobileDigitCodeLength()){
               String code = String.format("%s%s%s", AirtimeRechargeCodes.getNineMobileRechargeCode(), airtimeRechargePin, AirtimeRechargeCodes.getEncodedHash());
               actionCall(code);

                return;

            }
            else {
               rechargePin.setError("Invalid network or Invalid pin code");

            }

        });

    }

    private void  rechargeCArd(){
        cardRecharge.setOnClickListener((view)->{
            rechargePin.setVisibility(View.VISIBLE);
            network.setVisibility(View.VISIBLE);
            done.setVisibility(View.VISIBLE);
            done.setTextColor(Color.parseColor("#3149D1"));
            if(rechargePin.getText()!=null || network.getText()!=null){ rechargePin.setText("");
            network.setText("");
            rechargePin.setHint("Enter Recharge Pin");
            network.setHint("Enter Network");}
            getData();

        });
        cardRecharge.setClickable(true);
    }
    private  void bankRecharge(){
       bankRecharge.setOnClickListener((view)->{
           rechargePin.setVisibility(View.VISIBLE);
           rechargePin.setHint("Enter Amount");
           network.setVisibility(View.VISIBLE);
           network.setHint("Enter Bank");
           done.setVisibility(View.VISIBLE);
           done.setTextColor(Color.parseColor("#FF5722"));
           if(rechargePin.getText()!=null || network.getText()!=null) {
               rechargePin.setText("");
               network.setText("");

           }
           getDataForBankRecharge();

       });
        bankRecharge.setClickable(true);
    }


    private void getDataForBankRecharge(){
        done.setOnClickListener((view)->{
            Log.d(TAG, "getDataForBankRecharge: check");
            String amount = rechargePin.getText().toString(); //this editText serves for both airtime recharge pin and amount for bank recharge
            final String GTBANK_ID ="gtbank";
            final  String FB_ID = "firstbank";
            final String ZENITH_ID = "zenith";
            final String UBA_ID  = "uba";

            String checkNetwork = network.getText().toString().toLowerCase();

            //Check if fields are empty
            if(TextUtils.isEmpty(rechargePin.getText())){
                rechargePin.setError("Field is Empty");
                return;
            }
            if (TextUtils.isEmpty(network.getText())){
                network.setError("Field is Empty");
                return;
            }

            if(checkNetwork.equals(GTBANK_ID)){
                String code = String.format("%s %s %s", AirtimeRechargeCodes.getGtbCode(), amount, AirtimeRechargeCodes.getEncodedHash());
                actionCall(code);
                return;
            }

            else if(checkNetwork.equals(FB_ID)){
                String code = String.format("%s %s %s", AirtimeRechargeCodes.getFbCode(), amount, AirtimeRechargeCodes.getEncodedHash());
                actionCall(code);
                return;

            }

            else if(checkNetwork.equals(ZENITH_ID)){
                String code = String.format("%s %s %s", AirtimeRechargeCodes.getZenithCode(), amount, AirtimeRechargeCodes.getEncodedHash());
                actionCall(code);
                return;
            }

            else if(checkNetwork.equals(UBA_ID)){
                String code = String.format("%s %s %s", AirtimeRechargeCodes.getUbaCode(), amount, AirtimeRechargeCodes.getEncodedHash());
                actionCall(code);
                return;
            }
            else {
               network.setError("Invalid Bank name");
            }

        });

    }
        // Not used yet
    private void dialCode(String code) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + code));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    private void actionCall(String code) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + code));
     if (ActivityCompat.checkSelfPermission(AirtimeActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        return;
        }
        Log.d(TAG, "actionCall: check");
        startActivity(intent);

    }
}