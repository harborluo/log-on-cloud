package com.cloud.message.controller;

import com.cloud.message.feign.client.NotificationClient;
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

    @Autowired
    NotificationClient client;

    @ApiOperation(value = "send message to kafka", notes ="send message to kafka")
    @PostMapping("/send/{topic}")
    public String hello(@RequestParam(value="topic", required=true) String topic,
                        @RequestBody String message){
        sender.send(topic, message);
        return "Done";
    }

    @ApiOperation(value = "send message to kafka", notes ="send message to kafka")
    @PostMapping("/test/notification")
    public String test(@RequestBody(required = true) String message){
        client.sendMessage2Dev(message);
        return "Done";
    }

}
