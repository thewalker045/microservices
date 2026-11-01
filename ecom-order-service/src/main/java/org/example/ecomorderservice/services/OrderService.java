package org.example.ecomorderservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private final RestTemplate restTemplate;
    private final RestClient restClient;

    OrderService(RestTemplate restTemplate, RestClient restClient) {
        this.restTemplate = restTemplate;
        this.restClient = restClient;
    }

    public String placeOrder(String productId) {

//        String response = restTemplate.getForObject(
//                "http://localhost:8081/inventory/" + productId,
//                String.class
//        );
        String response = restClient.get()
                .uri("http://localhost:8081/inventory/{productId}", productId)
                .retrieve()
                .body(String.class);

        assert response != null;
        if (response.equals("IN STOCK"))
            return "order placed";
        else
            return "insufficient Items";
    }
}
