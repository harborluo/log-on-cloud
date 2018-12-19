package com.cloud.message.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
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

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        //timestamp value sample is "2018-12-19T00:45:00.448Z"
        try {
            date = formatter.parse(this.timestamp);

        }catch (ParseException e){

        }

        // Set the formatter to use a different timezone
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));

        return formatter.format(date);
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

    public abstract boolean isErrorLog();

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Host {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
