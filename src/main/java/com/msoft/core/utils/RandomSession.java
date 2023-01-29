package com.msoft.core.utils;

/**
 * @author ManhKM on 1/17/2023
 * @project cicd-tutorial
 */
public class RandomSession {

    public static String makeSession(int maxLen){
        String strNewPass = "";
        for(int intCounter = 1; intCounter <= maxLen; intCounter++){
            int upper, lower;
            double whatsNext = 2.0D * Math.random() + 0.0D;
            if(whatsNext < 0.35D || whatsNext > 0.7D){
                upper = 90;
                lower = 65;
            } else {
                upper = 57;
                lower = 48;
            }
            strNewPass = strNewPass + (char)(int)((upper - lower + 1) * Math.random() + lower);
        }
        return strNewPass;
    }

    public static void main(String[] args) {
        String resultSession = RandomSession.makeSession(13);
        System.out.println("Session Transaction: " + resultSession);
    }
}
