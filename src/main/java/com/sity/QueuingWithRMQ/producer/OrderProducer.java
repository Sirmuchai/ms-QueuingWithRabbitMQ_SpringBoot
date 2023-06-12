package com.sity.QueuingWithRMQ.producer;

import com.sity.QueuingWithRMQ.config.MessagingConfig;
import com.sity.QueuingWithRMQ.dto.Order;
import com.sity.QueuingWithRMQ.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderProducer {
    @Autowired
    public RabbitTemplate template;

    @PostMapping("/{restrauntName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restrauntName) {
        order.setOrderId(UUID.randomUUID().toString());
        // restraunt Service
        // Payment Service
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed successfuly" + restrauntName);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        return "Success !!";
    }
}
