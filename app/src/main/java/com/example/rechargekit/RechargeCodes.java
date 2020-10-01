package com.example.rechargekit;

import androidx.annotation.NonNull;

public class RechargeCodes {

    // airtime recharge codes
    private static  final String MTN_RECHARGE_CODE = "*555*" ;
    private  static  final  String AIRTEL_RECHARGE_CODE = "*126*" ;
    private  static  final  String GLO_RECHARGE_CODE = "*123*" +"#";
    private  static  final  String NINE_MOBILE_RECHARGE_CODE = "*222*";
    private static  final  String CODE_END = "#";

    // Data recharge codes
    private static  final String MTN_DATA_CODE = "*131*";
    private static final int MTN_WEEKLY_CODE = 102;


    //bank recharge codes
    private  static  final String GTB_CODE = "*737*";
    private  static  final String FB_CODE = "*894*";
    private  static  final String UBA_CODE = "*919*";
    private  static  final String ZENITH_CODE = "*966*";
    private  static  final String UB_CODE = "*826*";
    private  static  final String FIDELITY_CODE = "*770*";
    private  static  final String ECO_BANK_CODE = "*326*";
    private  static  final String POLARIS_CODE = "*833*";

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

    private  static  final String STAN_BIC_CODE = "*909*";


    public static String getCodeEnd() {
        return CODE_END;
    }

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

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
