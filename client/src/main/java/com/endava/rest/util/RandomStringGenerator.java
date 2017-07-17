package com.endava.rest.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by astoica on 4/30/2015.
 */
public class RandomStringGenerator {

    private static SecureRandom random = new SecureRandom();

    public static String generateString() {
        return new BigInteger(130, random).toString(32);
    }
    
    public static String generateFixedLengthString(Integer length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
