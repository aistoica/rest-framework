package com.endava.rest.controller.cart;

/**
 * Created by astoica on 25/11/2016.
 */
public class Cart {

    private Long productId;
    private Integer quantity;

    public Cart(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
