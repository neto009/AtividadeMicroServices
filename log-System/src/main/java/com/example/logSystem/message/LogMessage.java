package com.example.logSystem.message;

import com.example.logSystem.entity.Log;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LogMessage {

    @Value("${logSystem.rabbitmq.exchange}")
    String exchange;
    @Value("${logSystem.rabbitmq.routingkey}")
    String routingKey;


    public final RabbitTemplate rabbitTemplate;

    public LogMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Log log) {
        rabbitTemplate.convertAndSend(exchange, routingKey, log);
    }
}
