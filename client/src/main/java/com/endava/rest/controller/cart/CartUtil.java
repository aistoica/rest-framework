package com.endava.rest.controller.cart;

import com.endava.rest.util.BaseUtil;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

/**
 * Created by astoica on 25/11/2016.
 */
public class CartUtil extends BaseUtil {

    public CartUtil addToCart(Long productId, Integer quantity) {

        cartController.setUser(user);
        Cart cart = new Cart(productId, quantity);
        Response response = cartController.addProductToCart(cart);
        response.then().statusCode(HttpStatus.SC_OK);

        return this;
    }
}
