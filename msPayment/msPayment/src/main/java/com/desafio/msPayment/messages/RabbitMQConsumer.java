package com.desafio.msPayment.messages;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message){
        System.out.println(message);
    }
}
