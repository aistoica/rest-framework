package com.endava.rest.controller.product;

import com.endava.rest.util.BaseUtil;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

/**
 * Created by astoica on 25/11/2016.
 */
public class ProductUpdateUtil extends BaseUtil {

    private Product product;

    public ProductUpdateUtil(Product product) {
        this.product = product;
    }

    public ProductUpdateUtil updateName(String newName) {

        product.setName(newName);
        return this;
    }

    public ProductUpdateUtil updatePrice(Long price) {

        product.setPrice(price);
        return this;
    }

    public ProductUpdateUtil executeUpdate() {

        productController.setUser(user);
        Response response = productController.updateProduct(product.getId(), product);
        response.then().statusCode(HttpStatus.SC_OK);

        return this;
    }
}
