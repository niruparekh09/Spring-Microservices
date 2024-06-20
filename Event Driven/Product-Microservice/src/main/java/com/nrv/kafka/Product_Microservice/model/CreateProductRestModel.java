package com.nrv.kafka.Product_Microservice.model;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRestModel {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
