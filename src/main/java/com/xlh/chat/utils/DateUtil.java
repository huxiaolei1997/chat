/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package com.xlh.chat.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期处理工具
 *
 * @author 侯俊昌(HouJunChang)
 * @version $Id: DateUtil, v0.1 2017年03月01日 16:26 侯俊昌(HouJunChang) Exp $
 */
@Slf4j
public class DateUtil {

    // 长格式类型
    public static final String MAX_LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // 短格式类型
    public static final String SHORT_FORMAT = "yyyy-MM-dd";

    private static String[] PARSE_PATTERN_ARRAY = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyyMMddHHmmss"};

    /**
     * 获取短格式日期：2017-3-20
     *
     * @return 格式化后的日期
     */
    public static String getShortDate() {

        SimpleDateFormat sf = new SimpleDateFormat(SHORT_FORMAT);
        Date date = new Date();

        return sf.format(date);
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurrentDate(String pattern) {

        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        Date date = new Date();

        return sf.format(date);
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date getCurDate() {
        return new Date();
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static Timestamp getCurTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 计算减去指定的月份
     *
     * @param count 减数
     * @return 格式化后的月份
     */
    public static String subWeakCount(int count) {

        //获取当前时间
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, count);

        SimpleDateFormat sf = new SimpleDateFormat(SHORT_FORMAT);

        return sf.format(calendar.getTime());
    }

    /**
     * 长类型日期转化为字符串日期
     *
     * @param time   时间
     * @param format 格式
     * @return 字符串日期
     */
    public static String getStrFormat(long time, String format) {

        // 如果格式为空
        if (StringUtils.isBlank(format)) {
            format = MAX_LONG_FORMAT;
        }

        SimpleDateFormat sf = new SimpleDateFormat(format);
        Date date = new Date(time);

        return sf.format(date);
    }

    /**
     * 字符串日期转化为长类型日期
     *
     * @param date 日期
     * @return 场类型日期
     */
    public static long getLongFormat(String date) {

        try {

            if (StringUtils.isNotBlank(date)) {
                SimpleDateFormat sf = new SimpleDateFormat(MAX_LONG_FORMAT);
                return sf.parse(date).getTime();
            }

        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }

        return 0L;
    }

    /**
     * 计算当前时间减去指定的月
     *
     * @param count 减数
     * @return 格式化后的月份
     */
    public static String minusMonths(int count) {
        return calculate(0 - count, SHORT_FORMAT, Calendar.MONTH);
    }

    /**
     * 过去多久时间
     *
     * @param date
     * @return 刚刚、2分钟前、2小时前、2016-02-22
     */
    public static StringBuffer howLongAgo(Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuffer sb = new StringBuffer();
        Date now = new Date();

        if (date == null) {
            return sb;
        }

        try {
            long l = now.getTime() - date.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
//            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            long d = (24 * 60 * 60 * 1000);
            long h = (60 * 60 * 1000);
            long m = (60 * 1000);

            if (l >= d) {
                sb.append(simpleDateFormat.format(date));
            } else if (l < d && l >= h) {
                sb.append(hour + "小时前");
            } else if (l < h && l >= m) {
                sb.append(min + "分钟前");
            } else {
                sb.append("刚刚");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return sb;
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 计算减去指定时间
     *
     * @param count  数量
     * @param format 格式
     * @param type   时间类型
     * @return
     */
    private static String calculate(int count, String format, int type) {

        //获取当前时间
        Date date = new Date();

        // 创建时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(type, count);

        //初始化格式
        SimpleDateFormat sf = null;

        // 默认格式yyyy-MM-dd
        if (StringUtils.isBlank(format)) {

            sf = new SimpleDateFormat(SHORT_FORMAT);
        } else {

            sf = new SimpleDateFormat(format);
        }

        return sf.format(calendar.getTime());
    }


    public static List<String> getLastHour() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:00:00");

        SimpleDateFormat simpleDateFormatHour = new SimpleDateFormat("yyyy-MM-dd HH");

        Date date = calendar.getTime();

        String startDate = simpleDateFormat.format(date);

        String endDate = simpleDateFormatHour.format(date) + ":59:59";

        List<String> dateList = new ArrayList<>();
        dateList.add(startDate);
        dateList.add(endDate);

        return dateList;
    }

    /**
     * 获取前一天时间
     *
     * @param
     * @return java.utils.List<java.lang.String>
     * @author 胡晓磊
     * @version 1.0
     * @date 2019-07-12 15:11:56
     */
    public static List<String> getLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

        SimpleDateFormat simpleDateFormatHour = new SimpleDateFormat("yyyy-MM-dd");

        Date date = calendar.getTime();

        String startDate = simpleDateFormat.format(date);

        String endDate = simpleDateFormatHour.format(date) + " 23:59:59";

        List<String> dateList = new ArrayList<>();
        dateList.add(startDate);
        dateList.add(endDate);

        return dateList;
    }

    /**
     * 获取前几天的时间
     *
     * @param
     * @return java.utils.List<java.lang.String>
     * @author 胡晓磊
     * @version 1.0
     * @date 2019-07-12 15:11:56
     */
    public static List<String> getLastDay(int amount) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - amount);
        Date endDate = calendar.getTime();

        List<String> dateList = new ArrayList<>();
        dateList.add(simpleDateFormat.format(endDate));
        dateList.add(simpleDateFormat.format(startDate));

        return dateList;
    }

    public static void main(String[] args) {
        List<String> dateList = getLastDay(7);
        System.out.println(dateList.get(0) + "," + dateList.get(1));

        for (int i = 0; i < 10; i++) {
//            System.out.println(i / 0);
            System.out.println(i);
        }
    }

}
