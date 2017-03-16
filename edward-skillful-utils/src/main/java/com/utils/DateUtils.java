
package com.utils;

import com.google.common.base.Objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 日期工具类
 */
public final class DateUtils {
    
    private static final Pattern PTN_YYYYMMDD = Pattern.compile("^\\s*[1-9]\\d{3}(0?[1-9]|1[0-2])(0?[1-9]|[1-2][0-9]|3[0-1])\\s*$");
    
    public static final SimpleDateFormat dateFormatCST = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy", Locale.US);
    public static final String DATE_FORMAT_MINITE2 = "yyyy-MM-dd HH:mm";
    public static final SimpleDateFormat dateFormatMinute2 = new SimpleDateFormat(DATE_FORMAT_MINITE2);
    
    public static final String DATE_FORMAT_SECONDE2 = "yyyy-MM-dd HH:mm:ss";
    public static final SimpleDateFormat dateFormatSecond2 = new SimpleDateFormat(DATE_FORMAT_SECONDE2);
    
    public static final String DATE_FORMAT_HOUR2 = "yyyy-MM-dd HH:00";
    public static final SimpleDateFormat dateFormatHour2 = new SimpleDateFormat(DATE_FORMAT_HOUR2);
    
    public static final String DATE_FORMAT_DAY2 = "yyyy-MM-dd";
    public static final SimpleDateFormat dateFormatDay2 = new SimpleDateFormat(DATE_FORMAT_DAY2);
    
    public static final String DATE_FORMAT_MINITE1 = "yyyy/MM/dd HH:mm";
    public static final SimpleDateFormat dateFormatMinute1 = new SimpleDateFormat(DATE_FORMAT_MINITE1);
    
    public static final String DATE_FORMAT_SECONDE1 = "yyyy/MM/dd HH:mm:ss";
    public static final SimpleDateFormat dateFormatSecond1 = new SimpleDateFormat(DATE_FORMAT_SECONDE1);
    
    public static final String DATE_FORMAT_HOUR1 = "yyyy/MM/dd HH:00";
    public static final SimpleDateFormat dateFormatHour1 = new SimpleDateFormat(DATE_FORMAT_HOUR1);
    
    public static final String DATE_FORMAT_DAY1 = "yyyy/MM/dd";
    public static final SimpleDateFormat dateFormatDay1 = new SimpleDateFormat(DATE_FORMAT_DAY1);
    
    public static final String DATE_FORMAT_DAY3 = "yyyyMMdd";
    public static final SimpleDateFormat dateFormatDay3 = new SimpleDateFormat(DATE_FORMAT_DAY3);

    public static final String DATE_FORMAT_DAY4 = "yyyy年MM月dd日";


    public static final int MILLISECONDS_OF_ONE_DAY = 24 * 60 * 60 * 1000;
    
    /**
     * 
     * 验证字符串是否是YYYYMMDD格式
     * 
     * @author liufei
     * @date 2016年6月13日 下午5:17:11
     * 
     * @param str
     * @return
     */
    public static boolean valiYYYYMMDD(String str)
    {
    
        if (str == null)
            return Boolean.FALSE;
        
        return PTN_YYYYMMDD.matcher(str).find();
    }

    /**
     * 将日期格式化为字符串
     *
     * @param obj
     * @param dateFormat
     * @return
     */
    public static String date2Str(Date obj, String dateFormat) {

        if (null == obj || null == dateFormat)
            return "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(obj);
    }

    public static String date2Str(Date obj) {

        return date2Str(obj, DATE_FORMAT_DAY2);
    }


    /**
     * 按照默认格式yyyy/MM/dd 将字符串转换成日期
     * 
     * @param strDate
     *            字符串格式日期
     * @return
     */
    public static Date strToDate(String strDate) {
    
        return strToDate(strDate, DATE_FORMAT_DAY1);
    }
    
    /**
     * @param strDate
     * @param strFormat
     * @return
     * @throws ParseException
     */
    
    public static Date strToDate(String strDate, String strFormat) {
    
        if (null == strDate || strDate.isEmpty())
            return null;
        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    /**
     * @param objDate
     * @return
     * @throws Exception
     */
    public static Date objToDate(Object objDate) throws Exception {
    
        String dateString = objDate.toString();
        return dateFormatDay1.parse(dateString);
    }
    
    /**
     * @param objDate  YYYY-MM-DD
     * @return
     * @throws Exception
     */
    public static Date objToDateX(Date objDate) throws Exception {
        String dateString = objDate.toString();
        return dateFormatDay2.parse(dateString);
    }


    /**
     * @param objDate
     * @return
     * @throws Exception
     */
    public static Date objToFullDate(Object objDate) throws Exception {
    
        String dateString = objDate.toString();
        return dateFormatSecond1.parse(dateString);
    }
    
    /**
     * 使用默认短日期格式：yyyy/MM/dd
     * 
     * @param iDate
     * @return
     */
    public static String format(Date iDate) {
    
        if (null == iDate)
            return "";
        
        return dateFormatDay1.format(iDate);
    }
    
    /**
     * 使用默认长日期格式：yyyy/MM/dd HH:mm
     */
    public static String formatX(Date iDate) {
    
        return dateFormatMinute1.format(iDate);
    }
    
    /**
     * 使用默认长日期格式：yyyy/MM/dd HH:mm:ss
     */
    public static String formatXx(Date iDate) {
    
        return dateFormatSecond1.format(iDate);
    }
    
    /**
	 * 
	 * 默认格式 yyyy-MM-dd
	 *
	 * @author vinfer
	 * @version v2.2.0
	 * @date 2014-9-12 下午2:22:28
	 *
	 * @param iDate
	 * @return
	 */
	public static String formatDate(Date iDate){
	    return dateFormatDay2.format(iDate);
	}
    /**
     * @param iDate
     * @param strFormat
     * @return
     */
    public static String format(Date iDate, String strFormat) {
    
        if (null == iDate)
            return "";
        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        return format.format(iDate);
    }
    
    /**
     * @param idate
     * @param strFormat
     * @return
     * @throws ParseException
     */
    public static Date formatDateToDate(Date idate, String strFormat)
            throws ParseException {
    
        String ddate = null;
        ddate = format(idate);
        return strToDate(ddate, strFormat);
    }
    
    /**
     * @param idate
     * @return
     * @throws ParseException
     */
    public static Date formatToDefaultDate(Date idate) throws ParseException {
    
        String ddate = null;
        ddate = format(idate);
        return strToDate(ddate, DATE_FORMAT_DAY1);
    }
    
    /**
     * 将CST的时间字符串转换成需要的日期格式字符串<br>
     * 
     * @param cststr
     *            The source to be dealed with. <br>
     *            (exp:Fri Jan 02 00:00:00 CST 2009)
     * @param fmt
     *            The format string
     * @return string or <code>null</code> if the cststr is unpasrseable or is
     *         null return null,else return the string.
     * @author HitSnail
     */
    public static String getDateFmtStrFromCST(String cststr, String fmt) {
    
        if ((null == cststr) || (null == fmt)) {
            return null;
        }
        String str = null;
        SimpleDateFormat sdfy = new SimpleDateFormat(fmt.trim());
        try {
            str = sdfy.format(dateFormatCST.parse(cststr.trim()));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return str;
    }
    
    /**
     * 从指定日期变换
     * 
     * @param date
     *            指定日期
     * @param hour
     *            指定时
     * @param min
     *            指定分
     * @param sec
     *            指定秒
     * @return
     */
    public static Date getFromDate(Date date, int dayDiff, int hour, int min, int sec) {
    
        Calendar returnCal = Calendar.getInstance();
        returnCal.setTime(date);
        returnCal.add(Calendar.DAY_OF_YEAR, dayDiff);
        returnCal.set(Calendar.HOUR_OF_DAY, hour);
        returnCal.set(Calendar.MINUTE, min);
        returnCal.set(Calendar.SECOND, sec);
        returnCal.set(Calendar.MILLISECOND, 0);
        return returnCal.getTime();
    }
    
    /**
     * 获取当日凌晨时间
     */
    public static Date getToday() {
    
        Calendar cld = Calendar.getInstance();
        cld.set(Calendar.HOUR_OF_DAY, 0);
        cld.set(Calendar.MINUTE, 0);
        cld.set(Calendar.SECOND, 0);
        cld.set(Calendar.MILLISECOND, 0);
        return cld.getTime();
    }
    
    /**
     * 获取当日结束时刻23:59:59.999
     */
    public static Date getEndOfDay() {
    
        Calendar cld = Calendar.getInstance();
        cld.set(Calendar.HOUR_OF_DAY, 23);
        cld.set(Calendar.MINUTE, 59);
        cld.set(Calendar.SECOND, 59);
        cld.set(Calendar.MILLISECOND, 999);
        return cld.getTime();
    }
    
    /**
     * 获取距离现在指定天数的某天的开始时刻00:00:00.000
     * 
     * @param interval
     *            间隔
     * @return Date java.util.Date
     */
    public static Date getStartOfDay(int interval) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTimeInMillis(cld.getTimeInMillis() + interval * 24 * 60 * 60
                * 1000l);
        cld.set(Calendar.HOUR_OF_DAY, 0);
        cld.set(Calendar.MINUTE, 0);
        cld.set(Calendar.SECOND, 0);
        cld.set(Calendar.MILLISECOND, 0);
        return cld.getTime();
    }
    
    /**
     * 获取某天的开始时刻00:00:00.000
     * 
     * @param date
     *            需要获取天内的时间
     * @return Date java.util.Date
     */
    public static Date getStartOfDay(Date date) {
    
        if (null == date)
            return null;
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.set(Calendar.HOUR_OF_DAY, 0);
        cld.set(Calendar.MINUTE, 0);
        cld.set(Calendar.SECOND, 0);
        cld.set(Calendar.MILLISECOND, 0);
        return cld.getTime();
    }
    
    /**
     * 获取今天的开始时刻00:00:00.000
     * 
     * @return
     */
    public static Date getStartOfDay() {
    
        return getStartOfDay(new Date());
    }
    
    /**
     * 获取某天的最后时刻23:59:59.999
     * 
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date getStartOfDay(String strDate) {
    
        Date date = strToDate(strDate);
        return getStartOfDay(date);
    }
    
    /**
     * 获取距离现在指定天数的某天的结束时刻23:59:59.999
     * 
     * @param interval
     *            间隔
     * @return Date java.util.Date
     */
    public static Date getEndOfDay(int interval) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTimeInMillis(cld.getTimeInMillis() + interval * 24 * 60 * 60
                * 1000l);
        cld.set(Calendar.HOUR_OF_DAY, 23);
        cld.set(Calendar.MINUTE, 59);
        cld.set(Calendar.SECOND, 59);
        cld.set(Calendar.MILLISECOND, 999);
        return cld.getTime();
    }
    
    /**
     * 获取某天的最后时刻23:59:59.999
     * 
     * @param date
     *            需要获取天内的时间
     * @return Date java.util.Date
     */
    public static Date getEndOfDay(Date date) {
    
        if (null == date)
            return null;
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.set(Calendar.HOUR_OF_DAY, 23);
        cld.set(Calendar.MINUTE, 59);
        cld.set(Calendar.SECOND, 59);
        cld.set(Calendar.MILLISECOND, 999);
        return cld.getTime();
    }
    
    /**
     * 获取某天的最后时刻23:59:59.999
     * 
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date getEndOfDay(String strDate) {
    
        Date date = strToDate(strDate);
        return getEndOfDay(date);
    }
    
    /**
     * 获取距离现在指定星期数的某个星期的开始时刻00:00:00.000
     * 
     * @param interval
     *            间隔
     * @return Date java.util.Date
     */
    public static Date getStartOfWeek(int interval) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTimeInMillis(cld.getTimeInMillis() + interval * 7 * 24 * 60 * 60
                * 1000l);
        cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return getStartOfDay(cld.getTime());
    }
    
    /**
     * 获取指定星期的开始时刻00:00:00.000
     * 
     * @param week
     *            一年中的第几周
     * @param year
     *            年份
     * @return Date java.util.Date
     */
    public static Date getStartOfWeek(int year, int week) {
    
        Calendar cld = Calendar.getInstance();
        cld.set(Calendar.YEAR, year);
        cld.set(Calendar.WEEK_OF_YEAR, week);
        cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return getStartOfDay(cld.getTime());
    }
    
    /**
     * 获取距离指定日期指定星期数的某个星期的开始时刻00:00:00.000
     * 
     * @param interval
     *            间隔
     * @param date
     *            日期
     * @return Date java.util.Date
     */
    public static Date getStartOfWeek(Date date, int interval) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.setTimeInMillis(cld.getTimeInMillis() + interval * 7 * 24 * 60 * 60
                * 1000l);
        cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return getStartOfDay(cld.getTime());
    }
    
    /**
     * 获取指定时间所在周的第一天的00:00:00.000
     * 
     * @param date
     *            需要获取周的某天
     * @return Date java.util.Date
     */
    public static Date getStartOfWeek(Date date) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return getStartOfDay(cld.getTime());
    }
    
    /**
     * 获取距离现在指定周数的某周的最后时刻23:59:59.999
     * 
     * @param interval
     *            间隔
     * @return Date java.util.Date
     */
    public static Date getEndOfWeek(int interval) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTime(getStartOfWeek(interval + 1));
        return new Date(cld.getTimeInMillis() - 1);
    }
    
    /**
     * 获取指定周数的最后时刻23:59:59.999
     * 
     * @param week
     *            一年中的第几周
     * @param year
     *            年份
     * @return Date java.util.Date
     */
    public static Date getEndOfWeek(int year, int week) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTime(getStartOfWeek(year, week + 1));
        return new Date(cld.getTimeInMillis() - 1);
    }
    
    /**
     * 获取距离指定日期指定周数的某周的最后时刻23:59:59.999
     * 
     * @param interval
     *            间隔
     * @param date
     *            日期
     * @return Date java.util.Date
     */
    public static Date getEndOfWeek(Date date, int interval) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.setTime(getStartOfWeek(date, interval + 1));
        return new Date(cld.getTimeInMillis() - 1);
    }
    
    /**
     * 获取指定时间所在周的最后一天的23:59:59.999
     * 
     * @param date
     *            需要获取周的某天
     * @return Date java.util.Date
     */
    public static Date getEndOfWeek(Date date) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return getEndOfDay(cld.getTime());
    }
    
    /**
     * 获取指定时间所在月的第一天的00:00:00.000
     * 
     * @param date
     *            需要获取月的某天
     * @return Date java.util.Date
     */
    public static Date getStartOfMonth(Date date) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.set(Calendar.DAY_OF_MONTH, 1);
        return getStartOfDay(cld.getTime());
    }
    
    /**
     * 获取某年某月的开始时刻00:00:00.000
     * 
     * @param year
     *            年份
     * @param month
     *            月份
     * @return Date java.util.Date
     */
    public static Date getStartOfMonth(int year, int month) {
    
        Calendar cld = Calendar.getInstance();
        cld.set(Calendar.YEAR, year);
        cld.set(Calendar.MONTH, month);
        cld.set(Calendar.DAY_OF_MONTH, 1);
        return getStartOfDay(cld.getTime());
    }
    
    /**
     * 获取距离现在指定月数的某月的开始时刻00:00:00.000
     * 
     * @param interval
     *            间隔
     * @return Date java.util.Date
     */
    public static Date getStartOfMonth(int interval) {
    
        Calendar cld = Calendar.getInstance();
        int currentMonth = cld.get(Calendar.MONTH); // 这里得到的值是0～11
        cld.add(Calendar.YEAR, ((interval + currentMonth) / 12));
        cld.set(Calendar.MONTH, ((interval + currentMonth) % 12));
        cld.set(Calendar.DAY_OF_MONTH, 1);
        return getStartOfDay(cld.getTime());
    }
    
    /**
     * 获取指定时间所在月的最后一天的23:59:59.999
     * 
     * @param date
     *            需要获取月的某天
     * @return Date java.util.Date
     */
    public static Date getEndOfMonth(Date date) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        int maxDay = cld.getActualMaximum(Calendar.DAY_OF_MONTH);
        cld.set(Calendar.DAY_OF_MONTH, maxDay);
        return getEndOfDay(cld.getTime());
    }
    
    /**
     * 获取距离现在指定月数的某月的结束时刻23:59:59.999
     * 
     * @param interval
     *            间隔
     * @return Date java.util.Date
     */
    public static Date getEndOfMonth(int interval) {
    
        return new Date(getStartOfMonth(interval + 1).getTime() - 1);
    }
    
    /**
     * 获取某年某月的结束时刻23:59:59.999
     * 
     * @param year
     *            年份
     * @param month
     *            月份
     * @return Date java.util.Date
     */
    public static Date getEndOfMonth(int year, int month) {
    
        return new Date(getStartOfMonth(year, month + 1).getTime() - 1);
    }
    
    /**
     * 获取2个时间点之间的月份数
     * 
     * @param startDate
     *            endDate
     * @return int
     */
    public static int monthsBetween(Date startDate, Date endDate) {
    
        Calendar cld = Calendar.getInstance();
        cld.setTime(startDate);
        int startMonth = cld.get(Calendar.MONTH);
        int startYear = cld.get(Calendar.YEAR);
        cld.setTime(endDate);
        int endMonth = cld.get(Calendar.MONTH);
        int endYear = cld.get(Calendar.YEAR);
        return (endYear - startYear) * 12 + (endMonth - startMonth);
    }
    
    // /**
    // * 获取2个时间点之间的天数
    // *
    // * @param startDate
    // * endDate
    // * @return int
    // */
    // // //以下样本测试出下面的daysBetween函数有bug
    // // Date start=strToDate("2014/4/23", DATE_FORMAT_DAY1);
    // // Date end=strToDate("2014/5/1", DATE_FORMAT_DAY1);
    // // System.out.println(daysBetween(start,end));
    // public static int daysBetween(Date startDate, Date endDate) {
    // Calendar c1 = Calendar.getMaxInstance();
    // Calendar c2 = Calendar.getMaxInstance();
    // c1.setTime(startDate);
    // c2.setTime(endDate);
    // return daysBetween(c1, c2);
    // }
    //
    // public static int daysBetween(Calendar early, Calendar late) {
    // return (int) (toJulian(late) - toJulian(early));
    // }
    
    /**
     * 获取两个时间点之间（半开半闭区间）的天数。
     * 
     * @param from
     * @param to
     * @return
     */
    public static int daysBetween(Date from, Date to) {
    
        if (from == null || to == null)
            throw new IllegalArgumentException("参数都不能为null");
        try {
            from = dateFormatDay1.parse(dateFormatDay1.format(from));
            to = dateFormatDay1.parse(dateFormatDay1.format(to));
        } catch (ParseException e) {
            // 不会产生异常
        }
        return (int) (to.getTime() - from.getTime()) / MILLISECONDS_OF_ONE_DAY;
        // return (int)((to.getTime()+0.0-from.getTime())/MILLISECONDS_OF_ONE_DAY);//存在bug
    }

    public static void main(String[] args) {
        int days = DateUtils.daysBetween(new Date(), DateUtils.strToDate("2017/05/01", DATE_FORMAT_DAY1));
        System.out.println(days);
    }
    
    /**
     * 获取两个时间点之间（半开半闭区间）的天数。
     * 
     * @param from
     * @param to
     * @return
     */
    public static int daysBetween(Calendar from, Calendar to) {
    
        if (from == null || to == null)
            throw new IllegalArgumentException("参数都不能为null");
        return daysBetween(from.getTime(), to.getTime());
    }
    
    public static final float toJulian(Calendar c) {
    
        int Y = c.get(Calendar.YEAR);
        int M = c.get(Calendar.MONTH);
        int D = c.get(Calendar.DATE);
        int A = Y / 100;
        int B = A / 4;
        int C = 2 - A + B;
        float E = (int) (365.25f * (Y + 4716));
        float F = (int) (30.6001f * (M + 1));
        float JD = (C + D + E + F) - 1524.5f;
        return JD;
    }
    
    /**
     * 设置统计报表的统计时间周期
     * 
     * @param startDateStr
     *            开始日期，格式：2013/04/03
     * @param endDateStr
     *            结束日期，格式：2013/09/03
     * @return Date[]:<li>[0]-2013/04/03 00:00:00.000</li><li>[1]-2013/09/03 23:59:59.999</li>
     * @author tantao
     */
    public static Date[] getDateInterval(String startDateStr, String endDateStr) {
    
        Date startDate = Objects.firstNonNull(getStartOfDay(startDateStr),
                getStartOfDay(getDateOfLastMonth()));
        
        Date endDate = Objects.firstNonNull(getEndOfDay(endDateStr),
                getEndOfDay(new Date()));
        return new Date[] { startDate, endDate };
    }
    
    /**
     * 将某时间转换成该天24小时时间间隔
     * 
     * @param date
     * @return
     */
    public static Date[] getDateInterval(Date date) {
    
        return new Date[] { getStartOfDay(date), getEndOfDay(date) };
    }
    
    /**
     * 根据出生日期获得年龄
     * 
     * @param birthday
     * @return 年龄，传入参数为null时则返回null
     */
    public static Integer getAge(Date birthday) {
    
        if (null == birthday)
            return null;
        Calendar calNow = Calendar.getInstance();
        calNow.setTime(new Date());
        
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthday);
        
        int result = 0;
        int yearSub = calNow.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (calNow.get(Calendar.MONTH) > birth.get(Calendar.MONTH)) {
            result = yearSub;
        } else if (calNow.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
            if (calNow.get(Calendar.DAY_OF_MONTH) >= birth.get(Calendar.DAY_OF_MONTH))
                result = yearSub;
            else
                result = yearSub - 1;
        } else {
            result = yearSub - 1;
        }
        return result;
    }
    
    /**
     * 根据年龄计算出生年月(日期为今天).注意：<br/>
     * <i>age为null或负数，返回空</i>
     * 
     * @param age
     * @return
     * @author tantao
     * @version v2.0.9
     * @date 2014-7-8 上午10:38:54
     */
    public static Date getBirthFromToday(Integer age) {
    
        if (null == age || age < 0)
            return null;
        
        Calendar calNow = Calendar.getInstance();
        calNow.setTime(new Date());
        calNow.add(Calendar.YEAR, -age);
        return calNow.getTime();
    }
    
    /**
     * 日期相加
     * 
     * @param date
     *            ,day
     * @return 返回相加后的日期
     */
    public static Date addDate(Date date, Integer day) {
    
        if (null == day)
            day = 0;
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.setTimeInMillis(cld.getTimeInMillis() + ((long) day) * MILLISECONDS_OF_ONE_DAY);
        return cld.getTime();
    }
    
    /**
     * 取得从startDate开始的前(正)/后(负)day天
     * 
     * @param startDate
     * @param day
     * @return
     */
    public static Date getRelativeDay(Date startDate, int day) {
    
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
    
    /**
     * 取得从startDate开始的前(正)/后(负)月的时间
     * 
     * @param startDate
     * @return
     */
    public static Date getRelativeMonth(Date startDate, int month) {
    
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }
    
    
    /**
     * 取得从startDate开始的前(正)/后(负)day分钟
     * 
     * @param startDate
     * @return
     */
    public static Date getRelativeMinute(Date startDate, int minute) 
    {
    
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }
    
    /**
     *
     * 加多少个月
     * 
     * @author liufei
     * @date 2016年6月27日 上午11:13:44
     * 
     * @param date
     * @param month
     * @return
     */
    public static Date addMonth(Date date, Integer month) {
    
        if (date == null)
            return null;
        
        if (null == month)
            month = 0;
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.add(Calendar.MONTH, month);
        return cld.getTime();
    }
    
    /**
     * 获取当前日期时间
     * 
     * @return 返回现在日期时间
     */
    public static String getFullCurDate() {
    
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_SECONDE1);
        return formatter.format(new Date());
    }
    
    public static String GetNowShortDate() {
    
        Date dt = new Date();
        return format(dt);
        
    }
    
    // tantao
    private static int getYearPlus() {
    
        Calendar cd = Calendar.getInstance();
        int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);// 获得当天是一年中的第几天
        cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
        cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
        int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
        if (yearOfNumber == 1) {
            return -MaxYear;
        } else {
            return 1 - yearOfNumber;
        }
    }
    
    // 获得本年第一天的日期
    public static Date getCurrentYearFirst() {
    
        Calendar cld = Calendar.getInstance();
        int year = cld.get(Calendar.YEAR);
        return getStartOfMonth(year, 0);
    }
    
    public static String getCurrentYearFirstFmt(String strFormat) {
    
        return format(getCurrentYearFirst(), strFormat);
    }
    
    /**
     * 获取上个月的今天
     * 
     * @return
     */
    public static Date getDateOfLastMonth() {
    
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, -1);
        return lastDate.getTime();
    }
    
    /**
     * 获得当前系统时间
     */
    public static Date now() {
    
        return new Date();
    }
    
    /**
     * 比较两个时间的大小
     * 
     * @return 返回正数则后者比前者大，反之则后者比前者小，0则相等
     */
    public static int beforeOrAfter(Date one, Date two) {
    
        if (null == one && null == two)
            return 0;
        if (null == one && null != two)
            return -1;
        if (null == two && null != one)
            return 1;
        if (two.getTime() - one.getTime() > 0)
            return 1;
        if (two.getTime() - one.getTime() < 0)
            return -1;
        return 0;
    }
    
    /**
     * 
     * @Description: 获取几个月之后的今天
     * @author: liuwei
     * @version: v3.0.0
     * @date: 16-6-24 下午2:31
     * @return: Date
     */
    public static String getAfterMonthsToday(Date today, Integer months) {
    
        if (today == null || months == null) {
            return null;
        }
        Calendar cld = Calendar.getInstance();
        cld.add(Calendar.MONTH, months);
        return dateFormatDay2.format(cld.getTime());
    }
}
