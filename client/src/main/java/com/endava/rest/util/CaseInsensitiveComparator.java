package com.endava.rest.util;

import java.util.Comparator;

/**
 * Created by astoica on 9/1/2015.
 */
public class CaseInsensitiveComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.toUpperCase().compareTo(o2.toUpperCase());
    }
}
