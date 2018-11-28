package com.cloud.message.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by harbor on 11/28/2018.
 */
@Service
@FeignClient(name = "web-ui-service")
public interface WebUiClient {

    @PostMapping("/receive/{topicName}")
    String receiveLog(@PathVariable String topicName, @RequestBody String message);

}
