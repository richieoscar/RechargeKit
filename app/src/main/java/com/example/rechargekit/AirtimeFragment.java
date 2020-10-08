package com.example.rechargekit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.rechargekit.models.AirtimeRechargeCodes;


public class AirtimeFragment extends Fragment {
    private Button done;
    private EditText bankName;
    private EditText rechargePin;
    private EditText amount;
    private Button cardRecharge;
    private Button bankRecharge;

    private static final String TAG = "AirtimeFragment";

    public AirtimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rechargePin = getView().findViewById(R.id.editText__recharge_pin);
        bankName = getView().findViewById(R.id.editText_network);
        done = getView().findViewById(R.id.button_done);
        cardRecharge = getView().findViewById(R.id.button_card_recharge);
        bankRecharge = getView().findViewById(R.id.button_bank_recharge);

        getData();
        rechargeCArd();
        bankRecharge();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_airtime, container, false);
        return  view;
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
//            if (TextUtils.isEmpty(network.getText())){
//                network.setError("Field is Empty");
//                return;
//            }
            // VALIDATE FIELDS
            //String checkNetwork = network.getText().toString().toLowerCase();

//            if(checkNetwork.equals(airtel_id)   && airtimeRechargePin.length()== AirtimeRechargeCodes.getAirtelDigitCodeLength() ){
//                String code = String.format("%s%s%s", AirtimeRechargeCodes.getAirtelRechargeCode(), airtimeRechargePin, AirtimeRechargeCodes.getEncodedHash());
//                actionCall(code);
//
//                return;
//
//            }
           if( airtimeRechargePin.length() == AirtimeRechargeCodes.getMtnDigitCodeLength()){
               String code = String.format("%s%s%s", AirtimeRechargeCodes.getMtnRechargeCode(), airtimeRechargePin, AirtimeRechargeCodes.getEncodedHash());
               actionCall(code);
                return;
            }
           else if( airtimeRechargePin.length() == AirtimeRechargeCodes.getMtnDigitCodeSecondLength()){
                String code = String.format("%s%s%s", AirtimeRechargeCodes.getMtnRechargeCode(), airtimeRechargePin, AirtimeRechargeCodes.getEncodedHash());
                // dialCode(code);
                actionCall(code);
                return;
            }

//            else if(checkNetwork.equals(glo_id) && airtimeRechargePin.length()==AirtimeRechargeCodes.getGloDigitCodeLength()) {
//                String code = String.format("%s%s%s", AirtimeRechargeCodes.getGloRechargeCode(), airtimeRechargePin, AirtimeRechargeCodes.getEncodedHash());
//                actionCall(code);
//                return;
//
//            }
//
//            else if(checkNetwork.equals(nine_mobile) && airtimeRechargePin.length()==AirtimeRechargeCodes.getNineMobileDigitCodeLength()){
//                String code = String.format("%s%s%s", AirtimeRechargeCodes.getNineMobileRechargeCode(), airtimeRechargePin, AirtimeRechargeCodes.getEncodedHash());
//                actionCall(code);
//
//                return;
//
//            }
            else {
                rechargePin.setError("Invalid network or Invalid pin code");

            }

        });

    }

    private void  rechargeCArd(){
        cardRecharge.setOnClickListener((view)->{
            rechargePin.setVisibility(View.VISIBLE);
            bankName.setVisibility(View.INVISIBLE);
            done.setVisibility(View.VISIBLE);
            done.setTextColor(Color.parseColor("#3149D1"));
            if(rechargePin.getText()!=null || bankName.getText()!=null){
                rechargePin.setText("");
                //network.setText("");
                rechargePin.setHint("Enter Recharge Pin");
                //network.setHint("Enter Network");
                }
            getData();

        });
        cardRecharge.setClickable(true);
    }
    private  void bankRecharge(){
        bankRecharge.setOnClickListener((view)->{
            rechargePin.setVisibility(View.VISIBLE);
            rechargePin.setHint("Enter Amount");
            bankName.setVisibility(View.VISIBLE);
            bankName.setHint("Enter Bank");
            done.setVisibility(View.VISIBLE);
            done.setTextColor(Color.parseColor("#FF5722"));
            if(rechargePin.getText()!=null || bankName.getText()!=null) {
                rechargePin.setText("");
                bankName.setText("");

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

            String checkNetwork = bankName.getText().toString().toLowerCase();

            //Check if fields are empty
            if(TextUtils.isEmpty(rechargePin.getText())){
                rechargePin.setError("Field is Empty");
                return;
            }
            if (TextUtils.isEmpty(bankName.getText())){
                bankName.setError("Field is Empty");
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
                bankName.setError("Invalid Bank name");
            }

        });

    }
    // Not used yet



    private void actionCall(String code) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + code));
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Log.d(TAG, "actionCall: check");
        startActivity(intent);

    }

}