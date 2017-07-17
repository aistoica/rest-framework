package com.endava.rest.controller.cart;

import com.endava.rest.BaseController;
import com.endava.rest.util.CustomRequestFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Created by astoica on 25/11/2016.
 */
public class CartController extends BaseController {

    public Response addProductToCart(Cart cart) {

        Response response = given().filter(new CustomRequestFilter(this))
                                   .contentType(ContentType.JSON)
                                   .body(cart)
                                   .put("cart");
        return response;
    }

    public Response getCart() {

        Response response = given().filter(new CustomRequestFilter(this))
                                   .get("cart");
        return response;
    }
}
