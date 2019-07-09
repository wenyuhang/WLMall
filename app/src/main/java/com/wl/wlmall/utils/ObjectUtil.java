package com.wl.wlmall.utils;

import java.util.List;


public class ObjectUtil {
    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0 || string.equals("null");
    }


    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isEmptyList(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean notEmpty(List list) {
        return list != null && list.size() > 0;
    }


    public static String getString4Int(int integer) {
        return String.valueOf(integer);
    }

    public static int getInt4String(String string) {
        if (!isEmpty(string)) {
            return Integer.parseInt(string);
        }
        return 0;
    }

    public static Long getLong4String(String string) {
        if (!isEmpty(string)) {
            return Long.parseLong(string);
        }
        return Long.parseLong("0");
    }


    public static double getDouble4String(String string) {
        double price = 0;
        try {
            price = Double.parseDouble(string);
        } catch (NumberFormatException e) {

        }

        return price;
    }

    public static String getAddOne(String string) {

        int number = getInt4String(string);
        return (number + 1) + "";

    }

}
