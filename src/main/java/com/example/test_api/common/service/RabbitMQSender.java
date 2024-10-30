package com.example.test_api.common.service;

import com.example.test_api.transaction.persistance.model.Transaction;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${test.rabbitmq.exchange}")
    private String exchange;

    @Value("${test.rabbitmq.routingkey}")
    private String routingkey;
    String kafkaTopic = "java_in_use_topic";

    public void send(Transaction transaction) {
        amqpTemplate.convertAndSend(exchange, routingkey, transaction);
        System.out.println("Send msg = " + transaction);
    }
}
