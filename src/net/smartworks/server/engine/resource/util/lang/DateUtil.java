package net.smartworks.server.engine.resource.util.lang;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * 데이트 관련 유틸 클래스
 * 
 * @author jhnam
 * @version $Id: DateUtil.java,v 1.1 2011/11/08 03:15:11 kmyu Exp $
 */
public class DateUtil {

	/**
	 * yyyy-MM-dd 형식의 스트링을 파싱하여 Date객체로 리턴한다.
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseBasicDate(String dateStr) throws ParseException {
        
        String[] parsers = new String[] { "yyyy'-'MM'-'dd" };
        Date date = DateUtils.parseDate(dateStr, parsers);
        return date;
	}
	
	/**
	 * dateStr을 yyyy-MM-dd HH:mm:ss Date 형식으로 변환하여 Date 객체로 리턴한다.
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseTimeToBasicFormat(String dateStr) throws ParseException {
		
        String[] parsers = new String[] { "yyyy-MM-dd HH:mm:ss" };
        Date date = DateUtils.parseDate(dateStr, parsers);
        return date;
	}
	
	/**
	 * 현재 시간을 기본 포맷의 스트링으로 변환한다. yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static String formatCurrentTime() {
		return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 파라미터로 받은 시간을 기본 포맷의 스트링으로 변환한다. 
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 파라미터로 받은 시간을 파라미터로 받은 포맷의 스트링으로 변환한다.
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		return DateFormatUtils.format(date, format);
	}
	
	/**
	 * 오늘 날짜를 기본 포맷의 문자열로 리턴한다. - yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String formatTodayToBasicFormat() {
		return DateFormatUtils.format(new Date(), "yyyy-MM-dd");
	}
	
	/**
	 * 내일 날짜를 기본 포맷의 문자열로 리턴한다. - yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String formatTomorrowToBasicFormat() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Date nextDate = cal.getTime();
		return DateFormatUtils.format(nextDate, "yyyy-MM-dd");
	}
	
	/**
	 * 새로운 날짜인지 여부를 판단
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isNewDate(Date date) {
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		Date newDate = c.getTime();
		return date.after(newDate);
	}
	
	public static void main(String[] args) {
		
		try {
			Date date = DateUtil.parseBasicDate("2008-06-13");
			System.out.println(date);			
			System.out.println(DateUtil.formatCurrentTime());
			
			date = DateUtil.parseTimeToBasicFormat("2008-04-27 11:01:21");
			System.out.println(date);
			
			System.out.println(DateUtil.formatTodayToBasicFormat());
			System.out.println(DateUtil.formatTomorrowToBasicFormat());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
