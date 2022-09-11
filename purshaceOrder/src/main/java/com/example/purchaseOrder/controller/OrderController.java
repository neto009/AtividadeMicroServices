package com.example.purchaseOrder.controller;

import com.example.purchaseOrder.entity.Order;
import com.example.purchaseOrder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public Optional<Order> findById (@PathVariable String id) {
        return orderService.findById(id);
    }

    @GetMapping
    public List<Order> findAll () {
        return orderService.findAll();
    }

    @PostMapping
    public Order create (@RequestBody Order order) {
        return orderService.create(order);
    }

    @PutMapping
    public Order update (@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable String id){
        orderService.delete(id);
    }

    @DeleteMapping
    public void delete (@RequestBody Order order) {
        orderService.delete(order);
    }
}
