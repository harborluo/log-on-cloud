package com.cloud.message.model;

import java.util.regex.Pattern;

/**
 * Created by harbor on 11/7/2018.
 */
public class OracleAlertLogEntry extends LogEntry {

    @Override
    public boolean isErrorLog() {


        String msg = getMessage();

        Pattern.compile("ORA").matcher(msg).find();

        if(Pattern.compile("ORA-[0-9]+").matcher(msg).find()){

            if( Pattern.compile("ORA-25307").matcher(msg).find()){
                //ignore ORA-25307: Enqueue rate too high, flow control enabled
                return false;
            }

            return true;
        }

        return false;
    }
}
