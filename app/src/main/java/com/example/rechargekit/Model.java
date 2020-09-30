package com.example.rechargekit;

import androidx.annotation.NonNull;

public class Model {
    private static  final String mtnRechargeCode = "*555*" +"#";
    private  static  final  String airtelRechargeCode = "*126*" +"#";
    private  static  final  String gloRechargeCode = "#124#*" +"#";
    private  static  final  String nineMobileRechargeCode = "*222*" +"#";

    public static String getMtnRechargeCode() {
        return mtnRechargeCode;
    }

    public static String getAirtelRechargeCode() {
        return airtelRechargeCode;
    }

    public static String getGloRechargeCode() {
        return gloRechargeCode;
    }

    public static String getNineMobileRechargeCode() {
        return nineMobileRechargeCode;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
