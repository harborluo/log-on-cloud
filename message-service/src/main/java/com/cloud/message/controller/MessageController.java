package com.cloud.message.controller;

import com.cloud.message.kafka.producer.Sender;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by harbor on 11/6/2018.
 */
@RestController
public class MessageController {

    @Autowired
    Sender sender;

    @ApiOperation(value = "send message to kafka", notes ="send message to kafka")
    @PostMapping("/send/{topic}")
    public String hello(@RequestParam(value="topic", required=true) String topic,
                        @RequestBody String message){
        sender.send(topic, message);
        return "Done";
    }
}
