package com.ashin.service.utils;


import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * <p>时间工具类</p>
 *
 * @author 曾文锋
 * @version 1.00
 *
 * <pre>
 * 修改记录:
 * 修改后版本    		修改人   		修改日期   		修改内容
 * 2012-08-02.1		曾文锋   		2012-08-02		create
 * </pre>
 */
public class DateUtils
{
	
	private static Logger log = Logger.getLogger(DateUtils.class);
	/**
	 * 每天24小时
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
	public final static int HOURS_PER_DAY = 24;
	
	/**
	 * 每小时60分钟
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
	public final static int MINUTES_PER_HOUR = 60;
	
	/**
	 * 每分钟60秒
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
	public final static int SECONDS_PER_MINUTE = 60;
	
	/**
	 * 每秒1000毫秒
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
	public final static int MILLISECONDS_PER_SECOND = 1000;
	
	/**
	 * 每年4个季度
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
	public final static int SEASONS_PER_YEAR = 4;
	
	/**
	 * 第一季度
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
	public final static int THE_FIRST_SEASON = 1;
	
	/**
	 * 第二季度
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
	public final static int THE_SECOND_SEASON = 2;
	
	/**
	 * 第三季度
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
	public final static int THE_THIRD_SEASON = 3;
	
	/**
	 * 第四季度
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
	public final static int THE_FOURTH_SEASON = 4;
	
	/**
	 * 一月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int JANUARY = 1;

    /**
	 * 二月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int FEBRUARY = 2;

    /**
	 * 三月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int MARCH = 3;

    /**
	 * 四月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int APRIL = 4;

    /**
	 * 五月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int MAY = 5;

    /**
	 * 六月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int JUNE = 6;

    /**
	 * 七月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int JULY = 7;

    /**
	 * 八月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int AUGUST = 8;

    /**
	 * 九月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int SEPTEMBER = 9;

    /**
	 * 十月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int OCTOBER = 10;

    /**
	 * 十一月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int NOVEMBER = 11;

    /**
	 * 十二月
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 */
    public final static int DECEMBER = 12;
    
	public static Date stringToDate(String dateString) {

		return stringToDate(dateString, "yyyy-MM-dd", false);
	}
	
	public static Date stringToDate(String dateText, String format, boolean lenient) {

		if (dateText == null) {

			return null;
		}

		DateFormat df = null;

		try {

			if (format == null) {
				df = new SimpleDateFormat();
			} else {
				df = new SimpleDateFormat(format);
			}

			// setLenient avoids allowing dates like 9/32/2001
			// which would otherwise parse to 10/2/2001
			df.setLenient(false);

			return df.parse(dateText);
		} catch (ParseException e) {

			return null;
		}
	}
	
	/**
	 * 判断指定年份是否是闰年。
	 * 
	 * 闰年定义
	 * 1、能被4整除而不能被100整除； 
	 * 2、能被400整除。
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param year 指定年份
	 * @return 如果是闰年返回true，否则返回false。
	 */
	public static boolean isLeapYear(int year)
	{
		//能被4整除而不能被100整除 或者 能被400整除，那么是闰年，返回true
		if ((year / 4 == 0 && year / 100 != 0) || year / 400 == 0)
		{
			return true;
		}
		//否则不是闰年，返回false
		else
		{
			return false;
		}
	}
	
	/**
	 * 获取指定日历日所在月份的总天数
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param date 指定日历日
	 * @return 返回天数
	 */
	public static int getDaysInMonth(Calendar date)
	{
		//获取中国的月份
		int monthCHN = date.get(Calendar.MONTH) + 1;
		
		//1月、3月、5月、7月、8月、10月、12月共有31天
		if (monthCHN == JANUARY || monthCHN == MARCH || monthCHN == MAY || monthCHN == JULY ||
			monthCHN == AUGUST || monthCHN == OCTOBER || monthCHN == DECEMBER)
		{
			return 31;
		}
		//4月、6月、9月、11月共有30天
		else if (monthCHN == APRIL || monthCHN == JUNE || monthCHN == SEPTEMBER || monthCHN == NOVEMBER)
		{
			return 30;
		}
		//2月
		else if (monthCHN == FEBRUARY)
		{
			//闰年的2月份共有29天
			if (isLeapYear(date.get(Calendar.YEAR)))
			{
				return 29;
			}
			//平年2月份共有28天
			else
			{
				return 28;
			}
		}
		//异常
		else 
		{
			return -1;
		}
	}
	
	/**
	 * 获取指定日历日所在季度
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param date 指定日历日
	 * @return 1：第一季度  2：第二季度  3：第三季度  4：第四季度 -1：异常
	 */
	public static int getSeason(Calendar date)
	{
		//获取中国的月份
		int monthCHN = date.get(Calendar.MONTH) + 1;
		
		//第一季度：一月份、二月份、三月份
		if (monthCHN >= JANUARY && monthCHN <= MARCH)
		{
			return THE_FIRST_SEASON;
		}
		//第二季度：四月份、五月份、六月份
		else if (monthCHN >= APRIL && monthCHN <= JUNE)
		{
			return THE_SECOND_SEASON;
		}
		//第三季度：七月份、八月份、九月份
		else if (monthCHN >= JULY && monthCHN <= SEPTEMBER)
		{
			return THE_THIRD_SEASON;
		}
		//第四季度：十月份、十一月份、十二月份
		else if (monthCHN >= OCTOBER && monthCHN <= DECEMBER)
		{
			return THE_FOURTH_SEASON;
		}
		//异常
		else 
		{
			return -1;
		}
	}
	
	/**
	 * 计算两个日历之间时间差
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param begin 起始日历
	 * @param end 结束日历
	 * @return 总天数
	 */
	public static long getTimesBetweenTwoDays(Calendar begin, Calendar end)
	{
		if (begin == null || end == null)
		{
			return -1;
		}
		
		return  Math.abs(end.getTime().getTime() - begin.getTime().getTime());
	}
	
	/**
	 * 计算两个日历之间相差多少天
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param begin 起始日历
	 * @param end 结束日历
	 * @return 总天数
	 */
	public static long getDaysBetweenTwoDays(Calendar begin, Calendar end)
	{
		return getTimesBetweenTwoDays(begin, end) / (HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE * MILLISECONDS_PER_SECOND);
	}
	
	/**
	 * 计算两个日历之间相差多少年
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param begin 起始日历
	 * @param end 结束日历
	 * @return 总天数
	 */
	public static int getYearsBetweenTwoDays(Calendar begin, Calendar end)
	{
		return Math.abs(begin.get(Calendar.YEAR) - end.get(Calendar.YEAR));
	}
	
	/**
	 * 计算两个日历之间相差多少季度
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param begin 起始日历
	 * @param end 结束日历
	 * @return 总天数
	 */
	public static int getSeasonsBetweenTwoDays(Calendar begin, Calendar end)
	{
		return getYearsBetweenTwoDays(begin, end) * SEASONS_PER_YEAR + getSeason(end) - getSeason(begin);
	}
	
	/**
	 * 转换中国日历的周
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param date
	 * @return  1：星期一， 2：星期二， 3：星期三，  4：星期四， 5：星期五， 6：星期六 7：星期日，
	 */
	public static int getDayOfWeekCHN(Calendar calendar)
	{
		//获取指定日历在本周是星期几
		int flag = calendar.get(Calendar.DAY_OF_WEEK);
		
		//星期一
		if (flag == Calendar.MONDAY)
		{
			return 1;
		}
		//星期二
		else if (flag == Calendar.TUESDAY)
		{
			return 2;
		}
		//星期三
		else if (flag == Calendar.WEDNESDAY)
		{
			return 3;
		}
		//星期四
		else if (flag == Calendar.THURSDAY)
		{
			return 4;
		}
		//星期五
		else if (flag == Calendar.FRIDAY)
		{
			return 5;
		}
		//星期六
		else if (flag == Calendar.SATURDAY)
		{
			return 6;
		}
		//星期日
		else if (flag == Calendar.SUNDAY)
		{
			return 7;
		}
		//异常
		else
		{
			return -1;
		}
	}
	
	/**
	 * 设置日历日开始时间为 0:00:00.000
	 * 
	 * @author 曾文锋
	 * @date 2012-10-10
	 * @param date
	 */
	public static Date getStartTime(Date date)
	{
		if (date == null)
		{
			return null;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal.getTime();
	}
	
	/**
	 * 设置日历日开始时间为 0:00:00.000
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param cal
	 */
	public static Date getStartTime(Calendar cal)
	{
		if (cal == null)
		{
			return null;
		}
		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal.getTime();
	}
	
	/**
	 * 设置日历日开始时间为 0:00:00.000
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param cal
	 */
	public static void setStartTime(Calendar cal)
	{
		if (cal == null)
		{
			return;
		}
		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
	}
	
	/**
	 * 设置日历日结束时间为 23:59:59.999
	 * 
	 * @author 曾文锋
	 * @date 2012-10-10
	 * @param date
	 */
	public static Date getEndTime(Date date)
	{
		if (date == null)
		{
			return null;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal.getTime();
	}
	
	/**
	 * 设置日历日结束时间为 23:59:59.999
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param cal
	 */
	public static Date getEndTime(Calendar cal)
	{
		if (cal == null)
		{
			return null;
		}
		
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal.getTime();
	}
	
	/**
	 * 设置日历日结束时间为 23:59:59.999
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param cal
	 */
	public static void setEndTime(Calendar cal)
	{
		if (cal == null)
		{
			return;
		}
		
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
	}
	
	 /** 
	  * 取得指定日期所在周的第一天 
	  * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param cal
	 */ 
	  public static Calendar getFirstDayOfWeek(Calendar calendar) 
	  { 
		  Calendar c = Calendar.getInstance();
		  c.setFirstDayOfWeek(Calendar.MONDAY); 
		  c.setTime(calendar.getTime()); 
		  c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday 
		  return c; 
	  } 

	  /** 
	  * 取得指定日期所在周的最后一天 
	   * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param cal
	 */ 
	  public static Calendar getLastDayOfWeek(Calendar calendar) 
	  { 
		  Calendar c = Calendar.getInstance();
		  c.setFirstDayOfWeek(Calendar.MONDAY); 
		  c.setTime(calendar.getTime()); 
		  c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday 
		  return c; 
	  } 

	  
	/**
	 * 获取指定日历所在月份的第一天的日历
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param calendar
	 * @return calendar
	 */
	public static Calendar getFirstDayOfMonth(Calendar calendar) 
	{
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY); 
		c.setTime(calendar.getTime());
		c.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
		return c;
	}
	
	/**
	 * 获取指定日历所在月份的最后一天的日历
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param calendar
	 * @return calendar
	 */
	public static Calendar getLastDayOfMonth(Calendar calendar) 
	{
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY); 
		c.setTime(calendar.getTime());
		c.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		return c;
	}
	
	/**
	 * 获取指定日历所在季度的最后一天的日历
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param calendar
	 * @return calendar
	 */
	public static Calendar getLastDayOfSeason(Calendar calendar) 
	{
		int flag = getSeason(calendar);
		
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(calendar.getTime());
		
		if (flag == 1)
		{
			c.set(Calendar.MONTH, Calendar.MARCH);
		}
		else if (flag == 2)
		{
			c.set(Calendar.MONTH, Calendar.JUNE);
		}
		else if (flag == 3)
		{
			c.set(Calendar.MONTH, Calendar.SEPTEMBER);
		}
		else if (flag == 4)
		{
			c.set(Calendar.MONTH, Calendar.DECEMBER);
		}
		
		c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
		return c;
	}
	
	/**
	 * 获取指定日历所在年份的最后一天的日历
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param calendar
	 * @return calendar
	 */
	public static Calendar getLastDayOfYear(Calendar calendar) 
	{
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(calendar.getTime());
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
		return c;
	}
	
	/**
	 * 将字符串转换成日期类型
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public static Date strToDate(String dateStr, String formatStr) {
		DateFormat dd = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = dd.parse(dateStr);
		} catch (ParseException e) {
			log.error("strToDate error",e);
		}
		return date;
	}
	
	/**
	 * 日期间相互转换
	 */
	public static Date dateToDate(Date date,String formatStr) {
		String dateStr = dateToStr(date, formatStr);
		Date d = strToDate(dateStr, formatStr);
		return d;
	}
	
	/**
	 * 将日期转换成字符串
	 * @param date
	 * @return
	 */
	public static String dateToStr(Date date, String formatStr) {
		if(date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		String str = format.format(date);
		return str;
	}
	
	/**
	 * Description : 获取两个日期之间的天数
	 * return : Long
	 * create date : 2013-8-30 下午05:57:10
	 * creator : Justin
	 */
	public static int getDistanceOfDate(Date date1,Date date2) {
		if(date1 == null || date2 == null) {
			return 0;
		}
		Long d1 = date1.getTime();
		Long d2 = date2.getTime();
		int distance = (int)(d1 - d2)/(1000 * 24 * 60 * 60);
		return distance;
	}
	

	
	/**
	 * 计算日期：指定日期 + 累加数
	 * @param assignTime 指定日期
	 * @param quantity 累加数组([天数][小时数][分钟数])
	 * @return
	 * @Author  Devin
	 * @Create  2014-8-19下午05:41:51 
	 * @return  Date    
	 * @Description 如果累加数量为空，则返回指定的日期
	 */
	public static Date setCumsumDate(Date assignTime, int[] quantity){
		Date date = assignTime;
		if(null != quantity){
			Calendar rightNow = Calendar.getInstance();
	        rightNow.setTime(date);
	        rightNow.add(Calendar.DAY_OF_YEAR, quantity[0]);
	        rightNow.add(Calendar.HOUR_OF_DAY, quantity[1]);
	        rightNow.add(Calendar.MINUTE, quantity[2]);
	        Date newDate = rightNow.getTime();
			return newDate;
		}
		return date;
	}

	/**
	 * 获取上个月的第一天
	 * @return
	 */
	public static Date getLastMonthFirstDay()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String nowdayTime = dateFormat.format(new Date());
		Date date = null;
		try {
			date = dateFormat.parse(nowdayTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();

	}
	public static Date getCurMonthFirstDay(){
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String nowdayTime = dateFormat.format(new Date());
		Date date = null;
		try {
			date = dateFormat.parse(nowdayTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}
	/**
	 * 仅供测试
	 * 
	 * @author 曾文锋
	 * @date 2012-08-02
	 * @param args
	 */
	public static void main(String[] args)
	{
		
	}
}
