package com.cloud.message.model;

import java.util.regex.Pattern;

/**
 * Created by harbor on 11/7/2018.
 */
public class OracleAlertLogEntry extends LogEntry {

    @Override
    public boolean isErrorLog() {


        String msg = getMessage();

        if( regexpMatch(msg,"ORA-[0-9]+")){

            if( regexpMatch(msg,"ORA-25307")){
                //ignore ORA-25307: Enqueue rate too high, flow control enabled
                return false;
            }

            return true;
        }

        return false;
    }
}
