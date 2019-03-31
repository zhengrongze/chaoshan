package com.mc.utils.execl;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName Utils
 * @Author ZhengRongZe
 * @Date 2019/2/24 19:20
 **/
public class TimeUtils {
    public static String getYearWithMonth(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        return year + "." + month;
    }
}
