package com.cloud.message.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.regex.Pattern;

/**
 * Created by harbor on 11/7/2018.
 */
public class CDBLogEntry extends LogEntry {

    @JsonProperty(value="log_msg")
    private String message;

    @JsonProperty(value="log_level")
    private String logLevel;

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public boolean isErrorLog() {

        if("ERROR".equals(getLogLevel())){
            String msg = getMessage();
            //ORA-00001: unique constraint
            if( Pattern.compile("ORA-00001").matcher(msg).find()){
                //ignore ORA-00001: unique constraint (xxx) violated
                return false;
            }
            return true;
        }

        return false;
    }
}
