package com.cloud.message.model;

import com.cloud.message.util.Utils;

/**
 * Created by harbor on 11/9/2018.
 */
public class CronLogEntry extends LogEntry {

    @Override
    public boolean isErrorLog() {

//        if(Utils.regexpMatch(this.getMessage(),"Upload (commpleted|complete)")){
//            return true;
//        }

        if(Utils.regexpMatch(this.getMessage(),"ORA-[0-9]+")){
            return true;
        }
        return false;
    }
}
