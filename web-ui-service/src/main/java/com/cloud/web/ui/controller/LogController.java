package com.cloud.web.ui.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Created by harbor on 11/23/2018.
 */
@RequestMapping("/log")
@RestController
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/receive/{topicName}")
    @ApiOperation(value = "Receive log from message service", notes ="Receive log from message service")
    public String receiveLog(@PathVariable("topicName") String topicName,
                             @RequestBody String message){

        logger.info("Receive message: topic={} message:{}",topicName, message);

        messagingTemplate.convertAndSend("/log/topic/"+topicName, message);

        return "Done";
    }
}
