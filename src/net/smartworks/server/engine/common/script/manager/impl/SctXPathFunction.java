/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.script.manager.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;

public class SctXPathFunction implements Function, Functions {

	protected String prefix = "mis";
	protected String methodName;

	/* (non-Javadoc)
	 * @see org.apache.commons.jxpath.Function#invoke(org.apache.commons.jxpath.ExpressionContext, java.lang.Object[])
	 */
	public Object invoke(ExpressionContext context, Object[] params) {
		Object value = null;
		
		if(methodName.equals("toInt")) {
			if (params.length == 0)
				return new Integer(0);
			value = toInt(params[0]);
		} else if(methodName.equals("toDouble")) {
			if (params.length == 0)
				return new Double(0);
			value = toDouble(params[0].toString());
		} else if(methodName.equals("toBoolean")) {
			if (params.length == 0)
				return new Boolean(false);
			value = toBoolean(params[0].toString());
		} else if(methodName.equals("toFloat")) {
			if (params.length == 0)
				return new Float(0);
			value = toFloat(params[0].toString());
		} else if(methodName.equals("toLong")) {
			if (params.length == 0)
				return new Long(0);
			value = toLong(params[0].toString());
		} else if(methodName.equals("toShort")) {
			if (params.length == 0)
				return new Short((short) 0);
			value = toShort(params[0].toString());
		} else if(methodName.equals("toDecimal")) {
			if (params.length == 0)
				return new BigDecimal(0);
			value = toDecimal(params[0].toString());
		} else {
			throw new RuntimeException("Undefined method : " + methodName);
		}
		
		return value;
	}

	public static Object toInt(Object value) {
		if (value instanceof String) {
			return new Integer(value.toString());
		} else if (value instanceof Double) {
			return new Integer(((Double)value).intValue());
		} else if(value instanceof Long) {
			return new Integer(((Long)value).intValue());
		} else if(value instanceof Float) {
			return new Integer(((Float)value).intValue());
		} else {
			return new Integer(value.toString());
		}
	}
	public static Object toDouble(String value) {
		Double doubleValue = new Double(value);
		return doubleValue;
	}
	public static Object toLong(String value) {
		Long longValue = new Long(value);
		return longValue;
	}
	public static Object toFloat(String value) {
		Float floatValue = new Float(value);
		return floatValue;
	}
	public static Object toShort(String value) {
		Short shortValue = new Short(value);
		return shortValue;
	}
	public static Object toDecimal(String value) {
		BigDecimal decimalValue = new BigDecimal(value);
		return decimalValue;
	}
	public static Object toBoolean(String value) {
		Boolean bool = null;
		try {
			bool = new Boolean(value);
		} catch (RuntimeException e) {
			bool = Boolean.FALSE;
		}
		return bool;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.jxpath.Functions#getFunction(java.lang.String, java.lang.String, java.lang.Object[])
	 */
	public Function getFunction(String namespace, String name, Object[] parameters) {
		if(!prefix.equals(namespace))
			return null;
		this.methodName = name;
		return this;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.jxpath.Functions#getUsedNamespaces()
	 */
	public Set getUsedNamespaces() {
		return Collections.singleton(prefix);
	}

	/**
	 * @param prefix The prefix to set.
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}