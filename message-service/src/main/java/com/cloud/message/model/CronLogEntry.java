package com.cloud.message.model;

/**
 * Created by harbor on 11/9/2018.
 */
public class CronLogEntry extends LogEntry {

    @Override
    public boolean isErrorLog() {

        if(regexpMatch(this.getMessage(),"Upload (commpleted|complete)")){
            return true;
        }

        return false;
    }
}
