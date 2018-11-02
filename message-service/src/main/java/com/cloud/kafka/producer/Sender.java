package com.cloud.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by harbor on 11/1/2018.
 */
@Service
public class Sender {
    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.foo}")
    private String topic;

    public void send(String message){
        logger.info("sending message='{}' to topic='{}'", message, topic);
        try {
            kafkaTemplate.send(topic, message);
        }catch (Throwable e){
            logger.error("Fail to send message to kafka.", e);
            e.printStackTrace();
        }
        logger.info("Done.");
    }
}
