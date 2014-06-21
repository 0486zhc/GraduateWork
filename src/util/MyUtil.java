package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyUtil {
	// 今天 ，格式:2014-06-20
	public static String getToday(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// 开始日期
		Date today = new Date();
		String todayFormat = df.format(today);
		return todayFormat ;
	}
	
	// 7天后，格式：2014-06-26
	public static String getOtherDay(Integer dayNum){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		Date twelveday = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(twelveday);
		// calendar.add(calendar.DATE,6);//把日期往后增加一天.整数往后推,负数往前移动
		calendar.add(calendar.DATE, dayNum-1);
		twelveday = calendar.getTime(); // 这个时间就是日期往后推的结果
		String end_time = df.format(twelveday);
		return end_time ;
	}
	
	// 10位左补齐 0 
	private static String switchStringAndLeftFilling(Long i) {
		StringBuilder strb = new StringBuilder();
		int zeros = i.toString().length();
		for (int j = 0; j < (10 - zeros); j++) {
			strb.append(0);
		}
		return strb.append(i.toString()).toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getToday());
		System.out.println(getOtherDay(7));
	}
	
}
