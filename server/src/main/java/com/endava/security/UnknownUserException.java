package com.endava.security;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by astoica on 2/29/2016.
 */
public class UnknownUserException extends AuthenticationException {

    public UnknownUserException(String msg) {
        super(msg);
    }
}
