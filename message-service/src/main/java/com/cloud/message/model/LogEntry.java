package com.cloud.message.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.regex.Pattern;

/**
 * Created by harbor on 11/7/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class LogEntry {

//    @JsonProperty(value="offset")
//    private int offset;

    @JsonProperty(value="source")
    private String source;

    @JsonProperty(value="message")
    private String message;

    @JsonProperty(value="@timestamp")
    private String timestamp;

    @JsonProperty(value="host")
    private Host host;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public  String getHostname() {
        return host.getName();
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public String getNotificationMessage(){
        return "Host: " + getHostname()+
                "\nTime: " + getTimestamp() +
                "\nLog file: "+ getSource()
                +"\n" + getMessage();
    }

    public boolean regexpMatch(String source, String pattern){
       return Pattern.compile(pattern).matcher(source).find();
    }

    public abstract boolean isErrorLog();

}

class Host {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
