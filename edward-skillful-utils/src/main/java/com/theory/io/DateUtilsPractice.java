package com.theory.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by weideliang on 2017/3/20.
 */
public class DateUtilsPractice {
    public static void main(String[] args) throws ParseException {
        DateUtilsPractice practice = new DateUtilsPractice();
        //1 str-->date date-->str
//        String format = practice.format(new Date(), "yyyy-MM-dd");
//        String week = practice.getWeek(); 星期二
//        Date parse = practice.parse(format, "yyyy-MM-dd");
        //2 开始时间和结束时间(年月日,时分秒毫秒)
//        Date startOfDay = practice.getStartOfDay(new Date());
//        Date endOfDay = practice.getEndOfDay(new Date());
//        int monthDays = practice.getMonthDays(new Date());
//        Date startOfMonth = practice.getStartOfMonth(new Date());
//        Date endOfMonth = practice.getEndOfMonth(new Date());
        //3 增加 时间点之差
//        Date date = practice.addDate(new Date(), 12);//04-01
//        int days = practice.betweenDays(new Date(), practice.addDate(new Date(), 1));//1
    }

    public String format(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);//精度的损失
    }

    /**
     * 获取星期
     * @return
     */
    public String getWeek(){
        return this.format(new Date(), "E");
    }

    public Date parse(String dateStr,String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateStr);//精度不够,补零 sdf的格式和字符串的格式要相同,否则报不可转换异常
    }

    /**
     * 获取一天的开始时间 00:00:00:000
     * @param date
     * @return
     */
    public Date getStartOfDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }

    /**
     * 获取一天的结束时间 59:59:59:999
     * @param date
     * @return
     */
    public Date getEndOfDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,1);//日 +1 dayof主要是获取第级天 如getMonthDays
        return new Date(this.getStartOfDay(calendar.getTime()).getTime() - 1);
    }

    /**
     * 这个月的第几天
     * @param date
     * @return
     */
    public int getMonthDays(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取一个月的第一天
     * @param date
     * @return
     */
    public Date getStartOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return this.getStartOfDay(calendar.getTime());
    }

    /**
     * 获取一个月的最后一天
     * @param date
     * @return
     */
    public Date getEndOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return this.getEndOfDay(calendar.getTime());
    }

    /**
     * 增加时间
     * @param date
     * @param days
     * @return
     */
    public Date addDate(Date date,int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 时间点之差
     * @param from
     * @param to
     * @return
     */
    public int betweenDays(Date from,Date to){
        long fromTime = from.getTime();
        long toTime = to.getTime();
        return (int) ((toTime - fromTime) / (24 * 60 * 60 * 1000));
    }



}
