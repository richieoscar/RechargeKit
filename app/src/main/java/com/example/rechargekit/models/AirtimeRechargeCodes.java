package com.example.rechargekit.models;

import android.net.Uri;

import androidx.annotation.NonNull;

public class AirtimeRechargeCodes {

    // airtime recharge codes
    private static  final String MTN_RECHARGE_CODE = "*555*" ;
    private  static  final  String AIRTEL_RECHARGE_CODE = "*126*" ;
    private  static  final  String GLO_RECHARGE_CODE = "*123*" +"#";
    private  static  final  String NINE_MOBILE_RECHARGE_CODE = "*222*";
    private static final String ENCODED_HASH = Uri.encode("#");

    //RECHARGE PIN CODE LENGTH
    private static  final int MTN_DIGIT_CODE = 12;
    private static  final int MTN_DIGIT_CODE_SECOND = 10;
    private static  final int AIRTEL_DIGIT_CODE = 16;
    private static  final int GLO_DIGIT_CODE = 15;
    private static  final int NINE_MOBILE_DIGIT_CODE = 15;


    //PIN CODE LENGTH GETTER METHODS
    public static int getMtnDigitCodeLength() {
        return MTN_DIGIT_CODE;
    }

    public static int getMtnDigitCodeSecondLength() {
        return MTN_DIGIT_CODE_SECOND;
    }

    public static int getAirtelDigitCodeLength() {
        return AIRTEL_DIGIT_CODE;
    }

    public static int getGloDigitCodeLength() {
        return GLO_DIGIT_CODE;
    }

    public static int getNineMobileDigitCodeLength() {
        return NINE_MOBILE_DIGIT_CODE;
    }



    //bank recharge codes
    private  static  final String GTB_CODE = "*737*";
    private  static  final String FB_CODE = "*894*";
    private  static  final String UBA_CODE = "*919*";
    private  static  final String ZENITH_CODE = "*966*";
    private  static  final String UB_CODE = "*826*";
    private  static  final String FIDELITY_CODE = "*770*";
    private  static  final String ECO_BANK_CODE = "*326*";
    private  static  final String POLARIS_CODE = "*833*";
    private  static  final String STAN_BIC_CODE = "*909*";


    //BANK CODES GETTER METHODS
    public static String getGtbCode() {
        return GTB_CODE;
    }

    public static String getFbCode() {
        return FB_CODE;
    }

    public static String getUbaCode() {
        return UBA_CODE;
    }

    public static String getZenithCode() {
        return ZENITH_CODE;
    }

    public static String getUbCode() {
        return UB_CODE;
    }

    public static String getFidelityCode() {
        return FIDELITY_CODE;
    }

    public static String getEcoBankCode() {
        return ECO_BANK_CODE;
    }

    public static String getPolarisCode() {
        return POLARIS_CODE;
    }

    public static String getStanBicCode() {
        return STAN_BIC_CODE;
    }





        //CODE GETTER METHODS
    public static String getMtnRechargeCode() {
        return MTN_RECHARGE_CODE;
    }

    public static String getAirtelRechargeCode() {
        return AIRTEL_RECHARGE_CODE;
    }

    public static String getGloRechargeCode() {
        return GLO_RECHARGE_CODE;
    }

    public static String getNineMobileRechargeCode() {
        return NINE_MOBILE_RECHARGE_CODE;
    }
    public static String getEncodedHash() {
        return ENCODED_HASH;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
