package com.endava.rest.product;

import com.endava.rest.controller.product.Product;
import com.endava.rest.util.TestBaseClass;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by astoica on 25/11/2016.
 */
public class UpdateProductTest extends TestBaseClass {

    @Test
    public void updateProduct() {

        // create product
        productController.setUser("Andrei");
        Product product = new Product("dress", 100L);
        Response createProductResponse = productController.createProduct(product);
        createProductResponse.then().statusCode(HttpStatus.SC_CREATED);
        Long productId = createProductResponse.jsonPath().getLong("id");

        // update the product
        productController.setUser("Andrei");
        Product updatedProduct = new Product("dress", 150L);
        Response updateProductResponse = productController.updateProduct(productId, updatedProduct);
        updateProductResponse.prettyPeek().then().statusCode(HttpStatus.SC_OK);

        // get product
        productController.setUser("Andrei");
        Response getProductResponse = productController.getProductById(productId);
        getProductResponse.then().statusCode(HttpStatus.SC_OK)
                .body("id", is(productId))
                .body("name", is(updatedProduct.getName()))
                .body("price", is(updatedProduct.getPrice().intValue()));
    }
}
