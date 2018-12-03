package com.cloud.message.util;

import java.util.regex.Pattern;

/**
 * Created by harbor on 12/3/2018.
 */
public class Utils {

    public static boolean regexpMatch(String source, String pattern){
        return Pattern.compile(pattern).matcher(source).find();
    }
}
