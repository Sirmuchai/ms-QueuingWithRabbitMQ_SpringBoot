package com.sity.QueuingWithRMQ.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderStatus {

    private Order order;
    private String stutus; // progress, completed
    private String message;
}
