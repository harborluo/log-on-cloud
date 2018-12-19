package com.cloud.message.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 * Created by harbor on 12/3/2018.
 */
public class Utils {

    public static boolean regexpMatch(String source, String pattern){
        return Pattern.compile(pattern).matcher(source).find();
    }


    public static String convertTimestamp(String timestamp, String pattern, String sourceTimezone, String targetTimezone){
        DateFormat source = new SimpleDateFormat(pattern);
        source.setTimeZone(TimeZone.getTimeZone(sourceTimezone));

        try {
            Date date = source.parse(timestamp);
            DateFormat target = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
            // Set the formatter to use a different timezone
            target.setTimeZone(TimeZone.getTimeZone(targetTimezone));
            return target.format(date);
        }catch(ParseException e){
            return "";
        }

    }
}
