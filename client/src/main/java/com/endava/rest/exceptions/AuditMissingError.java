package com.endava.rest.exceptions;

import org.testng.Reporter;

/**
 * Created by dneagu on 8/18/2015.
 */
public class AuditMissingError extends Error {

    public AuditMissingError(String message) {

        super(message);
        Reporter.log("Following error has occured: " + message);
    }

}
