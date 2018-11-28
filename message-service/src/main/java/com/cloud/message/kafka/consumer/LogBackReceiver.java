package com.cloud.message.kafka.consumer;

import com.cloud.message.model.LogBackEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by harbor on 11/23/2018.

 <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
 <encoder>
 <pattern>{%d{MM-dd HH:mm:ss.SSS}} [%thread] %-5level %logger{36}.%M\(%line\) - %msg%n</pattern>
 </encoder>
 </appender>

 <appender name="log-stash" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
 <destination>192.168.9.150:6044</destination>
 <destination>192.168.11.60:6044</destination>
 <encoder class="net.logstash.logback.encoder.LogstashEncoder">
 <customFields>{"fields" : { "log_type" : "tentative-cpe-manager" } }</customFields>
 </encoder>
 </appender>

 */
@Component
public class LogBackReceiver {

    private static final Logger logger = LoggerFactory.getLogger(LogBackReceiver.class);

    @KafkaListener(topics = {"tentative-cpe-manager", "tentative-cpe-worker"})
    public void processLog(@Payload LogBackEntry log){

        logger.debug("Receive message \n{}", log.getNotificationMessage());

    }
}
