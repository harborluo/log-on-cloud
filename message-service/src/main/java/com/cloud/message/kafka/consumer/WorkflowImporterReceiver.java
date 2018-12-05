package com.cloud.message.kafka.consumer;

import com.cloud.message.feign.client.NotificationClient;
import com.cloud.message.model.CronLogEntry;
import com.cloud.message.model.NormalizeLogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by harbor on 12/5/2018.
 */
@Component
public class WorkflowImporterReceiver {


    private static final Logger logger = LoggerFactory.getLogger(WorkflowImporterReceiver.class);

    @Autowired
    NotificationClient client;

    @KafkaListener(topics = {"workflow_importer_log"})
    public void processLog(@Payload NormalizeLogEntry logEntry){
        if(logEntry.isErrorLog()){
            logger.info("Send error message to researcher \n{}",logEntry.getNotificationMessage());
            client.sendMessage2Researcher(logEntry.getNotificationMessage());
        }
    }
}
