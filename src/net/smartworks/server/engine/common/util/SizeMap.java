/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.common.util;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class SizeMap extends Hashtable {

	private static final long serialVersionUID = 1L;
	public static final String REPLACEMENTTYPE_LRU = "LRU";
	private int maxSize = -1;
	private String replacementType = REPLACEMENTTYPE_LRU;
	
	private Map inverseMap;
	private Map synchronizedMap;
	
	private List keyList = new Vector();

	public SizeMap() {
		super();
	}
	public SizeMap(int size) {
		super(size);
		this.setMaxSize(size);
	}
	
	public synchronized void clear() {
		while (!keyList.isEmpty())
			remove(keyList.get(0));
		super.clear();
	}
	
	public synchronized Object get(Object key) {
		Object res = super.get(key);
		if (maxSize == -1)
			return res;
		if (res != null) {
			keyList.remove(key);
			keyList.add(key);
		}
		return res;
	}
	public synchronized Object put(Object key, Object value) {
		Object res = super.put(key, value);
		if (maxSize == -1)
			return res;
		if (keyList.contains(key))
			keyList.remove(key);
		keyList.add(key);
		if (super.size() > maxSize) {
			Object oldKey = keyList.get(0);
			this.remove(oldKey);
		}
		return res;
	}
	public Object remove(Object key) {
		Object res = super.remove(key);
		if (keyList.contains(key))
			keyList.remove(key);
		if (res == null)
			return res;
		
		if (synchronizedMap != null && synchronizedMap.containsKey(key))
			synchronizedMap.remove(key);
		
		if (inverseMap != null && !inverseMap.isEmpty()) {
			if (res instanceof Object[]) {
				Object[] values = (Object[])res;
				if (values.length != 0) {
					String valueClassName = values[0].getClass().getName();
					Iterator inverseItr = inverseMap.keySet().iterator();
					String inverseKeyClassName = inverseItr.next().getClass().getName();
					if (valueClassName.equals(inverseKeyClassName)) {
						for (int i=0; i<values.length; i++) {
							Object oldValueObj = values[i];
							if (inverseMap.containsKey(oldValueObj))
								inverseMap.remove(oldValueObj);
						}
					}
				}
			} else {
				if (inverseMap.containsKey(res)) {
					inverseMap.remove(res);
				} else if (inverseMap.containsValue(key)) {
					for (Iterator inverseKeyItr = inverseMap.keySet().iterator(); inverseKeyItr.hasNext();) {
						Object inverseKey = inverseKeyItr.next();
						Object inverseValue = inverseMap.get(inverseKey);
						if (inverseValue instanceof Object[]) {
							Object[] values = (Object[])inverseValue;
							if (values.length != 0) {
								for (int i=0; i<values.length; i++) {
									Object value = values[i];
									if (value.equals(key)) {
										inverseMap.remove(inverseKey);
										return res;
									}
								}
							}
						} else {
							if (inverseValue.equals(key)) {
								inverseMap.remove(inverseKey);
								return res;
							}
						}
					}
				}
			}
		}
		
		return res;
	}
	public boolean containsValue(Object obj) {
		boolean res = super.containsValue(obj);
		
		if (!res && inverseMap != null) {
			if (isEmpty())
				return res;
			
			for (Iterator valueItr = this.values().iterator(); valueItr.hasNext();) {
				Object v = valueItr.next();
				if (!(v instanceof Object[])) {
					break;
				}
				Object[] values = (Object[])v;
				if (values.length != 0) {
					for (int i=0; i<values.length; i++) {
						Object value = values[i];
						if (value.equals(obj))
							return true;
					}
				}
			}
		}
		
		return res;
	}

	public String getReplacementType() {
		return replacementType;
	}
	public void setReplacementType(String replacementType) {
		this.replacementType = replacementType;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int size) {
		this.maxSize = size;
	}
	public Map getInverseMap() {
		return inverseMap;
	}
	public void setInverseMap(Map inverseMap) {
		this.inverseMap = inverseMap;
	}
	public Map getSynchronizedMap() {
		return synchronizedMap;
	}
	public void setSynchronizedMap(Map synchronizedMap) {
		this.synchronizedMap = synchronizedMap;
	}

}