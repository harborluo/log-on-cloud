package com.cloud.message.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by harbor on 11/28/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogBackEntry {

//    @JsonProperty(value="source")
//    private String source;

    @JsonProperty(value="message")
    private String message;

    @JsonProperty(value="@timestamp")
    private String timestamp;

    @JsonProperty(value="host")
    private String host;

    @JsonProperty(value="logger_name")
    private String loggerName;

    @JsonProperty(value="port")
    private int port;

    @JsonProperty(value="thread_name")
    private String threadName;

    @JsonProperty(value="level")
    private String level;

//    public String getSource() {
//        return source;
//    }
//
//    public void setSource(String source) {
//        this.source = source;
//    }

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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNotificationMessage() {
        return "Host: " + getHost()+
                "\nTime: " + getTimestamp() +
                "\nport: "+ getPort()
                +"\n" + getMessage();
    }
}
