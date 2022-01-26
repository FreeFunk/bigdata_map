package com.edgedo.util;

import java.text.SimpleDateFormat;
import java.util.Date; /**
 * @author WangZhen
 * @description
 * @date 2020/2/28
 */
public class DateUtil {


    public static String formatYmdDate(Date time) {
        SimpleDateFormat sdfYmd = new SimpleDateFormat("yyyy-MM-dd");
        return sdfYmd.format(time);
    }
}
