
package net.smartworks.util;

import java.net.URLEncoder;
import java.util.Locale;
import java.util.ResourceBundle;

public class SmartMessage {

	public static String getString(String key){
		try{
			ResourceBundle res = ResourceBundle.getBundle("resource/smartworksMessage", new Locale(SmartUtil.getCurrentUser().getLocale()));
			return res.getString(key);
		}catch(Exception e){
			
		}
		return "";
	}
	
	public static String[] getStringArray(String key){
		try{
			ResourceBundle res = ResourceBundle.getBundle("resource/smartworksMessage", new Locale(SmartUtil.getCurrentUser().getLocale()));
			return res.getStringArray(key);
		}catch(Exception e){
			
		}
		return null;
	}

	public static Object getObject(String key){
		try{
			ResourceBundle res = ResourceBundle.getBundle("resource/smartworksMessage", new Locale(SmartUtil.getCurrentUser().getLocale()));
			return res.getObject(key);
		}catch(Exception e){
			
		}
		return null;
	}
}