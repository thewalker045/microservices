package org.example.ecominventoryservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class inventoryController {

    @GetMapping("/{productId}")
    public String checkInventory (@PathVariable String productId){
        return productId.equals("1") ? "IN STOCK" : "OUT OF STOCK";
    }
}
