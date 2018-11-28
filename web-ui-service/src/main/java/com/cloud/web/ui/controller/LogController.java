package com.cloud.web.ui.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by harbor on 11/23/2018.
 */
@RequestMapping("/log")
@RestController
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @PostMapping("/receive/{topicName}")
    @ApiOperation(value = "Receive log from message service", notes ="Receive log from message service")
    public String receiveLog(@PathVariable("topicName") String topicName,
                             @RequestBody String message){

        logger.debug("Receive message: topic={} message:{}",topicName, message);

        return "Done";
    }
}
