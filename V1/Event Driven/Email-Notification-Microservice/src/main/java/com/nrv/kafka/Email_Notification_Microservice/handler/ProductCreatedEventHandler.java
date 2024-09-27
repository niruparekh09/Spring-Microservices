package com.nrv.kafka.Email_Notification_Microservice.handler;

import com.nrv.kafka.core.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "product-created-events-topic" /*,groupId = "product-created-events"*/)
public class ProductCreatedEventHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @KafkaHandler
    public void handle(ProductCreatedEvent productCreatedEvent) {
        log.info("Received a new event: {} with Product Id: {}"
                , productCreatedEvent.getTitle(), productCreatedEvent.getProductId());
    }
}
