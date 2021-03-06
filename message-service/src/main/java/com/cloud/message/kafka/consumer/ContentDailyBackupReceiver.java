package com.cloud.message.kafka.consumer;

import com.cloud.message.feign.client.NotificationClient;
import com.cloud.message.model.CDBLogEntry;
import com.cloud.message.model.CronLogEntry;
import com.cloud.message.model.OracleAlertLogEntry;
import com.cloud.message.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by harbor on 11/9/2018.
 */
@Component
public class ContentDailyBackupReceiver {

    private static final Logger logger = LoggerFactory.getLogger(ContentDailyBackupReceiver.class);

    @Autowired
    NotificationClient client;

    @KafkaListener(topics = { "content_backup_cron_log"})
    public void processLog(@Payload CronLogEntry logEntry){
        if(logEntry.isErrorLog()){
            client.sendMessage2Dev(logEntry.getNotificationMessage());
        }

        if(Utils.regexpMatch(logEntry.getMessage(),"Upload (commpleted|complete)")){
            client.sendMessage2Dev(logEntry.getHostname()+"\n"+logEntry.getTimestamp()+"\n"+"Daily content DB backup successfully.");
        }

    }

}
