package com.cloud.message.model;

/**
 * Created by harbor on 11/23/2018.
 */
public class CommonLogEntry extends LogEntry {

    @Override
    public boolean isErrorLog() {
        return false;
    }
}
