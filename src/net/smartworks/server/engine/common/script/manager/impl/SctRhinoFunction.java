/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.script.manager.impl;

import java.util.Date;

import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.ScriptableObject;

public class SctRhinoFunction extends ScriptableObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SctRhinoFunction.class);
	public static final String CLASSNAME = CommonUtil.toClassName(SctRhinoFunction.class);
	
	private Object context;
	public SctRhinoFunction() {		
	}
	public SctRhinoFunction(Object context) {
		this.context = context;
	}
	public Object getContext() {
		return context;
	}
	public void setContext(Object context) {
		this.context = context;
	}
	public String getClassName() {
		return CLASSNAME;
	}

	public Object jsFunction_getContext() {
		return this.context;
	}
	
	public Object jsFunction_getDate() {
		return new Date();
	}
	
	public String jsFunction_toXsdDateTimeString(Object obj) {
		if (obj == null)
			return null;
		if (obj instanceof NativeJavaObject) {
			NativeJavaObject resObj = (NativeJavaObject)obj;
			obj = resObj.unwrap();
		}
		if (!(obj instanceof Date))
			return null;
		return DateUtil.toXsdDateTimeString((Date) obj);
	}
	
	public Object jsFunction_toDate(Object obj) {
		if (obj == null)
			return null;
		if (obj instanceof NativeJavaObject)
			obj = ((NativeJavaObject)obj).unwrap();
		if (obj instanceof Date) {
			return (Date)obj;
		}
		try {
			String dateStr = obj.toString();
			return DateUtil.toDate(dateStr);
		} catch (Exception e) {
			logger.error(e, e);
		}
		return null;
	}
	public long jsFunction_diffDate(Object from, Object to) {
		if (from == null || to == null)
			return 0;
		Date fromDate = (Date)jsFunction_toDate(from);
		Date toDate = (Date)jsFunction_toDate(to);
		if (fromDate == null || toDate == null)
			return 0;
		long interval = toDate.getTime() - fromDate.getTime();
		if (interval < 0)
			interval = -interval;
		return interval;
	}
	
	public int jsFunction_toInt(Object obj) {
		if (obj == null)
			return 0;
		if (obj instanceof NativeJavaObject)
			obj = ((NativeJavaObject)obj).unwrap();
		if (obj instanceof String) {
			return Integer.parseInt((String)obj);
		} else if (obj instanceof Integer) {
			return ((Integer)obj).intValue();
		} else if (obj instanceof Double) {
			return (int)((Double)obj).doubleValue();
		} else if (obj instanceof Long) {
			return (int)((Long)obj).longValue();
		}
		return 0;
	}
	public long jsFunction_toLong(Object obj) {
		if (obj == null)
			return 0;
		if (obj instanceof NativeJavaObject)
			obj = ((NativeJavaObject)obj).unwrap();
		if (obj instanceof String) {
			return Long.parseLong((String)obj);
		} else if (obj instanceof Integer) {
			return ((Integer)obj).intValue();
		} else if (obj instanceof Double) {
			return (long)((Double)obj).doubleValue();
		} else if (obj instanceof Long) {
			return ((Long)obj).longValue();
		}
		return 0;
	}
	public double jsFunction_toDouble(Object obj) {
		if (obj == null)
			return 0;
		if (obj instanceof NativeJavaObject)
			obj = ((NativeJavaObject)obj).unwrap();
		if (obj instanceof String) {
			return Double.parseDouble((String)obj);
		} else if (obj instanceof Integer) {
			return ((Integer)obj).intValue();
		} else if (obj instanceof Double) {
			return ((Double)obj).doubleValue();
		} else if (obj instanceof Long) {
			return ((Long)obj).longValue();
		}
		return 0;
	}

}