package com.cloud.message.kafka.consumer;

import com.cloud.message.model.CDBLogEntry;
import com.cloud.message.model.CommonLogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by harbor on 11/23/2018.
 */
@Component
public class OtherLogReceiver {

    private static final Logger logger = LoggerFactory.getLogger(ContentDailyArchiveBackupReceiver.class);

    @KafkaListener(topics = {"tomcat_access_log",
                              "tentative-cpe-manager",
                              "tentative-cpe-worker",
                              "technopedia_publish_cron_log",
                              "normalize_auto_map_cron_log",
                              "load_tentative_cron_log",
            "load_cve_data_cron_log"})
    public void processLog(@Payload CommonLogEntry log){

        logger.debug("Receive message \n{}", log.getNotificationMessage());

    }
}
