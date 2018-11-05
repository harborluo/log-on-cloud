package com.cloud.notification.controller;

import com.cloud.notification.service.DingTalkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by harbor on 11/5/2018.
 */
@RestController
public class NotificationController {

    @Autowired
    DingTalkService service;

    @PostMapping(value = "/send/message/dev")
    @ApiOperation(value = "Send message to dev group", notes ="Send message to dev group via DingTalk")
    public @ResponseBody ResponseEntity<String> sendMessage2Dev(@RequestBody String message){
        String body = service.sendMessage2Dev(message);
        ResponseEntity<String>  response = new ResponseEntity<>(body, HttpStatus.OK);
        return response;
    }

}
