package com.endava.server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by astoica on 2/23/2016.
 */
@Controller
@RequestMapping(value = "/store/product")
public class ProductController {

    public static List<Product> productList = new ArrayList<>();

    @RequestMapping(value = "", method = POST)
    public @ResponseBody ResponseEntity createProduct(@RequestBody Product product) {

        Long productId = new Random().nextLong();
        product.setId(productId);
        productList.add(product);

        Map<String, Long> response = new HashMap<>();
        response.put("id", productId);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity getProductById(@PathVariable("id") Long productId) {

        for(Product product : productList) {
            if (product.getId().equals(productId)) {
                return new ResponseEntity(product, HttpStatus.OK);
            }
        }

        return new ResponseEntity("No product with id: " + productId + " was found", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity updateProduct(@PathVariable("id") Long productId, @RequestBody Product product) {

        for(Product existingProduct : productList) {
            if(existingProduct.getId().equals(productId)) {
                existingProduct.setName(product.getName());
                existingProduct.setPrice(product.getPrice());

                return new ResponseEntity(HttpStatus.OK);
            }
        }

        return new ResponseEntity("No product with id: " + productId + " was found", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity deleteProduct(@PathVariable("id") Long productId) {

        for(int i=0; i<productList.size(); i++) {
            if(productList.get(i).getId().equals(productId)) {
                productList.remove(i);

                return new ResponseEntity(HttpStatus.OK);
            }
        }

        return new ResponseEntity("No product with id: " + productId + " was found", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "", method = GET)
    public ResponseEntity findByPrice(@RequestParam(value = "price") Long price) {

        List<Product> foundProducts = new ArrayList<>();

        for(Product product : productList) {
            if(product.getPrice().equals(price)) {
                foundProducts.add(product);
            }
        }

        return new ResponseEntity(foundProducts, HttpStatus.OK);
    }
}
