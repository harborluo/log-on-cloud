package com.cloud.web.ui.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by harbor on 11/23/2018.
 */
@RequestMapping("/log")
@RestController
public class LogController {

    @PostMapping("/receive/{topicName}")
    public String processLog(@PathVariable String topicName,
                             @RequestBody String message){

        return "ok";
    }
}
