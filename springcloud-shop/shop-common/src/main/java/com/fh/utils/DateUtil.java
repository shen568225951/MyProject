package com.fh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Long createIdByDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(date);
        return Long.parseLong(format);
    }

}
