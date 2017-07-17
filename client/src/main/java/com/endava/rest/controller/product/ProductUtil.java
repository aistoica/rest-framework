package com.endava.rest.controller.product;

import com.endava.rest.util.BaseUtil;
import com.endava.rest.util.RandomStringGenerator;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

/**
 * Created by astoica on 4/21/2016.
 */
public class ProductUtil extends BaseUtil {

    static Product createdProduct = null;

    public ProductUtil createProduct() {

        productController.setUser(user);
        Product product = new Product(RandomStringGenerator.generateString(), 120L);
        Response createProductResponse = productController.createProduct(product);
        createProductResponse.then().statusCode(HttpStatus.SC_CREATED);
        Long productId = createProductResponse.jsonPath().getLong("id");

        createdProduct = product;
        createdProduct.setId(productId);

        return this;
    }

    public ProductUpdateUtil updateProduct() {
        ProductUpdateUtil productUpdateUtils = new ProductUpdateUtil(createdProduct);
        productUpdateUtils.setUser(user);

        return productUpdateUtils;
    }

    public Product getCreatedProduct() {
        return createdProduct;
    }
}
