package com.system.util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
//	private static String begintime1="9:00:00";
//	private static String begintime2="14:00:00";
//	private static String endtime1="11:00:00";
//	private static String endtime2="17:00:00";
	
	public static boolean isDate(String s) {
		return isLegalDate(s.length(),s,"yyyy-MM-dd");
	}
	
	public static boolean isTime(String s) {
		return isLegalDate(s.length(),s,"HH:mm:ss");
	}
	
	public static boolean isDateTime(String s) {
		return isLegalDate(s.length(),s,"yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * @param length 校验的长度
	 * @param sDate 校验的日期
	 * @param format 校验的格式
	 * @return
	 */
	private static boolean isLegalDate(int length, String sDate, String format) {
		int legalLen=length;
		if((sDate==null)||(sDate.length()!=legalLen)) {
			return false;
		}
		DateFormat formatter=new SimpleDateFormat(format);
		try {
			Date date=formatter.parse(sDate);
			return sDate.equals(formatter.format(date));
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * 下面三个是将字符串转化成日期/时间/dateTime类型的函数
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	public static Date StringtoDate(String s)throws ParseException{
		DateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
		Date date=fmt.parse(s);
		return date;
	}
	public static Date StringtoTime(String s)throws ParseException{
		DateFormat fmt=new SimpleDateFormat("HH:mm:ss");
		Date time=fmt.parse(s);
		return time;
	}
	public static Date StringtoDateTime(String s)throws ParseException{
		DateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateTime=fmt.parse(s);
		return dateTime;
	}
	
//	public static int JudgeTime(String time) throws ParseException {
//		if((StringtoTime(begintime1)).before(StringtoTime(time))==true && !(StringtoTime(endtime1)).after(StringtoTime(time))==true){
//			return 1;
//		}else{
//			if((StringtoTime(begintime2)).before(StringtoTime(time))==true && !(StringtoTime(endtime2)).after(StringtoTime(time))==true){
//				return 1;
//			}
//		}
//		return 0;
//	}
}
