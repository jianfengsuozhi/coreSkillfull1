package com.web.test;

import com.utils.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static com.utils.DateUtils.MILLISECONDS_OF_ONE_DAY;
import static com.utils.DateUtils.dateFormatDay1;

/**
 * Created by weideliang on 2017/3/2.
 */
public class TestDate {
    public static int getIntervalDays(Date fDate, Date oDate) {

        if (null == fDate || null == oDate) {

            return -1;

        }

        long intervalMilli = oDate.getTime() - fDate.getTime();

        return (int) (intervalMilli / (24 * 60 * 60 * 1000));

    }

    public static int daysOfTwo(Date fDate, Date oDate) {

        Calendar aCalendar = Calendar.getInstance();

        aCalendar.setTime(fDate);

        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);

        aCalendar.setTime(oDate);

        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

        return day2 - day1;
    }

    public static int daysBetween(Date from, Date to) {

        if (from == null || to == null)
            throw new IllegalArgumentException("参数都不能为null");
        try {
            from = dateFormatDay1.parse(dateFormatDay1.format(from));
            to = dateFormatDay1.parse(dateFormatDay1.format(to));
        } catch (ParseException e) {
            // 不会产生异常
        }
        System.out.println(to.getTime() - from.getTime());
        System.out.println((int)(to.getTime() - from.getTime()));
        return ((int) (to.getTime() - from.getTime()) / MILLISECONDS_OF_ONE_DAY);
        // return (int)((to.getTime()+0.0-from.getTime())/MILLISECONDS_OF_ONE_DAY);//存在bug
    }

    public static void main(String[] args) {
//        int days1 = TestDate.daysOfTwo(new Date(), DateUtils.strToDate("2017-05-01","yyyy-MM-dd"));
//        System.out.println(days1);
//
//        int days2 = TestDate.getIntervalDays(new Date(), DateUtils.strToDate("2017-05-01","yyyy-MM-dd"));
//        System.out.println(days2);

        int days3 = TestDate.daysBetween(new Date(), DateUtils.strToDate("2017-05-01","yyyy-MM-dd"));
        System.out.println(days3);
    }
}
