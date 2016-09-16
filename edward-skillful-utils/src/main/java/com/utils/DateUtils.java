package com.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期函数类
 *
 * @author tianzhonghong
 *
 */
public class DateUtils {

	public static final String DAY = "yyyy-MM-dd";
	public static final String DATE_WITH_SECOND = "yyyy-MM-dd HH:mm:ss";
	private static String dateFormatStr = "yyyyMMdd";

    public static int getAge(Date birthDate) {
        return getAgeByBirth(birthDate);
    }

    /**
     *
     * 根据出生日期计算年龄（精确到天）
     *
     * @author tianzhonghong
     * @version v2.0.7
     * @date 2014年3月28日 下午4:10:14
     *
     * @param birthDate
     * @return
     */
    public static int getAgeByBirth(Date birthDate) {

        if (null == birthDate)
            return 0;
        Calendar calNow = Calendar.getInstance();
        calNow.setTime(new Date());

        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);

        int result = 0;
        int yearSub = calNow.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (calNow.get(Calendar.MONTH) > birth.get(Calendar.MONTH)) {
            result = yearSub;
        } else if (calNow.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
            if (calNow.get(Calendar.DAY_OF_MONTH) >= birth.get(Calendar.DAY_OF_MONTH)) {
                result = yearSub;
            }
            else {
                result = yearSub - 1;
            }
        } else {
            result = yearSub - 1;
        }
        return result;
    }

    /**
     *
     * 根据年龄和给定的日期计算出出生日期
     *
     * @author tianzhonghong
     * @version v2.0.6
     * @date 2014年3月11日 下午7:49:55
     *
     * @param age
     * @param originBirthDate
     * @return
     */
    public static Date getBirth(int age, Date originBirthDate) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR) - age;
        cal.setTime(originBirthDate);
        cal.set(Calendar.YEAR, year);
        return cal.getTime();
    }

    /**
     * @param objDate
     * @return
     * @throws Exception
     */
    public static Date objToFullDate(Object objDate) throws Exception {

        String dateString = objDate.toString();
        SimpleDateFormat format = new SimpleDateFormat(DATE_WITH_SECOND);
        return format.parse(dateString);
    }

    /**
     * @param objDate
     * @return
     * @throws Exception
     */
    public static Date objToDate(Object objDate) {

        String dateString = objDate.toString();
        SimpleDateFormat format = new SimpleDateFormat(DAY);
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date strtoDate(String datestr) {

        Date date = null;
        try {
            date = objToFullDate(datestr);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return date;
    }

    /**
     * 把"2012-12-1 00:00"转化为date
     *
     * @date 2013-06-27
     * */
    public static Date fixedStrtoDate(String datestr) {

        datestr = datestr + ":00";
        Date date = null;
        try {
            date = objToFullDate(datestr);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前日期时间
     *
     * @return 返回现在日期时间
     */
    public static Date getCurDate() {

        // SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日   HH:mm:ss     ");
        Date curDate = new Date(System.currentTimeMillis());
        // String str = formatter.format(curDate);
        return curDate;
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
     * 获取某天的开始时刻00:00:00.000
     *
     * @param date
     *            需要获取天内的时间
     * @return Date java.util.Date
     */
    public static Date getStartOfDay(Date date) {

        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.set(Calendar.HOUR_OF_DAY, 0);
        cld.set(Calendar.MINUTE, 0);
        cld.set(Calendar.SECOND, 0);
        cld.set(Calendar.MILLISECOND, 0);
        return cld.getTime();
    }

    /**
     * 获取距离现在指定天数的某天的开始时刻00:00:00.000
     *
     * @param interval
     *            间隔
     * @return Date java.util.Date
     *
     */
    public static Date getStartOfDay(int interval) {

        Calendar cld = Calendar.getInstance();
        cld.setTimeInMillis(cld.getTimeInMillis() + interval * 24 * 60 * 60 * 1000L);
        cld.set(Calendar.HOUR_OF_DAY, 0);
        cld.set(Calendar.MINUTE, 0);
        cld.set(Calendar.SECOND, 0);
        cld.set(Calendar.MILLISECOND, 0);
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

        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.set(Calendar.HOUR_OF_DAY, 23);
        cld.set(Calendar.MINUTE, 59);
        cld.set(Calendar.SECOND, 59);
        cld.set(Calendar.MILLISECOND, 999);
        return cld.getTime();
    }

    /**
     * 日期相加
     *
     * @param date
     *            ,day
     * @return 返回相加后的日期
     */
    public static Date addDate(Date date, int day) {

        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.setTimeInMillis(cld.getTimeInMillis() + ((long) day) * 24 * 3600 * 1000);
        return cld.getTime();
    }
	/**
	 * 日期相加
	 *
	 * @param date
	 *            ,day
	 * @return 返回相加后的日期
	 */
	public static Date addSecend(Date date, int secends) {

		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.setTimeInMillis(cld.getTimeInMillis() + ((long) secends) * 1000);
		return cld.getTime();
	}

    /**
     * 日期转成字符串
     *
     * @param date
     * @return
     */
    public static String toDateTimeStr(Date date) {

        return toStr(DATE_WITH_SECOND, date);
    }

    public static String toStr(String format, Date date) {

        String str = "";
        try {
            str = (new SimpleDateFormat(format)).format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * @param iDate
     * @return
     */
    public static String format(Date iDate) {

        SimpleDateFormat format = new SimpleDateFormat(DAY);
        return format.format(iDate);
    }

    /**
     * @param iDate
     * @return
     */
    public static String formatToStr(Date iDate) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(iDate);
    }

    /**
     * @param idate
     * @return
     */
    public static Date formatToDefaultDate(Date idate) {

        String ymd = DAY;
        SimpleDateFormat sdf = new SimpleDateFormat(ymd);
        Date day = null;
        try {
            day = DateUtils.strToDate(sdf.format(idate), ymd);
        } catch (ParseException e) {
            // 永远不会发生
        }
        return day;
    }

    /**
     * @param strDate
     * @param strFormat
     * @return
     * @throws ParseException
     */

    public static Date strToDate(String strDate, String strFormat) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        return format.parse(strDate);
    }

    /**
     * 比较两个日期相差的天数
     *
     * @author chenjun
     * @param beginDate
     *            开始时间
     * @param endDate
     *            结束时间
     * @return 两个日期的时间差
     * @since v2.0
     */
    public static int diffOfDay(Date beginDate, Date endDate) {

        long end = endDate.getTime();
        long begin = beginDate.getTime();
        long time = (end - begin) / (1000 * 60 * 60 * 24);
        return (int) time;
    }

    /**
     * 比较日期是否相等
     *
     * @author chenjun
     * @param date1
     *            开始日期
     * @param date2
     *            结束日期
     * @return
     * @since v2.0
     */
    public static boolean compareDate(Date date1, Date date2) {

        return DateUtils.toStr(DAY, date1).equals(DateUtils.toStr(DAY, date2));
    }

    /**
     * 获取当月的第一天
     *
     * @author oufengfang
     * @date 2013-12-19 下午2:12:04
     *
     * @return
     */
    public static Date getFirstDayOfMonth() {

        Calendar firstDate = Calendar.getInstance();
        firstDate.set(Calendar.DATE, 1);// 设为当前月的1号
        return firstDate.getTime();
    }

    /**
     * 取得从startDate开始的前(正)/后(负)day天
     *
     * @param startDate
     * @param day
     * @return
     */
    public static Date getRelativeDate(Date startDate, int day) {

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(startDate);
            calendar.add(Calendar.DAY_OF_MONTH, day);
            return calendar.getTime();
        } catch (Exception e) {
            return startDate;
        }
    }

    public static String getDateFormat(Date date) {

        return format(date, dateFormatStr);
    }

    /**
     * @param iDate
     * @param strFormat
     * @return
     */
    public static String format(Date iDate, String strFormat) {

        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        return format.format(iDate);
    }

    /**
     * 根据日期获取星期几
     *
     * @param date
     *            java.util.Date对象,不能为null
     * @return
     */
    public static int getDay(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     *
     * 返回星期几
     *
     * @author jinzhaokang
     * @version v2.2.1
     * @date 2014年8月21日 下午4:21:14
     *
     * @param dayOfWeek
     * @return
     */
    public static String getWeek(int dayOfWeek){

        String week = "";
        switch(dayOfWeek){
            case 1:
                week = "一";
                break;
            case 2:
                week = "二";
                break;
            case 3:
                week = "三";
                break;
            case 4:
                week = "四";
                break;
            case 5:
                week = "五";
                break;
            case 6:
                week = "六";
                break;
            case 7:
                week = "日";
                break;
            case 0:
                week = "日";
                break;
        }
        return week;
    }

    /**
     * 获取某月的第一天，或最后一天
     *
     * @param date
     *            Date
     * @param flag
     *            boolean true为第一天 false为最后一天
     * @return String
     */
    public static final Date getDateByMonth(Date date, boolean flag) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int i = 0;
        if (flag) {
            i = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        } else {
            i = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }

        cal.set(Calendar.DAY_OF_MONTH, i);
        return cal.getTime();

    }

    public static final Date getLastMonth(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);

        return cal.getTime();

    }

    public static void main(String args[]) {

        String date = format(new Date(), "MM");
        // Date beginDate = DateUtils.getDateByMonth(date,true);
        System.out.println("-----" + date);
        // Date endDate = DateUtils.getDateByMonth(date,false);

        // System.out.println(format(endDate));
        // System.out.println(getDay(date));

    }

    /**
     * 获取当前时间属于上午还是下午
     *
     * @author oufengfang
     * @version v2.1.6
     * @date 2015年7月23日 下午2:13:53
     *
     * @param time
     * @return true 上午 false 下午
     */
    public static Boolean getAmPm(Date time) {

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(time);
        return Calendar.AM == cal.get(Calendar.AM_PM);
    }
}

