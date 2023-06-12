package com.sity.QueuingWithRMQ.consumer;

import com.sity.QueuingWithRMQ.config.MessagingConfig;
import com.sity.QueuingWithRMQ.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("Message received from queue : " + orderStatus);
    }

}
