package com.example.rechargekit.models;

import android.net.Uri;

public class DataRechargeCodes {


    //MTN DAILY DATA RECHARGE CODES

    private static final String FIFTY_NAIRA__DAILY_DATA_CODE = "*131*1*1*1";
    private static final String HUNDRED_NAIRA_DAILY_DATA_CODE = "*131*104";
    private static final String TWO_HUNDRED_NAIRA_DAILY_DATA_CODE = "*131*113";
    private static final String THREE_HUNDRED_NAIRA_DAILY_DATA_CODE = "*131*155";
    private static final String FIVE_HUNDRED_NAIRA_DAILY_DATA_CODE = "*131*154";


    // MTN WEEKLY DATA RECHARGE CODES
    private static final String THREE_HUNDRED_NAIRA_WEEKLY_DATA_CODE = "*131*102";
    private static final String FIVE_HUNDRED_NAIRA_WEEKLY_DATA_CODE = "*131*142";
    private static final String FIVE_HUNDRED_750MB_NAIRA_WEEKLY_DATA_CODE = "*131*103";
    private static final String ONE_FIVE_NAIRA_WEEKLY_DATA_CODE = "*131*143";



    //MTN MONTHLY DATA RECHARGE CODES
    private static  final  String ONE_THOUSAND_NAIRA_MONTHLY_DATA_CODE = "131*106";
    private static  final  String ONE_TWO_THOUSAND_NAIRA_MONTHLY_DATA_CODE = "131*130";
    private static  final  String ONE_FIVE_THOUSAND_NAIRA_MONTHLY_DATA_CODE = "131*131";
    private static  final  String TWO_THOUSAND_NAIRA_MONTHLY_DATA_CODE = "131*110";
    private static  final  String TWO_FIVE_THOUSAND_NAIRA_MONTHLY_DATA_CODE = "131*147";
    private static  final  String THREE_FIVE_THOUSAND_NAIRA_MONTHLY_DATA_CODE = "131*107";
    private static  final  String FIVE_THOUSAND_NAIRA_MONTHLY_DATA_CODE = "131*116";
    private static  final  String TEN_THOUSAND_NAIRA_MONTHLY_DATA_CODE = "131*117";
    private static  final  String FIFTEEN_THOUSAND_NAIRA_MONTHLY_DATA_CODE = "131*150";
    private static  final  String TWENTY_THOUSAND_NAIRA_MONTHLY_DATA_CODE = "131*149";

    private static final String ENCODED_HASH = Uri.encode("#");



    //GETTER METHODS
    public static String getFiftyNaira_dailyDataCode() {
        return FIFTY_NAIRA__DAILY_DATA_CODE;
    }

    public static String getHundredNairaDailyDataCode() {
        return HUNDRED_NAIRA_DAILY_DATA_CODE;
    }

    public static String getTwoHundredNairaDailyDataCode() {
        return TWO_HUNDRED_NAIRA_DAILY_DATA_CODE;
    }

    public static String getThreeHundredNairaDailyDataCode() {
        return THREE_HUNDRED_NAIRA_DAILY_DATA_CODE;
    }

    public static String getFiveHundredNairaDailyDataCode() {
        return FIVE_HUNDRED_NAIRA_DAILY_DATA_CODE;
    }

    public static String getThreeHundredNairaWeeklyDataCode() {
        return THREE_HUNDRED_NAIRA_WEEKLY_DATA_CODE;
    }

    public static String getFiveHundredNairaWeeklyDataCode() {
        return FIVE_HUNDRED_NAIRA_WEEKLY_DATA_CODE;
    }

    public static String getFiveHundred750mbNairaWeeklyDataCode() {
        return FIVE_HUNDRED_750MB_NAIRA_WEEKLY_DATA_CODE;
    }

    public static String getOneFiveNairaWeeklyDataCode() {
        return ONE_FIVE_NAIRA_WEEKLY_DATA_CODE;
    }

    public static String getOneThousandNairaMonthlyDataCode() {
        return ONE_THOUSAND_NAIRA_MONTHLY_DATA_CODE;
    }

    public static String getOneTwoThousandNairaMonthlyDataCode() {
        return ONE_TWO_THOUSAND_NAIRA_MONTHLY_DATA_CODE;
    }

    public static String getOneFiveThousandNairaMonthlyDataCode() {
        return ONE_FIVE_THOUSAND_NAIRA_MONTHLY_DATA_CODE;
    }

    public static String getTwoThousandNairaMonthlyDataCode() {
        return TWO_THOUSAND_NAIRA_MONTHLY_DATA_CODE;
    }

    public static String getTwoFiveThousandNairaMonthlyDataCode() {
        return TWO_FIVE_THOUSAND_NAIRA_MONTHLY_DATA_CODE;
    }

    public static String getThreeFiveThousandNairaMonthlyDataCode() {
        return THREE_FIVE_THOUSAND_NAIRA_MONTHLY_DATA_CODE;
    }

    public static String getFiveThousandNairaMonthlyDataCode() {
        return FIVE_THOUSAND_NAIRA_MONTHLY_DATA_CODE;
    }

    public static String getTenThousandNairaMonthlyDataCode() {
        return TEN_THOUSAND_NAIRA_MONTHLY_DATA_CODE;
    }

    public static String getFifteenThousandNairaMonthlyDataCode() {
        return FIFTEEN_THOUSAND_NAIRA_MONTHLY_DATA_CODE;
    }

    public static String getTwentyThousandNairaMonthlyDataCode() {
        return TWENTY_THOUSAND_NAIRA_MONTHLY_DATA_CODE;
    }

    public static String getEncodedHash() {
        return ENCODED_HASH;
    }


}
