package com.cloud.message.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static java.awt.SystemColor.info;

/**
 * Created by harbor on 11/5/2018.
 */
@Component
public class DingTalkService {

    @Value("${ding.talk.api.url}")
    private String dingTalkApiUrl;

    @Value("${ding.talk.api.token.dev}")
    private String dingTalkApiTokenDev;

    @Value("${ding.talk.api.token.research}")
    private String dingTalkApiTokenResearch;

    private String sendMessage(String token, String message){

        String responseBody = "";

        try{
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(dingTalkApiUrl+token);
            StringEntity params = new StringEntity("{\"msgtype\": \"text\", \"text\": {\"content\": \"" + info + message + "\"},\"at\":{\"isAtAll\":true} }");

            request.addHeader("content-type", "application/json");
            request.setEntity(params);

            HttpResponse response = httpClient.execute(request);
            responseBody = EntityUtils.toString(response.getEntity());
        }catch(IOException e){

        }
        return responseBody;
    }

    /**
     *
     * @param message
     * @return
     */
    public String sendMessage2Dev(String message){
        return sendMessage(dingTalkApiTokenDev, message);
    }

    /**
     *
     * @param message
     * @return
     */
    public String sendMessage2Researcher(String message){
        return sendMessage(dingTalkApiTokenResearch, message);
    }

}
