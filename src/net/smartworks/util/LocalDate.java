package net.smartworks.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import net.smartworks.model.KeyMap;
import net.smartworks.model.community.User;

public class LocalDate extends Date{

	public final static int ONE_SECOND = 1000;
	public final static	int ONE_MINUTE = 60*ONE_SECOND;
	public final static int ONE_HOUR = 60*ONE_MINUTE;
	public final static long ONE_DAY = 24*ONE_HOUR;
	public final static long ONE_WEEK = 7*ONE_DAY;
	public final static long ONE_YEAR = 365*ONE_DAY;
	
	public final static String TIMEZONE_SEOUL = "Asia/Seoul";
	public final static String TIMEZONE_LOS_ANGELES = "America/Los_Angeles";

	private static final long serialVersionUID = 1L;
	private TimeZone timeZone = TimeZone.getDefault();
	private TimeZone hostTimeZone = TimeZone.getDefault();
	private Locale locale = new Locale(LocaleInfo.LOCALE_DEFAULT);
	private long localNow = System.currentTimeMillis();
	private int firstDayOfWeek = Calendar.MONDAY;
	public LocalDate(){
		super();
		super.setTime(super.getTime()-hostTimeZone.getRawOffset());
		try {
			User user = SmartUtil.getCurrentUser();
			if(user.getTimeZone()!=null && isValidTimeZone(user.getTimeZone()))
				this.timeZone = TimeZone.getTimeZone(user.getTimeZone());
			if(user.getLocale()!=null && LocaleInfo.isSupportingLocale(user.getLocale()))
				this.locale = new Locale(user.getLocale());
		} catch (Exception e) {}
	}
	public LocalDate(long GMTDate){
		super(GMTDate);
		try {
			User user = SmartUtil.getCurrentUser();
			if(user.getTimeZone()!=null && isValidTimeZone(user.getTimeZone()))
				this.timeZone = TimeZone.getTimeZone(user.getTimeZone());
			if(user.getLocale()!=null && LocaleInfo.isSupportingLocale(user.getLocale()))
				this.locale = new Locale(user.getLocale());
		} catch (Exception e) {}
	}
	
	public LocalDate(long GMTDate, String timeZone, String locale){
		super(GMTDate);
		if(isValidTimeZone(timeZone))
			this.setTimeZone(timeZone);
		if(LocaleInfo.isSupportingLocale(locale))
			this.setLocale(locale);
	}
	
	public String getLocale(){
		return locale.toString();
	}
	public void setLocale(String locale){
		if(LocaleInfo.isSupportingLocale(locale)){
			this.locale = new Locale(locale);
		}
	}
	public long getLocalDate(){
		return super.getTime() + this.timeZone.getRawOffset();
	}

	public long getGMTDate(){
		return super.getTime();
	}
	public void setGMTDate(long GMTDate){
		super.setTime(GMTDate);
	}
	public String getTimeZone(){
		if(timeZone == null)
			return null;
		return timeZone.getID();
	}
	public void setTimeZone(String timeZone){
		if(LocalDate.isValidTimeZone(timeZone)){
			this.timeZone = TimeZone.getTimeZone(timeZone);
		}
	}	
	public int getFirstDayOfWeek() {
		return firstDayOfWeek;
	}
	public void setFirstDayOfWeek(int firstDayOfWeek) {
		this.firstDayOfWeek = firstDayOfWeek;
	}
	public int getMonth(){
		Calendar cal = Calendar.getInstance(this.timeZone, this.locale);
		cal.setTime(new Date(this.getLocalDate()));
		return cal.get(Calendar.MONTH);
	}

	public int getYear(){
		Calendar cal = Calendar.getInstance(this.timeZone, this.locale);
		cal.setTime(new Date(this.getLocalDate()));
		return cal.get(Calendar.YEAR);		
	}
	
	public int getWeekOfMonth(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(this.getLocalDate()));
		cal.setFirstDayOfWeek(this.firstDayOfWeek);
		cal.setMinimalDaysInFirstWeek(7);
		return cal.get(Calendar.WEEK_OF_MONTH);		
	}
	
	public int getWeekOfYear(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(this.getLocalDate()));
		cal.setFirstDayOfWeek(this.firstDayOfWeek);
		cal.setMinimalDaysInFirstWeek(7);
		return cal.get(Calendar.WEEK_OF_YEAR);		
	}
	
	public int getDayOfWeek(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(this.getLocalDate()));
		cal.setFirstDayOfWeek(this.firstDayOfWeek);
		cal.setMinimalDaysInFirstWeek(7);
		return cal.get(Calendar.DAY_OF_WEEK);		
	}
	
	public String toLocalString(){
		if(isToday()){
			return (new SimpleDateFormat("HH:mm")).format(getLocalTime());
		}else if(isThisYear()){
			return (new SimpleDateFormat("MM.dd HH:mm")).format(getLocalTime());
		}
		return (new SimpleDateFormat("yyyy.MM.dd HH:mm")).format(getLocalTime());			
	}

	public String toLocalDateString(){
		return DateFormat.getDateInstance(DateFormat.FULL, this.locale).format(getLocalTime());
	}
	
	public String toLocalMonthFullString(){
		return (new SimpleDateFormat("yyyy MMMM", this.locale)).format(getLocalTime());		
	}
	
	public String toLocalYearString(){
		return (new SimpleDateFormat("yyyy", this.locale)).format(getLocalTime());		
	}
	
	public String toLocalMonthShortString(){
		return (new SimpleDateFormat("MMM", this.locale)).format(getLocalTime());		
	}
	
	public String toLocalDateShortString(){
		return (new SimpleDateFormat("MM.dd E", this.locale)).format(getLocalTime());
	}

	public String toLocalDateSimpleString(){
		return (new SimpleDateFormat("yyyy.MM.dd", this.locale)).format(getLocalTime());
	}

	public String toLocalDateSimple2String(){
		return (new SimpleDateFormat("yyyy-MM-dd", this.locale)).format(getLocalTime());
	}

	public String toLocalDateLongString(){
		return (new SimpleDateFormat("yyyy.MM.dd E", this.locale)).format(getLocalTime());
	}

	public String toLocalMonthString(){
		return (new SimpleDateFormat("yyyy.MM", this.locale)).format(getLocalTime());
	}

	public String toLocalDateTimeSimpleString(){
		return (new SimpleDateFormat("yyyy.MM.dd HH:mm", this.locale)).format(getLocalTime());
	}

	public String toLocalDateValue(){
		return (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", this.locale)).format(getLocalTime());
	}

	public String toLocalDateString2(){
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", this.locale)).format(getLocalTime());
	}

	public String toGMTDateString(){
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(getGMTDate());
	}

	public String toGMTSimpleDateString(){
		return (new SimpleDateFormat("yyyy-MM-dd")).format(getGMTDate());
	}

	public String toGMTTimeString(){
		return (new SimpleDateFormat("HH:mm:ss")).format(getGMTDate());
	}

	public String toLocalTimeString(){
		return DateFormat.getTimeInstance(DateFormat.MEDIUM, this.locale).format(getLocalTime());
	}

	public String toLocalTimeSimpleString(){
		return (new SimpleDateFormat("HH:mm:ss")).format(getLocalTime());
	}

	public String toLocalTimeShortString(){
		return (new SimpleDateFormat("HH:mm")).format(getLocalTime());
	}
	
	public void plusToGMTTime(long timeValue){
		this.setTime(this.getTime() + timeValue);
	}

	public boolean isSameDate(LocalDate when){
		if( getLocalDateOnly(this).getTime() == getLocalDateOnly(when).getTime()) return true;
		return false;
	}

	public boolean isBeforeDate(LocalDate when){
		if( getLocalDateOnly(this).getTime() > getLocalDateOnly(when).getTime()) return true;
		
		return false;
	}

	public boolean isAfterDate(LocalDate when){
		if(getLocalDateOnly(this).getTime() < getLocalDateOnly(when).getTime()) return true;
		return false;
	}
	
	public static long getDiffDate(Date fromDate, Date toDate){
		if(fromDate==null || toDate==null) return 0;
		return (toDate.getTime() - fromDate.getTime())/LocalDate.ONE_DAY;		
	}
	
	public long getLocalTime(){
		if(this.timeZone == null){
			return super.getTime() + TimeZone.getDefault().getRawOffset();
		}else{
			return super.getTime() + this.timeZone.getRawOffset();
		}
	}
	
	public static boolean isValidTimeZone(String timeZone){
		String[] zoneIds = TimeZone.getAvailableIDs();
		for(String str : zoneIds)
			if(str.equals(timeZone)) return true;
		return false;
		
	}	
	
	public static String convertTimeToString(long time){
		return (new SimpleDateFormat("HH:mm")).format(time - TimeZone.getDefault().getRawOffset());
	}
	public static Date convertLocalToGMT(long localDate, String timeZone){
		if(isValidTimeZone(timeZone))
			return new Date(localDate - TimeZone.getTimeZone(timeZone).getRawOffset());
		return new Date(localDate);
	}
	public static Date convertGMTToLocal(long GMTDate, String timeZone){
		if(isValidTimeZone(timeZone))
			return new Date(GMTDate + TimeZone.getTimeZone(timeZone).getRawOffset());
		return new Date(GMTDate);
	}

	public static Date convertStringToDate(String yyyyMMddHHmm) throws Exception{
		if(SmartUtil.isBlankObject(yyyyMMddHHmm) || yyyyMMddHHmm.length()!=12) return null;
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
		return df.parse(yyyyMMddHHmm);					
	}

	public static Date convertStringToDateTime(String yyyyMMddHHmm) throws Exception{
		if(SmartUtil.isBlankObject(yyyyMMddHHmm) || yyyyMMddHHmm.length()!=14) return null;
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.parse(yyyyMMddHHmm);					
	}

	public static LocalDate convertLocalStringToLocalDate(String yyyyMMddHHmmssSSS) throws Exception{
		if(SmartUtil.isBlankObject(yyyyMMddHHmmssSSS) || yyyyMMddHHmmssSSS.length() < 21) return null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return new LocalDate((df.parse(yyyyMMddHHmmssSSS)).getTime() - TimeZone.getTimeZone(SmartUtil.getCurrentUser().getTimeZone()).getRawOffset());					
	}

	public static LocalDate convertLocalDateTimeStringToLocalDate(String yyyyMMddHHmm) throws Exception{
		if(SmartUtil.isBlankObject(yyyyMMddHHmm) || yyyyMMddHHmm.length()!=16) return null;
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		return new LocalDate((df.parse(yyyyMMddHHmm)).getTime() - TimeZone.getTimeZone(SmartUtil.getCurrentUser().getTimeZone()).getRawOffset());					
	}

	public static LocalDate convertLocalDateStringToLocalDate(String yyyyMMdd) throws Exception{
		if(SmartUtil.isBlankObject(yyyyMMdd) || yyyyMMdd.length()!=10) return null;
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
		return new LocalDate((df.parse(yyyyMMdd)).getTime() - TimeZone.getTimeZone(SmartUtil.getCurrentUser().getTimeZone()).getRawOffset());					
	}

	public static LocalDate convertLocalYearStringToLocalDate(String yyyy) throws Exception{
		if(SmartUtil.isBlankObject(yyyy) || yyyy.length()!=4) return null;
		DateFormat df = new SimpleDateFormat("yyyy");
		return new LocalDate((df.parse(yyyy)).getTime() - TimeZone.getTimeZone(SmartUtil.getCurrentUser().getTimeZone()).getRawOffset());					
	}

	public static LocalDate convertLocalTimeStringToLocalDate(String HHmm) throws Exception{
		if(SmartUtil.isBlankObject(HHmm) || HHmm.length()!=4) return null;
		DateFormat df = new SimpleDateFormat("HH:mm");
		return new LocalDate((df.parse(HHmm)).getTime() - TimeZone.getTimeZone(SmartUtil.getCurrentUser().getTimeZone()).getRawOffset());					
	}

	public static LocalDate convertGMTStringToLocalDate(String yyyyMMddHHmmssSSS) throws Exception{
		if(SmartUtil.isBlankObject(yyyyMMddHHmmssSSS) || yyyyMMddHHmmssSSS.length() < 21) return null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return new LocalDate((df.parse(yyyyMMddHHmmssSSS)).getTime());
	}

	public static LocalDate convertGMTSimpleStringToLocalDate(String yyyyMMdd) throws Exception{
		if(SmartUtil.isBlankObject(yyyyMMdd) || yyyyMMdd.length()!=10) return null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return new LocalDate((df.parse(yyyyMMdd)).getTime());					
	}

	public static LocalDate convertGMTTimeStringToLocalDate(String HHmmss) throws Exception{
		if(SmartUtil.isBlankObject(HHmmss) || HHmmss.length()!=5) return null;
		DateFormat df = new SimpleDateFormat("HH:mm");
		return new LocalDate((df.parse(HHmmss)).getTime());
	}

	public static LocalDate convertLocalString2ToLocalDate(String yyyyMMddHHmmssSS) throws Exception{
		if(SmartUtil.isBlankObject(yyyyMMddHHmmssSS) || yyyyMMddHHmmssSS.length()!=19) return null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return new LocalDate((df.parse(yyyyMMddHHmmssSS)).getTime() - TimeZone.getTimeZone(SmartUtil.getCurrentUser().getTimeZone()).getRawOffset());					
	}

	public static LocalDate convertStringToLocalDate(String yyyyMMddHHmm) throws Exception{
		if(SmartUtil.isBlankObject(yyyyMMddHHmm) || yyyyMMddHHmm.length()!=16) return null;
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		return new LocalDate((df.parse(yyyyMMddHHmm)).getTime() - TimeZone.getTimeZone(SmartUtil.getCurrentUser().getTimeZone()).getRawOffset());
	}

	public static LocalDate convertLocalMonthStringToLocalDate(String yyyyMM) throws Exception{
		if(SmartUtil.isBlankObject(yyyyMM) || (yyyyMM.length()!=7 && yyyyMM.length()!=10)) return null;
		DateFormat df = new SimpleDateFormat("yyyy.MM");
		if(yyyyMM.length() == 10) df = new SimpleDateFormat("yyyy.MM.dd"); 
		return new LocalDate((df.parse(yyyyMM)).getTime() - TimeZone.getTimeZone(SmartUtil.getCurrentUser().getTimeZone()).getRawOffset());
	}

	public static LocalDate convertLocalMonthWithDiffMonth(LocalDate localDate, int diffMonth) throws Exception{
		int toMonth = localDate.getMonth() + diffMonth;
		int toYear = localDate.getYear();
		while(toMonth < 0 || toMonth > 11){
			if(toMonth < 0){
				toYear--;
				toMonth = toMonth+12;
			}else{
				toYear++;
				toMonth = toMonth-12;
			}
		}
		return convertLocalMonthStringToLocalDate(String.format("%04d", toYear) + "." + String.format("%02d", toMonth+1));
	}

	public static long convertStringToTime(String yyyyMMddHHmm) throws Exception{
		return convertStringToDate(yyyyMMddHHmm).getTime();					
	}

	public static long convertTimeStringToTime(String HHmm) throws Exception{
		if(SmartUtil.isBlankObject(HHmm) || HHmm.length()!=5) return 0;
		DateFormat df = new SimpleDateFormat("HH:mm");
		return df.parse(HHmm).getTime();					
	}

	public static KeyMap[] getAvailableTimeZoneNames(String locale) throws Exception{
		String[] timeZoneIds = TimeZone.getAvailableIDs();
		KeyMap[] timeZoneNames = new KeyMap[timeZoneIds.length];
		for(int i=0; i<timeZoneIds.length; i++){
			timeZoneNames[i] = new KeyMap(timeZoneIds[i], TimeZone.getTimeZone(timeZoneIds[i]).getDisplayName(new Locale(locale)));
		}
		return timeZoneNames;
	}
	
	private boolean isToday(){
		if(getLocalDateOnly(this).getTime() == getLocalDateOnly(new LocalDate(localNow)).getTime())
			return true;
		return false;
	}

	private boolean isThisYear(){
		if(getLocalYearOnly(this).getTime() == getLocalYearOnly(new LocalDate(localNow)).getTime())
			return true;
		return false;
	}

	private LocalDate getLocalDateOnly(LocalDate localDate){
		LocalDate lDate = null;
		try{
			lDate =  LocalDate.convertLocalDateStringToLocalDate(localDate.toLocalDateSimpleString());
		}catch (Exception e){
		}
		return lDate;
	}

	private LocalDate getLocalYearOnly(LocalDate localDate){
		LocalDate lDate = null;
		try{
			lDate =  LocalDate.convertLocalYearStringToLocalDate(localDate.toLocalYearString());
		}catch (Exception e){
		}
		return lDate;

	}
}
