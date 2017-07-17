package com.endava.rest.product;

import  com.endava.rest.controller.product.Product;
import com.endava.rest.util.TestBaseClass;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by astoica on 25/11/2016.
 */
public class GetProductByIdTest extends TestBaseClass {

    @Test
    public void getProductById() {

        // create product
        productController.setUser("Andrei");
        Product product = new Product("dress", 100L);
        Response createProductResponse = productController.createProduct(product);
        createProductResponse.then().statusCode(HttpStatus.SC_CREATED);
        Long productId = createProductResponse.jsonPath().getLong("id");

        // get product
        productController.setUser("Andrei");
        Response getProductResponse = productController.getProductById(productId);
        getProductResponse.then().statusCode(HttpStatus.SC_OK)
                                 .body("id", is(productId))
                                 .body("name", is(product.getName()))
                                 .body("price", is(product.getPrice().intValue()));
    }
}
