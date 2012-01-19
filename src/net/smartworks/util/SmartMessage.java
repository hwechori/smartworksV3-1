
package net.smartworks.util;

import java.text.MessageFormat;
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

	public static String getString(String key, Object[] params){
		try{
			ResourceBundle res = ResourceBundle.getBundle("resource/smartworksMessage", new Locale(SmartUtil.getCurrentUser().getLocale()));
			String pattern = res.getString(key);
			if(SmartUtil.isBlankObject(params)) return pattern;
			MessageFormat mf = new MessageFormat("");
			mf.setLocale(new Locale(SmartUtil.getCurrentUser().getLocale()));
			mf.applyPattern(pattern);
			return mf.format(params);
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