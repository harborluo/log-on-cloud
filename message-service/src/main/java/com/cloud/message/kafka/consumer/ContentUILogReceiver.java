package com.cloud.message.kafka.consumer;

import com.cloud.message.feign.client.NotificationClient;
import com.cloud.message.model.CDBLogEntry;
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
public class ContentUILogReceiver  {

    @Autowired
    NotificationClient client;

    private static final Logger logger = LoggerFactory.getLogger(ContentUILogReceiver.class);

    @KafkaListener(topics = {"cdb_ui_log"})
    public void processLog(@Payload CDBLogEntry logEntry){

        if(logEntry.isErrorLog()){
            logger.info("Receive message \n{}", logEntry.getNotificationMessage());
            client.sendMessage2Dev(logEntry.getNotificationMessage());
        }
//        else{
//            logger.debug("Receive message \n{}", logEntry.getNotificationMessage());
//        }

        logger.debug("Receive message \n{}", logEntry.getNotificationMessage());

    }

}
