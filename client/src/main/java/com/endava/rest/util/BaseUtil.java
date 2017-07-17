package com.endava.rest.util;

import com.endava.rest.controller.cart.CartController;
import com.endava.rest.controller.product.ProductController;

/**
 * Created by astoica on 4/21/2016.
 */
public class BaseUtil {

    protected ProductController productController = new ProductController();
    protected CartController cartController = new CartController();

    protected String user;

    public void setUser(String user) {
        this.user = user;
    }
}
