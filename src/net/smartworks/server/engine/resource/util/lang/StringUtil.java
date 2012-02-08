package net.smartworks.server.engine.resource.util.lang;

/**
 * StringUtil
 * 
 * @author jhnam
 * @version $Id: StringUtil.java,v 1.1 2011/11/08 03:15:11 kmyu Exp $
 */
public class StringUtil {

	/**
	 * value가 null이면 빈 스트링 값 "" 을 넘겨주고 그렇지 않다면 value를 넘겨준다.
	 * 
	 * @param value
	 * @return
	 */
	public static String toNotNull(String value) {
		return value == null ? "" : value;
	}
	
	/**
	 * value가 null이라면 defaultValue를 넘겨주고 그렇지 않다면 value를 넘겨준다.
	 * 
	 * @param defaultValue
	 * @param value
	 * @return
	 */
	public static String toNotNull(String defaultValue, String value) {
		return value == null ? defaultValue : value;
	}
	
	/**
	 * intValue를 정수값으로 변환한다. 만일 값이 null이거나 없다면 defaultValue를 리턴한다.
	 * 
	 * @param intValue
	 * @param defaultValue
	 * @return
	 */
	public static int getIntValue(String intValue, int defaultValue) {
		
		if(intValue == null || intValue.equals("") || intValue.equals("null"))
			return defaultValue;

		return Integer.parseInt(intValue);
	}
	
}
