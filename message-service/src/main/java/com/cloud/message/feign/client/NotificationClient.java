package com.cloud.message.feign.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by harbor on 11/6/2018.
 */
@Service
@FeignClient(name = "notification-service")
public interface NotificationClient {

    @PostMapping(value = "/send/message/dev")
    @ResponseBody ResponseEntity<String> sendMessage2Dev(@RequestBody String message);

}
