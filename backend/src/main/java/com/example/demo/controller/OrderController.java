package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.Shoe;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {
    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    // Giả sử có thể inject ShoeController để lấy danh sách giày
    private final ShoeController shoeController;

    public OrderController(ShoeController shoeController) {
        this.shoeController = shoeController;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        order.setId(idGen.getAndIncrement());
        double total = 0;
        for (Order.OrderItem item : order.getItems()) {
            Shoe shoe = shoeController.getAllShoes().stream()
                    .filter(s -> s.getId().equals(item.getShoeId()))
                    .findFirst().orElseThrow();
            total += item.getSoLuong() * shoe.getGia();
            // Trừ số lượng tồn kho
            shoe.setSoLuong(shoe.getSoLuong() - item.getSoLuong());
            item.setGia(shoe.getGia());
        }
        order.setTotal(total);
        orders.add(order);
        return order;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orders.stream().filter(o -> o.getId().equals(id)).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Order not found"));
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orders;
    }
}
