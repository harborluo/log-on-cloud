package com.cloud.message.kafka.consumer;

import com.cloud.message.feign.client.NotificationClient;
import com.cloud.message.model.LogEntry;
import com.cloud.message.model.OracleAlertLogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by harbor on 11/6/2018.
 */
@Component
public class OracleAlertLogReceiver {

    private static final Logger logger = LoggerFactory.getLogger(OracleAlertLogReceiver.class);

    @Autowired
    NotificationClient client;

    @KafkaListener(topics = {"oracle_alert_log"})
    public void processLog(@Payload OracleAlertLogEntry logEntry){

        logger.info("Receive message '{}'", logEntry.getMessage());

        if(logEntry.isErrorLog()){
            client.sendMessage2Dev(logEntry.getNotificationMessage());
        }

    }

}
