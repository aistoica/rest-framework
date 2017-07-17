package com.endava.rest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by astoica on 11/20/2015.
 */
public class DateFormatter {

    public static Date parseDate(String date) {

        if(date == null || date.isEmpty() || date.equals("null")) {
            return null;
        }

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            return formatter.parse(date);
        } catch (ParseException e) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                return formatter.parse(date);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    public static String formatDate(Date date) {
        return new SimpleDateFormat("MM/dd/yyyy").format(date);
    }

    public static String formatDeactivationDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
