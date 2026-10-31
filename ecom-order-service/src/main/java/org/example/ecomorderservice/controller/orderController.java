package org.example.ecomorderservice.controller;

import org.example.ecomorderservice.services.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class orderController {

    private final RestTemplate restTemplate;
    private final OrderService orderService;
    orderController(OrderService orderService,RestTemplate restTemplate){
        this.orderService=orderService;
        this.restTemplate=restTemplate;
    }

    @PostMapping("/{productId}")
    public String placeOrder(@PathVariable String productId){

        return orderService.placeOrder(productId);
    }
}
