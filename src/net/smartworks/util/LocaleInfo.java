package net.smartworks.util;

public class LocaleInfo {

	public final static String LOCALE_KOREAN = "ko";
	public final static String LOCALE_ENGLISH = "en";
	public final static String LOCALE_DEFAULT = "ko";
	public final static String LOCALE_GENERAL = "en";
	
	private final static String[] supportingLocales = new String[] { "ko", "en"};
	
	public static boolean isSupportingLocale(String locale){
		for(String str : supportingLocales)
			if(str.equals(locale)) return true;
		return false;
	}
}
