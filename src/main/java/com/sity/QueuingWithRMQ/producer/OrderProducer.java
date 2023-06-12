package com.sity.QueuingWithRMQ.producer;

import com.sity.QueuingWithRMQ.config.MessagingConfig;
import com.sity.QueuingWithRMQ.dto.Order;
import com.sity.QueuingWithRMQ.dto.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderProducer {
    @Autowired
    public RabbitTemplate template;
    @Value("${rabbitmq.exchange.name}")
    private String EXCHANGE;
    @Value("${rabbitmq.routingKey.name}")
    private String ROUTING_KEY;

    @PostMapping("/{restrauntName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restrauntName) {
        order.setOrderId(UUID.randomUUID().toString());
        // restraunt Service
        // Payment Service
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed successfuly" + restrauntName);
        template.convertAndSend(EXCHANGE, ROUTING_KEY, orderStatus);
        log.info("Accepted");
        return "Success !!";
    }
}
