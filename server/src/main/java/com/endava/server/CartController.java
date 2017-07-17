package com.endava.server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.endava.server.ProductController.productList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by astoica on 25/11/2016.
 */
@Controller
@RequestMapping(value = "/store/cart")
public class CartController {

    static Map<String, List<Cart>> cartList = new HashMap<>();

    @RequestMapping(value = "", method = PUT)
    public ResponseEntity addProductToChart(@RequestBody Cart cart) {

        String actorUser = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!cartList.containsKey(actorUser)) {
            List<Cart> cartListForUser = new ArrayList<>();
            cartListForUser.add(cart);

            cartList.put(actorUser, cartListForUser);
        } else {
            cartList.get(actorUser).add(cart);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = GET)
    public ResponseEntity getChartForUser() {

        String actorUser = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Cart> userCart = cartList.get(actorUser);
        return new ResponseEntity(userCart, HttpStatus.OK);
    }
}
