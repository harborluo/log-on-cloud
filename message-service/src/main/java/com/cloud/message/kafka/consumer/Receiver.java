package com.cloud.message.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
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

//    @KafkaListener(topics = {"tentative-cpe-manager","tentative-cpe-worker"})
    public void processTomcatAccessLog(ConsumerRecord<?, ?> record){
        ObjectMapper mapperObj = new ObjectMapper();
        try {
//            String jsonStr = mapperObj.writeValueAsString(record.value());

            logger.info("Receive message '{}'", record.value());
        }catch(Exception e){

            e.printStackTrace();
        }
    }

//    @KafkaListener(topics = {"cdb_ui_log"})
//    public void processCDBUILog(@Payload String message){
//        logger.info("Receive message '{}'", message);
//    }

    @KafkaListener(topics = {"oracle_alert_log"})
    public void processOracleAlertLog(@Payload String message){
        logger.info("Receive message '{}'", message);
    }

}
