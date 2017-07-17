package com.endava.rest.product;

import com.endava.rest.controller.product.Product;
import com.endava.rest.util.TestBaseClass;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

/**
 * Created by astoica on 2/23/2016.
 */
public class CreateProductTest extends TestBaseClass {

    @Test()
    public void createProduct() {

        productController.setUser("Andrei");
        Product product = new Product("name", 12L);
        Response response = productController.createProduct(product);
        response.prettyPeek()
                .then().statusCode(HttpStatus.SC_CREATED)
                       .body("id", not(nullValue()));
    }


}
