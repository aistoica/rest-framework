package com.endava.rest.util;

/**
 * Created by astoica on 12/3/2015.
 */
public class ArrayUtil {

    public static boolean contains(String[] arr, String targetValue) {
        for(String s: arr){
            if(s.equals(targetValue))
                return true;
        }
        return false;
    }
}
