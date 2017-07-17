package com.endava.rest.util;

import com.endava.rest.BaseController;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

/**
 * Created by astoica on 7/3/2015.
 */
public class CustomRequestFilter implements Filter {

    private BaseController baseController;

    public CustomRequestFilter(BaseController baseController) {
        this.baseController = baseController;
    }

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {

        if(baseController.getUser() != null) {
            requestSpec.header("user", baseController.getUser());
        }

        return ctx.next(requestSpec, responseSpec);
    }
}
