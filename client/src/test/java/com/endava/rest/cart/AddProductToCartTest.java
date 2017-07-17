package com.endava.rest.cart;

import com.endava.rest.util.TestBaseClass;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 * Created by astoica on 25/11/2016.
 */
public class AddProductToCartTest extends TestBaseClass {

    @Test
    public void addProductTest() {

        productUtil.setUser("Andrei");
        productUtil.createProduct()
                .updateProduct()
                .updatePrice(170L)
                .executeUpdate();
        Long productId = productUtil.getCreatedProduct().getId();


        cartUtil.setUser("Andrei");
        cartUtil.addToCart(productId, 1);
        cartUtil.addToCart(productId, 1);


        cartController.setUser("Andrei");
        Response getCartResponse = cartController.getCart();
        getCartResponse.prettyPeek();
    }
}
