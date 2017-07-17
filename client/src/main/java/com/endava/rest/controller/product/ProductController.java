package com.endava.rest.controller.product;

import com.endava.rest.BaseController;
import com.endava.rest.util.CustomRequestFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Created by astoica on 2/23/2016.
 */
public class ProductController extends BaseController {

    public Response createProduct(Product product) {

        Response response = given().filter(new CustomRequestFilter(this))
                                   .contentType(ContentType.JSON)
                                   .body(product)
                                   .post("product");
        return response;
    }

    public Response getProductById(Long productId) {

        Response response = given().filter(new CustomRequestFilter(this))
                                   .pathParam("id", productId)
                                   .get("product/{id}");
        return response;
    }

    public Response updateProduct(Long productId, Product product) {

        Response response = given().filter(new CustomRequestFilter(this))
                                   .pathParam("id", productId)
                                   .contentType(ContentType.JSON)
                                   .body(product)
                                   .put("product/{id}");
        return response;
    }

    public Response deleteProduct(Long productId) {

        Response response = given().filter(new CustomRequestFilter(this))
                                   .pathParam("id", productId)
                                   .delete("product/{id}");
        return response;
    }

    public Response searchProductByPrice(Long price) {

        Response response = given().filter(new CustomRequestFilter(this))
                                   .queryParam("price", price)
                                   .get("product");
        return response;
    }
}
