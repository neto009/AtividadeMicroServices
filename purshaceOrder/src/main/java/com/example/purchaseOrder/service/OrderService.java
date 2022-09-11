package com.example.purchaseOrder.service;

import com.example.purchaseOrder.entity.Order;
import com.example.purchaseOrder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

//    @Autowired
//    private MessageProduct messageProduct;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(String id) {
        return orderRepository.findById(id);
    }

    public Order create (Order order) {
        var newOrder = orderRepository.save(order);
//        messageProduct.sendMessage(newProduct);
        return newOrder;
    }

    public Order update (Order order) {
        if(order != null && !order.getId().isEmpty()){
            if(findById(order.getId()) != null)
                orderRepository.save(order);
        }
        return null;
    }

    public void delete (String id) {
        orderRepository.deleteById(id);
    }

    public void delete (Order order) {
        orderRepository.delete(order);
    }
}
