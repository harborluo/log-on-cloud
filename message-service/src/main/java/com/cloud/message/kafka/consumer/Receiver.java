package com.cloud.message.kafka.consumer;

import com.cloud.message.feign.client.NotificationClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by harbor on 11/1/2018.
 */
@Component
public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    NotificationClient client;

    @KafkaListener(topics = {"${app.topic.foo}"})
    public void processLog(@Payload String message){
        logger.info("Receive message '{}'", message);
        client.sendMessage2Dev(message);
    }

}
