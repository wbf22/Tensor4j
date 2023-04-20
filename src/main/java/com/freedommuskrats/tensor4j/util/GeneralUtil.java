package com.freedommuskrats.tensor4j.util;

public class GeneralUtil {
    public static final int spacing = 4;

    public static double round(double value, int precision) {
        double mult = Math.pow(10, precision);
        return Math.round(value * mult) / mult;
    }

    public static String roundPrint(double value, int precision) {
        //TODO handle errors from larger values
        String str = String.valueOf(round(value, precision));
        while(str.split("\\.")[1].length() < precision) {
            str += "0";
        }
        if (str.split("\\.")[1].length() > precision) {
            str = str.split("\\.")[0];
        }

        while (str.length() < spacing) {
            str = " " + str;
        }

        return str;
    }


    public static String newLine() {
        return "\n";
    }

    /**
     * Handy print function to hide java's crazy print function
     * @param str
     */
    public static void println(Object str) {
        System.out.println(str);
    }

    /**
     * Handy print function to hide java's crazy print function
     * @param str
     */
    public static void print(Object str) {
        System.out.print(str);
    }
}
