package com.example.purchaseOrder.config;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.annotation.Exchange;

@Configuration
public class MessageConfig {
    //Endereço do exchange no RabbitMQ
    @Value("${purchaseOrder.rabbitmq.exchange}")
    String exchange;

    @Bean
    public Exchange declareExchange() {

        return ExchangeBuilder.directExchange(exchange)
                .durable(true)
                .build();
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}