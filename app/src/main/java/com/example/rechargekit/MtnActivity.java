package com.example.rechargekit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.rechargekit.models.FragmentTag;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MtnActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    private AirtimeFragment airtimeFragment;
    private DataFragment dataFragment;
    private TransferFragment transferFragment;


    private ArrayList<String> fragmentTags = new ArrayList<>();
    private  ArrayList<FragmentTag> fragments = new ArrayList<>();
    private int exitCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtn);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(MtnActivity.this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("MTN");


        initFragment();
    }

    private void setFragmentVisibility(String tagName){
        for(int i= 0; i<fragments.size(); i++){
            if(tagName.equals(fragments.get(i).getTag())){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.show(fragments.get(i).getFragment());
                transaction.commit();
            }
            else {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.hide(fragments.get(i).getFragment());
                transaction.commit();
            }
        }
    }


    private void initFragment(){
         airtimeFragment = new AirtimeFragment();
         fragments.add(new FragmentTag(airtimeFragment,getString(R.string.tag_fragment_airtime)));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_mtn_frame,airtimeFragment,getString(R.string.tag_fragment_airtime));
        transaction.commit();

       // setFragmentVisibility(getString(R.string.tag_fragment_airtime));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.item_airtime: {
                fragmentTags.clear();
                fragmentTags = new ArrayList<>();
               initFragment();
                setFragmentVisibility(getString(R.string.tag_fragment_airtime));
                menuItem.setChecked(true);

                break;
            }
            case R.id.item_data:{
                if(dataFragment == null){
                    dataFragment = new DataFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.add(R.id.main_mtn_frame, dataFragment,getString(R.string.tag_fragment_data));
                    transaction.commit();
                }
                else {
                    fragmentTags.remove(getString(R.string.tag_fragment_data));
                    fragmentTags.add(getString(R.string.tag_fragment_data));
                }
                menuItem.setChecked(true);
                setFragmentVisibility(getString(R.string.tag_fragment_data));
                break;
            }
            case R.id.item_transfer:{
                if(transferFragment == null){
                    transferFragment = new TransferFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.add(R.id.main_mtn_frame, transferFragment,getString(R.string.tag_fragment_transfer));
                    transaction.commit();
                }
                else {
                    fragmentTags.remove(getString(R.string.tag_fragment_transfer));
                    fragmentTags.add(getString(R.string.tag_fragment_transfer));
                }

                menuItem.setChecked(true);
                setFragmentVisibility(getString(R.string.tag_fragment_transfer));
                break;

            }

        }

        return false;
    }
}