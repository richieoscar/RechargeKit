package com.example.rechargekit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import android.widget.Toast;

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

//        MenuItem menuItem = findViewById(R.id.item_menu_airtime);
//        menuItem.setVisible(false);




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

           if(network.getText().toString().toLowerCase().equals(airtel_id)){
               String code = String.format("%s %s %s",RechargeCodes.getAirtelRechargeCode(), airtimeRechargePin, RechargeCodes.getCodeEnd());
              // String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
               Intent dialer = new Intent(Intent.ACTION_DIAL);
              // Uri uri = Uri.parse("tel:" +code );
               dialer.setData(Uri.parse("tel:" +code));
               Log.d(TAG, "getData: is formatted");
               startActivity(dialer);
                return;
           }  else Toast.makeText(this, "Network not Recognized",Toast.LENGTH_SHORT).show();

            if(network.getText().toString().toLowerCase().equals(mtn_id)){
                String code = String.format("%s %s %s",RechargeCodes.getMtnRechargeCode(), airtimeRechargePin, RechargeCodes.getCodeEnd());
              //  String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
                Intent dialer = new Intent(Intent.ACTION_DIAL);
              //  Uri uri = Uri.parse("tel:" +code );
                dialer.setData(Uri.parse("tel:" +code));
                startActivity(dialer);
                return;
            } else Toast.makeText(this, "Network not Recognized",Toast.LENGTH_SHORT).show();

            if(network.getText().toString().toLowerCase().equals(glo_id)){
               String code = String.format("%s %s %s",RechargeCodes.getGloRechargeCode(), airtimeRechargePin, RechargeCodes.getCodeEnd());
                //String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
                Intent dialer = new Intent(Intent.ACTION_DIAL);
               // Uri uri = Uri.parse("tel:" +code );
                dialer.setData(Uri.parse("tel:" +code));
                startActivity(dialer);
                return;

            } else Toast.makeText(this, "Network not Recognized",Toast.LENGTH_SHORT).show();

            if(network.getText().toString().toLowerCase().equals(nine_mobile)){
                String code = String.format("%s %s %s",RechargeCodes.getNineMobileRechargeCode(), airtimeRechargePin, RechargeCodes.getCodeEnd());
               // String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
                Intent dialer = new Intent(Intent.ACTION_DIAL);
                //Uri uri = Uri.parse("tel:" +code );
                dialer.setData(Uri.parse("tel:" +code));
                return;
            }
            else Toast.makeText(this, "Network name not recognized", Toast.LENGTH_SHORT).show();

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
            String airtimeRechargePin = rechargePin.getText().toString(); //this editText serves for both airtime recharge pin and amount for bank recharge
            final String GTBANK_ID ="gtbank";
            final  String FB_ID = "firstbank";
            final String ZENITH_ID = "zenith";
            final String UBA_ID  = "uba";



            if(TextUtils.isEmpty(rechargePin.getText())){
                rechargePin.setError("Field is Empty");
                return;
            }
            if (TextUtils.isEmpty(network.getText())){
                network.setError("Field is Empty");
                return;
            }

            if(network.getText().toString().toLowerCase().equals(GTBANK_ID)){
                String code = String.format("%s %s %s",RechargeCodes.getGtbCode(), airtimeRechargePin, RechargeCodes.getCodeEnd());
               // String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
                Intent dialer = new Intent(Intent.ACTION_DIAL);
                dialer.setData(Uri.parse("tel:"+code));
                startActivity(dialer);
                return;
            }  else Toast.makeText(this, "Bank name not Recognized",Toast.LENGTH_SHORT).show();

            if(network.getText().toString().toLowerCase().equals(FB_ID)){
               String code = String.format("%s %s %s",RechargeCodes.getFbCode(), airtimeRechargePin, RechargeCodes.getCodeEnd());
                //String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
                Intent dialer = new Intent(Intent.ACTION_DIAL);
               dialer.setData(Uri.parse("tel:" +code));
                startActivity(dialer);
                return;
            } else Toast.makeText(this, "Bank name not Recognized",Toast.LENGTH_SHORT).show();

            if(network.getText().toString().toLowerCase().equals(ZENITH_ID)){
               String code = String.format("%s %s %s",RechargeCodes.getZenithCode(), airtimeRechargePin, RechargeCodes.getCodeEnd());
               // String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
                Intent dialer = new Intent(Intent.ACTION_DIAL);
                dialer.setData(Uri.parse("tel:" +code));
                startActivity(dialer);
                return;

            } else Toast.makeText(this, "Bank name not Recognized",Toast.LENGTH_SHORT).show();

            if(network.getText().toString().toLowerCase().equals(UBA_ID)){
               String code = String.format("%s %s %s",RechargeCodes.getUbaCode(), airtimeRechargePin, RechargeCodes.getCodeEnd());
               // String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
                Intent dialer = new Intent(Intent.ACTION_DIAL);
               // Uri uri = Uri.parse("tel:" +code );
                dialer.setData(Uri.parse("tel:" +code));
                startActivity(dialer);
                return;
            }
            else Toast.makeText(this, "Bank name not recognized", Toast.LENGTH_SHORT).show();










        });

    }
}