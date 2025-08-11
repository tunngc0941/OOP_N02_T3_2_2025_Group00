package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/revenue")
@CrossOrigin
public class RevenueController {
    private final OrderController orderController;

    public RevenueController(OrderController orderController) {
        this.orderController = orderController;
    }

    @GetMapping
    public double getRevenue() {
        return orderController.getAllOrders().stream().mapToDouble(o -> o.getTotal()).sum();
    }
}
