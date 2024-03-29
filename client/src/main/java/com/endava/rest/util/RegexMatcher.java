package com.endava.rest.util;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

/**
 * Created by astoica on 1/5/2016.
 */
public class RegexMatcher extends BaseMatcher {
    private final String regex;

    public RegexMatcher(String regex){
        this.regex = regex;
    }

    public boolean matches(Object o){
        return ((String)o).matches(regex);

    }

    public void describeTo(Description description){
        description.appendText("matches regex=");
    }

    public static RegexMatcher matches(String regex){
        return new RegexMatcher(regex);
    }
}
