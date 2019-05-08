/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.capinfo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * 
 * @author ThinkGem
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	private static String[] parsePatterns = { "yyyy","yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
			"yyyy.MM.dd HH:mm", "yyyy.MM","yyyy年MM月dd日" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 获取当前一周的日期
	 * 
	 * @return
	 */
	public static List<Date> getWeekDates(Date date) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		int b = instance.get(Calendar.DAY_OF_WEEK) - 1;
		Date currentDate = instance.getTime();

		Date fdate;

		List<Date> list = new ArrayList<Date>();

		long dayTimeMilis = b == 0 ? 7 * 24 * 3600000 : b * 24 * 3600000;

		Long fTime = currentDate.getTime() - dayTimeMilis;

		for (int a = 1; a <= 7; a++) {
			fdate = new Date();
			fdate.setTime(fTime + (a * 24 * 3600000));

			list.add(a - 1, fdate);
		}
		return list;
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
	 * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 * 
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * 
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}

	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 获取某个日期加特定天数后与另一个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoChangedDate(Date before, Date after, int day) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24) + day;
	}

	/**
	 * 一个指定日期加上指定天数得到新日期
	 * 
	 * @param date
	 * @param day
	 * @return
	 * @throws ParseException
	 * @author hanwangdong
	 * @date 2018-5-3
	 */
	public static Date addDate(Date date, long day) throws ParseException {
		long time = date.getTime(); // 得到指定日期的毫秒数
		day = day * 24 * 60 * 60 * 1000; // 要加上的天数转换成毫秒数
		time += day; // 相加得到新的毫秒数
		return new Date(time); // 将毫秒数转换成日期
	}

	/**
	 * 一个指定日期减去指定天数得到新日期
	 * 
	 * @param date
	 * @param day
	 * @return
	 * @throws ParseException
	 * @author hanwangdong
	 * @date 2018-5-3
	 */
	public static Date reduceDate(Date date, long day) throws ParseException {
		long time = date.getTime(); // 得到指定日期的毫秒数
		day = day * 24 * 60 * 60 * 1000; // 要加上的天数转换成毫秒数
		time -= day; // 相减得到新的毫秒数
		return new Date(time); // 将毫秒数转换成日期
	}

	/**
	 * 一个指定日期过去特定月后的日期
	 * 
	 * @param date
	 * @param day
	 * @return
	 * @throws ParseException
	 * @author hanwangdong
	 * @date 2018-5-3
	 */
	public static Date deforeMonDate(Date date, int month) throws Exception {
		Calendar c = Calendar.getInstance();// 获得一个日历的实例
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * Date date = null; try{ date = sdf.parse("2006-06-07");//初始日期 }catch(Exception
		 * e){
		 * 
		 * }
		 */
		c.setTime(date);// 设置日历时间
		c.add(Calendar.MONTH, -month);// 在日历的月份上6个月
		// System.out.println(sdf.format(c.getTime()));//的到你想要得6个月后的日期
		return c.getTime();
	}

	/**
	 * 由出生日期获得年龄
	 * 
	 * @param birthDay
	 * @return
	 */
	public static int getAgeByBirthDay(Date birthDay) {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);

		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth)
					age--;
			} else {
				age--;
			}
		}
		return age;
	}
	/** 
	 * 判断时间是否在时间段内 
	 *  
	 * @param date 
	 *            当前时间 yyyy-MM-dd HH:mm:ss 
	 * @param strDateBegin 
	 *            开始时间 00:00:00 
	 * @param strDateEnd 
	 *            结束时间 00:05:00 
	 * @return 
	 */  
	public static boolean isInDate(Date date,Date startDate,Date endDate) {
		long dateLong = date.getTime();
		long startLong = startDate.getTime();
		long endLong = endDate.getTime();
		if(dateLong <=endLong && dateLong>=startLong) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断 startDate 是否在endDate后面
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean isBigDate(Date startDate,Date endDate){
		long startLong = startDate.getTime();
		long endLong = endDate.getTime();
		if(startLong>endLong){
			return true;
		}
		return false;
	}
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws Exception {
		// System.out.println(formatDate(parseDate("2010/3/6")));
		// System.out.println(getDate("yyyy年MM月dd日 E"));
		// long time = new Date().getTime()-parseDate("2012-11-19").getTime();
		// System.out.println(time/(24*60*60*1000));
		// System.out.println(getDistanceOfTwoChangedDate(new
		// Date(),parseDate("2017-11-10"),60));
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// String format = sdf.format(new Date());
		// System.out.println(getDistanceOfTwoDate(parseDate(format),parseDate("2018-05-03")));
		// System.out.println(getDistanceOfTwoDate(parseDate(format),parseDate("2018-05-03"))<=0);
		// System.out.println(getDistanceOfTwoDate(null,parseDate("2018-05-03"))<=0);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式
		// Date date = dateFormat.parse("2018-05-03"); // 指定日期
		// Date newDate = addDate(new Date(), 7); // 指定日期加上20天
		// Date newDate = reduceDate(new Date(), 7); // 指定日期7天
		Date newDate = deforeMonDate(new Date(), 6); // 指定日期7天
		// System.out.println(dateFormat.format(date));// 输出格式化后的日期
		System.out.println(dateFormat.format(newDate));

	}
}
