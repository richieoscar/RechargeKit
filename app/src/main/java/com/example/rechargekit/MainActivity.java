package com.example.rechargekit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView header;
    private TextView mtn;
    private TextView airtel;
    private TextView glo;
    private TextView nineMobile;
    private Button airtimeButton;
    private Button dataButton;
    private Button transferButton;
    private Button airtimeOption;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header = findViewById(R.id.textView_header);
        mtn = findViewById(R.id.textView_mtn);
        airtel = findViewById(R.id.textView_airtel);
        glo = findViewById(R.id.textView_glo);
        nineMobile = findViewById(R.id.textView_9mobile);

        showMtnOptions();
        showAirtelOptions();
        showGloOption();
        showNineMobileOption();



    }

    private void showMtnOptions(){
        mtn.setOnClickListener((v)->{showOptions();});
    }

    private void showAirtelOptions(){
        airtel.setOnClickListener((v)->{showOptions();});
    }

    private void showOptions(){
            AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
           final   View view =inflater.inflate(R.layout.item_option, null);
           builder.setView(view);

       airtimeButton = view.findViewById(R.id.button_airtime);
       airtimeButton.setOnClickListener((v)->{goToDetailActivity(); finish();});

        dataButton =view.findViewById(R.id.button_data);
        dataButton.setOnClickListener((v)->{goToDetailActivity(); finish();});

        transferButton = view.findViewById(R.id.button_transfer);
        transferButton.setOnClickListener((v)->{goToDetailActivity(); finish();});

            builder.show();

    }

    private void goToDetailActivity(){
        startActivity(new Intent(MainActivity.this, DetailsActivity.class));
    }

    private void showGloOption(){
        glo.setOnClickListener((view)->{showOptions();});
    }
    private void showNineMobileOption(){
        nineMobile.setOnClickListener((view)->{showOptions();});

    }
}