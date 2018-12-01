package com.mm.bbs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeUtil {
	/**
	取得当前日期
	*/
	public static String getDate()
	{
		Calendar c=new GregorianCalendar();
		StringBuffer buffer=new StringBuffer();
		buffer.append(c.get(Calendar.YEAR)).append("-");
		buffer.append(addZero(c.get(Calendar.MONTH)+1)).append("-");
		buffer.append(addZero(c.get(Calendar.DATE)));
		return buffer.toString();
	}
	/**
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static List<Map<String,String>> getAllHoursofDay() throws ParseException
	{
		List<Map<String,String>> lst=new ArrayList<Map<String,String>>();
		Map<String,String> map;
		StringBuffer buffer;
		Calendar c=new GregorianCalendar();
		
		for(int i=0;i<24;i++) {
			map=new HashMap<String,String>();
			buffer=new StringBuffer();
			buffer.append(getDate()).append(" ");
			buffer.append(addZero(i)).append(":");
			buffer.append(addZero(0)).append(":");
			buffer.append(addZero(0));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			Date joindate = (Date)formatter.parse(buffer.toString());
			map.put(String.valueOf(i), buffer.toString());
			lst.add(map);
		}
		return lst;
	}
	
	/**
		取得当前日期时间
	*/
	public static String getDateTime()
	{
		Calendar c=new GregorianCalendar();
		StringBuffer buffer=new StringBuffer();
			buffer.append(c.get(Calendar.YEAR)).append("-");
		buffer.append(addZero(c.get(Calendar.MONTH)+1)).append("-");
		buffer.append(addZero(c.get(Calendar.DATE))).append(" ");
		buffer.append(addZero(c.get(Calendar.HOUR))).append(":");
		buffer.append(addZero(c.get(Calendar.MINUTE))).append(":");
		buffer.append(addZero(c.get(Calendar.SECOND)));
		return buffer.toString();
	}
	/**
		获取当前时间戳
	*/
	public static long getTimeStamp()
	{
		Calendar c=new GregorianCalendar();
		return c.getTime().getTime();
	}
	
	/**
		如果月，日，时，分，秒小于 10 在前面添加0
	*/
	public static String addZero(int value)
	{
		String str=Integer.toString(value);
		if(str.length()<2)
			return 0+str;
		return str;
	}
 
}
