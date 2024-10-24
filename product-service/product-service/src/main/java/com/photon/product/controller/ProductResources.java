package com.photon.product.controller;


import com.photon.product.bean.Products;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductResources {

    @RequestMapping("/{productId}")
    public List<Products> getProductById(@PathVariable("productId") Integer productId) {
        if (productId > 0 )
            return Collections.singletonList(new Products(productId, "product_1", "this is product-1", 1001, "img_product_1"));
        else
            return List.of(new Products(productId, "", "not a valid product id", 0.0, ""));
    }

    @RequestMapping("/")
    public List<Products> getProducts() {

        return List.of(
                new Products(1001, "product_1", "this is product-1", 1001, "img_product_1"),
                new Products(1002, "product_2", "this is product-2", 1002, "img_product_2"),
                new Products(1003, "product_3", "this is product-3", 1003, "img_product_3"),
                new Products(1004, "product_4", "this is product-4", 1004, "img_product_4"),
                new Products(1005, "product_5", "this is product-5", 1005, "img_product_5"));
    }
}
