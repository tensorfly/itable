package com.chinaso.behavior.Util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fangqian
 * @date 2018/6/28 13:55
 */
public class DateAndTimeUtil {
    /*
     * 获取系统当前时间
     */
    public static String  getStringCurrentTime(){
        Date time=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(time);
    }

    /*
     * 获取系统当前时间三分钟之前的时间
     */
    public static String  getStringBeforeCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, -3);// 3分钟之前的时间
        Date beforeD = beforeTime.getTime();
        return sdf.format(beforeD);
    }

    public static String strFormatTimetamp(String str){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setLenient(false);
        try {
            Timestamp ts = new Timestamp(format.parse(str).getTime());
            return ts.toString();
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }


    public static String getSringBefore(String time){
        long t = 1*60*1000;//1分钟

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(time);
            Date dateBefore = new Date(date.getTime() - t);
            return  sdf.format(dateBefore);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
