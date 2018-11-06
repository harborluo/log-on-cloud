package com.cloud.message.controller;

import com.cloud.message.feign.client.NotificationClient;
import com.cloud.message.kafka.producer.Sender;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by harbor on 11/6/2018.
 */
@RestController
public class MessageController {



    @Autowired
    Sender sender;

    @ApiOperation(value = "send message to kafka", notes ="send message to kafka")
    @PostMapping("/send")
    public String hello(@RequestBody String message){
        sender.send(message);
        return "done";
    }
}
