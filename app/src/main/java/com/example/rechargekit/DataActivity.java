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

public class DataActivity extends AppCompatActivity {

    private Button done;
    private Button dataWithAirtime;
    private Button dataWithBank;
    private EditText price;
    private EditText dataNetwork;
    private EditText dataPlan;
    private static final String TAG = "DataActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Buy Data");
        done = findViewById(R.id.button_done);
        dataWithAirtime = findViewById(R.id.button_data_airtime);
        dataWithBank = findViewById(R.id.button_buy_data_bank);
        price = findViewById(R.id.editText_price);
        dataNetwork = findViewById(R.id.editText_data_network);
        dataPlan = findViewById(R.id.editText_plan);

        buyWithAirtime();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataActivity.this, MainActivity.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.detail_menu, menu);
        menu.findItem(R.id.item_menu_data).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_menu_home:
                startActivity(new Intent(DataActivity.this, MainActivity.class));
                finish();
                return  true;
            case R.id.item_menu_transfer:
                startActivity(new Intent(DataActivity.this, TransferActivity.class));
                finish();
                return true;

            case R.id.item_menu_airtime:
                startActivity(new Intent(DataActivity.this, AirtimeActivity.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getDataWithNetwork(){
        done.setOnClickListener((view)->{
            Log.d(TAG, "getDataForBankRecharge: check");
            String dataPrice = price.getText().toString(); //this editText serves for both price  and amount for bank recharge
            final String airtel_id ="airtel";
            final  String mtn_id = "mtn";
            final String glo_id = "glo";
            final String nine_mobile = "9mobile";
            final String plan ="weekly";
            final String plan2 = "monthly";


            //check if fields are empty
            if(TextUtils.isEmpty(price.getText())) {
                price.setError("Field is Empty");
                return;
            }

                if (TextUtils.isEmpty(dataNetwork.getText())) {
                    dataNetwork.setError("Field is Empty");
                    return;
                }

                    if(TextUtils.isEmpty(dataPlan.getText())) {
                        if((!dataPlan.getText().equals(plan) || !dataPlan.getText().equals(plan2))){
                            dataPlan.setError("Enter: weekly/monthly");
                            return;
                        }
                        dataPlan.setError("Field is Empty");

                        return;
                    }

                    //validate the Network

                    if(!dataNetwork.getText().toString().toLowerCase().equals(airtel_id)) {
                        Toast.makeText(this, "Network name not Recognized", Toast.LENGTH_SHORT).show();
                    }
              else {
                        String code = String.format("%s %s %s",RechargeCodes.getAirtelRechargeCode(), dataPrice, RechargeCodes.getCodeEnd());
                        // String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
                        Intent dialer = new Intent(Intent.ACTION_DIAL);
                        dialer.setData(Uri.parse("tel:"+code));
                        startActivity(dialer);
                    }

            if(!dataNetwork.getText().toString().toLowerCase().equals(mtn_id)){
                Toast.makeText(this, "Network name not Recognized", Toast.LENGTH_SHORT).show();
            } else {
                String code = String.format("%s %s %s",RechargeCodes.getMtnRechargeCode(), dataPrice, RechargeCodes.getCodeEnd());
                //String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
                Intent dialer = new Intent(Intent.ACTION_DIAL);
                dialer.setData(Uri.parse("tel:" +code));
                startActivity(dialer);

            }

            if(!dataNetwork.getText().toString().toLowerCase().equals(glo_id)){
                Toast.makeText(this, "Network name not Recognized", Toast.LENGTH_SHORT).show();

            } else {
                String code = String.format("%s %s %s",RechargeCodes.getGloRechargeCode(), dataPrice, RechargeCodes.getCodeEnd());
                // String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
                Intent dialer = new Intent(Intent.ACTION_DIAL);
                dialer.setData(Uri.parse("tel:" +code));
                startActivity(dialer);

            }

            if(!dataNetwork.getText().toString().toLowerCase().equals(nine_mobile)){
                Toast.makeText(this, "Network name not Recognized", Toast.LENGTH_SHORT).show();
            }
            else{
                String code = String.format("%s %s %s",RechargeCodes.getUbaCode(), dataPrice, RechargeCodes.getCodeEnd());
                // String code = String.format("%s %s %d",RechargeCodes.getGtbCode(), airtimeRechargePin,code_end);
                Intent dialer = new Intent(Intent.ACTION_DIAL);
                // Uri uri = Uri.parse("tel:" +code );
                dialer.setData(Uri.parse("tel:" +code));
                startActivity(dialer);

            }










        });

    }

    private void buyWithAirtime(){
        dataWithAirtime.setOnClickListener((view)->{
            price.setVisibility(View.VISIBLE);
            dataNetwork.setVisibility(View.VISIBLE);
            done.setVisibility(View.VISIBLE);
            done.setTextColor(Color.parseColor("#3149D1"));
            if(price.getText()!=null || dataNetwork.getText()!=null){
                price.setText("");
                dataNetwork.setText("");
                price.setHint("Enter Price");
                dataNetwork.setHint("Enter Network");
                dataPlan.setHint("Plan(weekly/Monthly");}
            getDataWithNetwork();

        });
        dataWithAirtime.setClickable(true);

    }
}