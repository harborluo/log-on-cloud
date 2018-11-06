package com.cloud.message.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by harbor on 11/6/2018.
 */
//@Component
public class OracleAlertLogReceiver {

    private static final Logger logger = LoggerFactory.getLogger(OracleAlertLogReceiver.class);

    @KafkaListener(topics = {"oracle_alert_log"})
    public void processLog(@Payload String message){
        logger.info("Receive message '{}'", message);
    }

}
