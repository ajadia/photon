package com.photon.order.controller;

import com.photon.order.bean.Order;
import com.photon.order.bean.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders/")
public class OrderAPI {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/createOrder")
    public List<Order> OrderAction() {
        List<Order> orderList = null;
        try {
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
            messageConverters.add(converter);
            Products products = restTemplate.getForObject("http://localhost:8081/products/1001", Products.class);
            restTemplate.setMessageConverters(messageConverters);
//Collections.singletonList(new Products(productId, "product_1", "this is product-1", 1001, "img_product_1"));
            orderList = Collections.singletonList(new Order(2001, "ANKIT JADIA", products, new Date()));
        } catch (Exception e) {
            System.out.println("Something went wrong..");
        }
        return orderList;
    }
}
