/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2012. 1. 16.
 * =========================================================
 * Copyright (c) 2012 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.util;

public class StringUtil {

	public StringUtil() {
		super();
	} 

	/**
	 * 문자 자르기, 생략 문자는 tag로 표기
	 * @param str
	 * @param startPoint
	 * @param endPoint
	 * @param tag
	 * @return
	 */
	public static String subString(String str, int startPoint, int endPoint, String tag) {

		for(int i=0; i<str.length(); i++) {
		    if(Character.getType(str.charAt(i)) != 5) {
		    	endPoint = endPoint + 1;
		    }
		}

		if(str.length() > endPoint)
			str = str.substring(startPoint, endPoint) + tag;

		return str; 
	}

}