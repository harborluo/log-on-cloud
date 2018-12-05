package com.cloud.message.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by harbor on 12/5/2018.
 */
public class NormalizeLogEntry extends LogEntry {

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

        if("ERROR".equals(this.logLevel)){
            return true;
        }

        return false;
    }
}
