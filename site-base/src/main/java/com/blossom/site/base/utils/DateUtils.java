package com.blossom.site.base.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Blossom
 * @Description 时间工具类
 * @time 2017/3/8 11:10
 */
public class DateUtils {


    public final static String FORMAT_SHORT = "yyyy-MM-dd";

    public final static String FORMAT_MIDDLE = "yyyy-MM-dd HH:mm";

    public final static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    public final static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    public final static String FORMAT_SHORT_CN = "yyyy年MM月dd";

    public final static String FORMAT_MONTH_CN = "yyyy年MM月dd日  HH时mm分";

    public final static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    public final static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    public final static String FORMAT_YYYY = "yyyy";

    public final static String FORMAT_MM = "MM";

    public final static String FORMAT_DD = "dd";

    /**
     * 根据预设格式返回当前日期
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @return
     */
    public static String getNow() {
        return format(new Date());
    }

    /**
     * 根据用户格式返回当前日期
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @param format
     *            日期格式
     * @return
     */
    public static String getNow(String format) {
        return format(new Date(), format);
    }

    /**
     * 使用预设格式格式化日期
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @param date
     *            日期
     * @return
     */
    public static String format(Date date) {
        return format(date, FORMAT_LONG);
    }

    /**
     * @description 得到当前日期
     * @author Blossom
     * @DateTime 2017/3/8 14:12
     * @param
     */
    public static Date format(){
        return parse(format(new Date()));
    }

    /**
     * 使用用户格式格式化日期
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @param date
     *            日期
     * @param pattern
     *            日期格式
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.format(date);
        }
        return null;
    }

    /**
     * 使用预设格式提取字符串日期
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param strDate
     *            日期字符串
     * @return
     */
    public static Date parse(String strDate) {
        return parse(strDate, FORMAT_LONG);
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param strDate
     *            日期字符串
     * @param pattern
     *            日期格式
     * @return
     */
    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在日期上面增加整数年
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param date
     * 			日期
     * @param number
     * 			增加的年数
     * @return
     */
    public static Date addYear(Date date,int number){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, number);
        return calendar.getTime();
    }

    /**
     * 在日期上面增加整数个月
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param date
     *            日期
     * @param number
     *            增加的月数
     * @return
     */
    public static Date addMonth(Date date, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, number);
        return calendar.getTime();
    }

    /**
     * 在日期上面增加天数
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param date
     *            日期
     * @param number
     *            增加的天数
     * @return
     */
    public static Date addDay(Date date, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, number);
        return calendar.getTime();
    }

    /**
     * 获取时间戳
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @return
     */
    public static String getTimeString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_FULL);
        Calendar calendar = Calendar.getInstance();
        return simpleDateFormat.format(calendar.getTime());
    }

    /**
     * 获取日期年份
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @param date
     *            日期
     * @return
     */
    public static String getYear(Date date) {
		/*
		 * SimpleDateFormat simpleDateFormat = new
		 * SimpleDateFormat(FORMAT_YYYY); return simpleDateFormat.format(date);
		 */
        return format(date, FORMAT_YYYY);
    }

    /**
     * 获取当前年份
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @return
     */
    public static String getNowYear() {
        return getYear(new Date());
    }

    /**
     * 获取月份
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @param date
     *            日期
     * @return
     */
    public static String getMonth(Date date) {
		/*
		 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_MM);
		 * return simpleDateFormat.format(date);
		 */
        return format(date, FORMAT_MM);
    }

    /**
     * 获取当前月份
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @return
     */
    public static String getNowMonth() {
        return getMonth(new Date());
    }

    /**
     * 获取日期中的日
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @param date
     *            日期
     * @return
     */
    public static String getDay(Date date) {
		/*
		 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DD);
		 * return simpleDateFormat.format(date);
		 */
        return format(date, FORMAT_DD);
    }

    /**
     * 获取当前日期当中的日
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @return
     */
    public static String getNowDay() {
        return getDay(new Date());
    }

    /**
     * 按照默认格式的字符串距离今天的天数
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type int
     * @param date
     *            日期字符串
     * @return
     */
    public static int countDays(String date) {
        long longCurrTime = Calendar.getInstance().getTime().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse(date));
        long longTime = calendar.getTime().getTime();

        return (int) (longCurrTime - longTime) / 1000 / 3600 / 24;
    }

    /**
     * 按照指定格式返回距离的天数
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type int
     * @param date
     *            日期字符串
     * @param format
     *            日期格式字符串
     * @return
     */
    public static int countDays(String date, String format) {
        long longCurrTime = Calendar.getInstance().getTime().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse(date, format));
        long longTime = calendar.getTime().getTime();

        return (int) (longCurrTime - longTime) / 1000 / 3600 / 24;
    }

    /**
     * 将sql时间对象转换成字符串
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @param timestamp
     *            sql时间
     * @param format
     *            日期格式
     * @return
     */
    public static String timestampToString(Timestamp timestamp, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(timestamp);
    }

    /**
     * 将Date类型转换为Timestamp类型
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Timestamp
     * @param date
     *            日期
     * @return
     */
    public static Timestamp dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 获取时间的时间戳
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type long
     * @param dateStr
     *            日期字符串
     * @param format
     *            日期格式
     * @return
     */
    public static long getTimeStamp(String dateStr, String format) {
        Date date = parse(dateStr, format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 指定时间距离当前时间的中文信息
     *
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @param date
     *            日期
     * @return
     */
    public static String getLnow(Date date) {
        long longTime = getTimeStamp(date + "", FORMAT_FULL_CN);
        Calendar calendar = Calendar.getInstance();
        long longCurrTime = calendar.getTimeInMillis();
        long longDiffTime = longCurrTime - longTime;
        String message = "";
        if (longDiffTime / 1000 < 60) {
            message = "1分钟以内";
        } else if (longDiffTime / 1000 / 60 < 60) {
            message = longDiffTime / 1000 + "分钟前";
        } else if (longDiffTime / 1000 / 60 / 60 < 24) {
            message = longDiffTime / 1000 / 60 + "小时前";
        } else {
            message = longDiffTime / 1000 / 60 / 60 / 24 + "天前";
        }

        return message;
    }

    /**
     * 下一周的日期
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param date
     * @return
     */
    public static Date nextWeek(Date date){
        return addDay(date, 7);
    }

    /**
     * 获取本周日的日期
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param date
     * @return
     */
    public static Date getSunday(Date date){
        return addDay(date, 6);
    }

    /**
     * 获取下一个月的日期
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param date
     * @return
     */
    public static Date nextMonth(Date date){
        return addMonth(date, 1);
    }

    /**
     * 获取下一年的信息
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param date
     * @return
     */
    public static Date nextYear(Date date){
        return addYear(date, 1);
    }

    /**
     * 获取日期为该月的第几周
     * @author Blossom
     * @time 2016年8月29日
     * @return_type int
     * @param date
     * 			日期
     * @return
     */
    public static int getWeekInMonthNum(Date date){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取指定日期的本周第一天
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param date
     * 			指定日期
     * @return
     */
    public static Date firstDayOfWeek(Date date){
        int intYear = Integer.parseInt(getYear(date));
        int intMonth = Integer.parseInt(getMonth(date));
        int intDay = Integer.parseInt(getDay(date));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, intYear);
        calendar.set(Calendar.MONTH, intMonth -1);
        calendar.set(Calendar.DAY_OF_MONTH, intDay);
        calendar.getTime();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        return calendar.getTime();
    }

    /**
     * 获取指定日期的本周的最后一天
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param date
     * @return
     */
    public static Date lastDayOfWeek(Date date){
        int intYear = Integer.parseInt(getYear(date));
        int intMonth = Integer.parseInt(getMonth(date));
        int intDay = Integer.parseInt(getDay(date));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, intYear);
        calendar.set(Calendar.MONTH, intMonth -1);
        calendar.set(Calendar.DAY_OF_MONTH, intDay);
        calendar.getTime();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        return getSunday(calendar.getTime());
    }

    /**
     * 获取本月的第一天
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @param date
     * 			本月日期
     * @return
     */
    public static String firstDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);

        //当月的第一天
        calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
        Date benginTime = calendar.getTime();

        return format(benginTime, FORMAT_FULL);
    }

    /**
     * 获取本月的最后一天
     * @author Blossom
     * @time 2016年8月29日
     * @return_type String
     * @param date
     * @return
     */
    public static String lastDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.DATE, -1);
        Date endTime = calendar.getTime();
        return format(endTime,FORMAT_FULL);
    }

    /**
     * 获取当前星期数字
     * @author Blossom
     * @time 2016年8月29日
     * @return_type int
     * @param date
     * @return
     */
    public static int getNowWeekNum(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        return weekDay==1?7:weekDay - 1;
    }

    /**
     * 根据星期和时刻获取当前周的相应时间日期
     * @author Blossom
     * @time 2016年8月29日
     * @return_type Date
     * @param week
     * @param time
     * @return
     */
    public static Date getNowWeekDate(int week,int time){
        int intMondayPlus = geteMondayPlus() +(week - 1);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, intMondayPlus);
        Date date = currentDate.getTime();
        String strDate = format(date, FORMAT_MIDDLE);
        if (time < 10) {
            strDate += ("0" +time +":00:00");
        }else {
            strDate += (" "+time+":00:00");
        }
        return parse(strDate, FORMAT_FULL);
    }

    /**
     * 获得当前日期与本周一相差的天数
     * @author Blossom
     * @time 2016年8月29日
     * @return_type int
     * @return
     */
    private static int geteMondayPlus() {
        Calendar calendar = Calendar.getInstance();
        int intDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (intDayOfWeek == 1) {
            return -6;
        }else{
            return 2-intDayOfWeek;
        }
    }

    /**
     * 计算两个日期相差的天数
     * @author Blossom
     * @time 2016年8月29日
     * @return_type long
     * @param startDate
     * @param endDate
     * @return
     */
    public static long differ(Date startDate,Date endDate){
        long longDiff = (endDate.getTime()-startDate.getTime())/86400000;
        return Math.abs(longDiff);
    }


    /**当前毫秒值*/
    public static long NOW_DATE_MIS =getNowTime();

    /**根据方法获取**/
    public static long getNowTime(){
        return new Date().getTime();
    }

    /**
     * @description 获取当前时间的年月日时分秒+时间戳后4位  如:20140620123456   18位
     * @author Blossom
     * @DateTime 2017/3/8 11:28
     */
    public static String ymdhms4(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = sdf.format(date);
        double a = Math.random() * 9000 + 1000;
        int result = (int)a;
        return s + result;
    }

    /**
     * 获取最大毫秒值
     * @param dateStr 2016-12-12 年-月-日 参数
     * @return
     */
    public static Long getMaxMillsByYMD(String dateStr){
        if(StringUtils.isBlank(dateStr)){
            return null;
        }
        dateStr = dateStr.trim() + " 23:59:59";
        Date date = parse(dateStr);
        return date.getTime() ;
    }
    /**
     * 获取最小毫秒值
     * @param dateStr 2016-12-12 年月日参数
     * @return
     */
    public static Long getMinxMillsByYMD(String dateStr){
        if(StringUtils.isBlank(dateStr)){
            return null;
        }
        dateStr = dateStr.trim() + " 00:00:00";
        Date date = parse(dateStr);
        return date.getTime() ;
    }

    /**
     * 计算两个日期之间相差的月数
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonths(Date date1, Date date2) {
        int iMonth = 0;
        int flag = 0;
        try {
            Calendar objCalendarDate1 = Calendar.getInstance();
            objCalendarDate1.setTime(date1);
            Calendar objCalendarDate2 = Calendar.getInstance();
            objCalendarDate2.setTime(date2);
            if (objCalendarDate2.equals(objCalendarDate1))
                return 0;
            if (objCalendarDate1.after(objCalendarDate2)) {
                Calendar temp = objCalendarDate1;
                objCalendarDate1 = objCalendarDate2;
                objCalendarDate2 = temp;
            }
            if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
                    .get(Calendar.DAY_OF_MONTH))
                flag = 1;

            if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
                    .get(Calendar.YEAR))
                iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
                        .get(Calendar.YEAR))
                        * 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
                        - objCalendarDate1.get(Calendar.MONTH);
            else
                iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return iMonth;
    }


    /**
     * 获取当前星期（中国, 如：星期日,星期一,星期二）
     */
    public static String cnWeek() {
        Calendar c = GregorianCalendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        String[] s = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        return s[c.get(Calendar.DAY_OF_WEEK) - 1];
    }

    /**
     * 得到一个日期是周几
     */
    public static String getWeekCS(Date date) {

        Calendar c = GregorianCalendar.getInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        String[] s = { "sunday", "monday", "tuesday", "wednesday",
                "thursday", "friday", "saturday" };
        return s[c.get(Calendar.DAY_OF_WEEK) - 1];
    }

    /**
     * 得到一个日期是周几
     */
    public static String getWeekInNum(Date date) {

        Calendar c = GregorianCalendar.getInstance();
        c.setTime(date);
        int weekDayNum = c.get(Calendar.DAY_OF_WEEK)-1;
        if(weekDayNum == 0){
            weekDayNum = 7;
        }
        return String.valueOf(weekDayNum);
    }

    /**
     *  取传入时间的小时值
     * @param endDate
     * @return
     */
    public static String makeHour(Date endDate) {
        String hour = "";
        if (endDate != null) {
            DateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            String after = format.format(endDate);
            hour = after.substring(11, 13);
        }
        return hour;
    }

    public static String makeMini(Date endDate) {
        String mini = "";
        if (endDate != null) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String after = format.format(endDate);
            mini = after.substring(14, 16);
        }
        return mini;
    }

    /**
     * 得到当前时间的 小时和分（hh:mm）
     * @param date
     * @return
     */
    public static String getHourAndMinute(Date date){
        String hour = makeHour(date);
        String minute = makeMini(date);

        return hour + ":" + minute;
    }

    @SuppressWarnings("unchecked")
    public static List getTomorrowList() {
        List<String> dateList = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tomorrow = sdf.format(calendar.getTime());
        dateList.add(tomorrow);
        for (int i = 0; i < 6; i++) {
            calendar.set(6, calendar.get(6) + 1);
            tomorrow = sdf.format(calendar.getTime());
            dateList.add(tomorrow);
        }

        return dateList;
    }

    @SuppressWarnings("unchecked")
    public static List getWeekDateList(String date) throws ParseException {
        List<String> dateList = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
        Date dateVar = ymd.parse(date);
        calendar.setTime(dateVar);
        dateList.add(date);
        for (int i = 1; i <= 6; i++) {
            calendar.set(6, calendar.get(6) + 1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tomorrow = sdf.format(calendar.getTime());
            dateList.add(tomorrow);
        }
        return dateList;
    }

    /**
     * 判断所给时间在月的第几周
     * @param date 输入时间
     * @return 第几周
     */
    public static int weekOfMonth(String date) {
        Date d = parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取当前星期几
     */
    public static int weekDay(String date) {
        Date d = parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        return c.get(Calendar.DAY_OF_WEEK)-1;

    }
    /**
     * 返回日期date 前推beforHour小时后的 日期
     * @param date
     * @param beforHour
     * @return
     */
    public static Date getBeforHourDate(Date date, int beforHour){

        if(date != null){
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.HOUR, c.get(Calendar.HOUR)-beforHour);

            return c.getTime();
        }
        return null;
    }

    /**
     * 取给定日期的前一天
     * @param date
     * @return
     */
    public static Date getLastDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR,
                calendar.get(Calendar.DAY_OF_YEAR) - 1);
        return calendar.getTime();
    }

    /**
     * 返回两时间的相差天数
     * @param d1
     * @param d2
     * @return
     */
    public static int getDayNumBetween2Date(Date d1, Date d2){

        if(isEqualsInYMD(d1, d2)){
            return 0;
        }

        long l = d2.getTime()-d1.getTime();
        int day = (int) (l/(24*60*60*1000));
        if(day < 0){
            day = (-day);
        }

        int m = (int) (l%(24*60*60*1000));
        Calendar c = Calendar.getInstance();
        if(d1.compareTo(d2)<=0){
            c.setTime(d1);
            c.add(Calendar.MILLISECOND, m);
            if(isEqualsInYMD(d1, c.getTime())){
                return day;
            }else{
                return day+1;
            }
        }else{
            c.setTime(d2);
            c.add(Calendar.MILLISECOND, m);
            if(isEqualsInYMD(d2, c.getTime())){
                return day;
            }else{
                return day+1;
            }
        }

    }

    /**
     * 两个时间是否是 同年 同月 同日
     * 如果是，则返回true，否则返回false
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isEqualsInYMD(Date d1, Date d2){

        Calendar c = Calendar.getInstance();

        c.setTime(d1);
        int year1 = c.get(Calendar.YEAR);
        int dayOfYear1 = c.get(Calendar.DAY_OF_YEAR);

        c.setTime(d2);
        int year2 = c.get(Calendar.YEAR);
        int dayOfYear2 = c.get(Calendar.DAY_OF_YEAR);

        if(year1 != year2){
            return false;
        }
        if(dayOfYear1 != dayOfYear2){
            return false;
        }

        return true;
    }

    /**
     * 获得当前月的前 i 个月
     * @param i (henrry)
     * return 月的数组
     */
    public static String[] getMonthArr(int i){
        String arr[] = new String[i];
        Calendar c = Calendar.getInstance();
        int temp = 0;
        int tempp = 0;
        int year = 0;
        int month = 0;
        int m = i-1;
        for(int j=0;j<m;j++){
            if(i>12){
                temp = (i-1)/12;
                tempp = (i-1)%12;
                year  = c.get(Calendar.YEAR)-temp;
                month = c.get(Calendar.MONTH)-tempp+1;
                if(month<10 && month >0){
                    arr[j] = year+"-0"+month;
                }else if(month<0){
                    month = 12+month;
                    if(month<10){
                        arr[j] = (year-1)+"-0"+month;
                    }else{
                        arr[j] = (year-1)+"-"+month;
                    }
                }else if(month == 0){
                    arr[j] = (year-1)+"-"+12;
                }else{
                    arr[j] = year+"-"+month;
                }
            }else{
                year  = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH)-i+2;
                if(month<10 && month >0){
                    arr[j] = year+"-0"+month;
                }else if(month<0){
                    month = 12+month;
                    if(month<10){
                        arr[j] = (year-1)+"-0"+month;
                    }else{
                        arr[j] = (year-1)+"-"+month;
                    }
                }else if(month==0){
                    arr[j] = (year-1)+"-"+12;
                }else{
                    arr[j] = year+"-"+month;
                }
            }
            i--;
        }
        int monthNow = c.get(Calendar.MONTH);
        if(monthNow>8){
            arr[m] = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1);
        }else{
            arr[m] = c.get(Calendar.YEAR) + "-0" + (c.get(Calendar.MONTH)+1);
        }
        return arr;
    }

    /**
     * 得到两个时间之间的差距，根据type可返回分别以天，时，分为单位的整数
     * @param d1
     * @param d2
     * @param type
     * @return
     */
    public static int getBetweenDateGap(Date d1, Date d2, String type){
        long time1 = d1.getTime();
        long time2 = d2.getTime();
        long m = (time1-time2)/1000;
        int nDay = (int)m/(24*60*60);
        int nHour = (int)(m-nDay*24*60*60)/(60*60);
        int nMinute = (int)(m-nDay*24*60*60-nHour*60*60)/60;
        int mSecond = (int)(m-nDay*24*60*60-nHour*60*60);
        if("day".equals(type)){
            return nDay;
        }else if("minute".equals(type)){
            return nMinute;
        }else if("hour".equals(type)){
            return nHour;
        }else if("second".equals(type)){
            return mSecond;
        }
        return nMinute;
    }

    /**
     * *
     * 通过月份计算季度 *
     * @param
     * month *
     * @return
     */
    public static int getQuarter(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month is invalid.");
        }
        return (month - 1) / 3 + 1;
    }
}
