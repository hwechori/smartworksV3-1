package net.smartworks.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	public final static long ONE_YEAR = 365*ONE_DAY;
	
	public final static String TIMEZONE_SEOUL = "Asia/Seoul";
	public final static String TIMEZONE_LOS_ANGELES = "America/Los_Angeles";

	private static final long serialVersionUID = 1L;
	private TimeZone timeZone = TimeZone.getDefault();
	private TimeZone hostTimeZone = TimeZone.getDefault();
	private Locale locale = new Locale(LocaleInfo.LOCALE_DEFAULT);
	private long localNow = System.currentTimeMillis();
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
	
	public String toLocalDateShortString(){
		return (new SimpleDateFormat("MM.dd E", this.locale)).format(getLocalTime());
	}
	
	public String toLocalDateSimpleString(){
		return (new SimpleDateFormat("yyyy.MM.dd", this.locale)).format(getLocalTime());
	}

	public String toLocalDateSimpleDashString(){
		return (new SimpleDateFormat("yyyy-MM-dd", this.locale)).format(getLocalTime());
	}
	
	public String toLocalDateTimeSimpleString(){
		return (new SimpleDateFormat("yyyy.MM.dd HH:mm", this.locale)).format(getLocalTime());
	}
	
	public String toLocalDateValue(){
		return (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", this.locale)).format(getLocalTime());
	}
	
	public String toGMTDateString(){
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(getGMTDate());
	}
	
	public String toLocalTimeString(){
		return DateFormat.getTimeInstance(DateFormat.MEDIUM, this.locale).format(getLocalTime());
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
		return (new SimpleDateFormat("HH:mm")).format(time);
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
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
		return df.parse(yyyyMMddHHmm);					
	}
	
	public static LocalDate convertValueToLocalDate(String yyyyMMddHHmmssSSS) throws Exception{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return new LocalDate((df.parse(yyyyMMddHHmmssSSS)).getTime() - TimeZone.getTimeZone(SmartUtil.getCurrentUser().getTimeZone()).getRawOffset());					
	}
	
	public static LocalDate convertStringToLocalDate(String yyyyMMddHHmm) throws Exception{
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		return new LocalDate((df.parse(yyyyMMddHHmm)).getTime() - TimeZone.getTimeZone(SmartUtil.getCurrentUser().getTimeZone()).getRawOffset());
	}
	
	public static long convertStringToTime(String yyyyMMddHHmm) throws Exception{
		return convertStringToDate(yyyyMMddHHmm).getTime();					
	}
	
	public static long convertTimeStringToTime(String HHmm) throws Exception{
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

		long time = localDate.getLocalTime();
		time = time/LocalDate.ONE_DAY;
		time = time*LocalDate.ONE_DAY;
		LocalDate lDate = new LocalDate(time-localDate.timeZone.getRawOffset());
		lDate.setTimeZone(localDate.getTimeZone());
		return lDate;

	}

	private LocalDate getLocalYearOnly(LocalDate localDate){

		long time = localDate.getLocalTime();
		time = time/LocalDate.ONE_YEAR;
		time = time*LocalDate.ONE_YEAR;
		LocalDate lDate = new LocalDate(time-localDate.timeZone.getRawOffset());
		lDate.setTimeZone(localDate.getTimeZone());
		return lDate;

	}	
}
