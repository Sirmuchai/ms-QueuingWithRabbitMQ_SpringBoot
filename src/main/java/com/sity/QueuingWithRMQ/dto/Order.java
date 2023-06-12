package com.sity.QueuingWithRMQ.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.EnableMBeanExport;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

    private String orderId;
    private String name;
    private String quantity;
    private String price;

}
