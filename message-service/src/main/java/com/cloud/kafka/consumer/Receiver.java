package com.cloud.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by harbor on 11/1/2018.
 */
@Component
public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = {"${app.topic.foo}"})
    public void receiveMessage(@Payload String message){
        logger.info("Receive message '{}'", message);
    }
}
