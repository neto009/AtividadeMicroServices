package com.example.purchaseOrder.message;

import com.example.purchaseOrder.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageOrder {

    @Value("purchaseOrder.rabbitmq.exchange")
    String exchange;

    @Value("purchaseOrder.rabbitmq.routingkey")
    String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Order order) {
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
    }
}
