package com.example.purchaseOrder.service;

import com.example.purchaseOrder.config.MessageConfig;
import com.example.purchaseOrder.entity.Order;
import com.example.purchaseOrder.message.MessageOrder;
import com.example.purchaseOrder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MessageOrder messageOrder;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(String id) {
        return orderRepository.findById(id);
    }

    public Order create (Order order) {
        var newOrder = orderRepository.save(order);
        messageOrder.sendMessage(newOrder);
        return newOrder;
    }

    public Order update (Order order) {
        if(order != null && !order.getId().isEmpty()){
            if(findById(order.getId()) != null)
                orderRepository.save(order);
                Optional<Order> currentOrder = orderRepository.findById(order.getId());
                messageOrder.sendMessage(currentOrder.get());
        }
        throw new RuntimeException();
    }

    public void delete (String id) {
        Optional<Order> currentOrder = orderRepository.findById(id);
        orderRepository.deleteById(id);
        messageOrder.sendMessage(currentOrder.get());
    }

    public void delete (Order order) {
        orderRepository.delete(order);
    }
}
