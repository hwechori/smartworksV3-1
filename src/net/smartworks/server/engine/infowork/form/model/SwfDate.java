/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 7.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.infowork.form.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class SwfDate extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwfDate.class);
	
	protected static final String PREFIX = "Swf";
	private static final String NAME = CommonUtil.toName(SwfDate.class, PREFIX);

	public static final String A_YEARUSE = "yearUse";
	public static final String A_SUNNOTUSE = "sunNotUse";
	public static final String A_MONNOTUSE = "monNotUse";
	public static final String A_TUENOTUSE = "tueNotUse";
	public static final String A_WEDNOTUSE = "wedNotuse";
	public static final String A_THUNOTUSE = "thuNotUse";
	public static final String A_FRINOTUSE = "friNotUse";
	public static final String A_SATNOTUSE = "satNotUse";
	
	private boolean yearUse;
	private boolean sunNotUse;
	private boolean monNotUse;
	private boolean tueNotUse;
	private boolean wedNotUse;
	private boolean thuNotUse;
	private boolean friNotUse;
	private boolean satNotUse;
	public SwfDate() {
		super();
	}
	public String toString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toLiteString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toLiteString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_YEARUSE, yearUse, buf);
		appendAttributeString(A_SUNNOTUSE, sunNotUse, buf);
		appendAttributeString(A_MONNOTUSE, monNotUse, buf);
		appendAttributeString(A_TUENOTUSE, tueNotUse, buf);
		appendAttributeString(A_WEDNOTUSE, wedNotUse, buf);
		appendAttributeString(A_THUNOTUSE, thuNotUse, buf);
		appendAttributeString(A_FRINOTUSE, friNotUse, buf);
		appendAttributeString(A_SATNOTUSE, satNotUse, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwfDate obj = null;
		if (baseObj == null || !(baseObj instanceof SwfDate))
			obj = new SwfDate();
		else
			obj = (SwfDate)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node yearUse = attrMap.getNamedItem(A_YEARUSE);
			Node sunNotUse = attrMap.getNamedItem(A_SUNNOTUSE);
			Node monNotUse = attrMap.getNamedItem(A_MONNOTUSE);
			Node tueNotUse = attrMap.getNamedItem(A_TUENOTUSE);
			Node wedNotUse = attrMap.getNamedItem(A_WEDNOTUSE);
			Node thuNotUse = attrMap.getNamedItem(A_THUNOTUSE);
			Node friNotUse = attrMap.getNamedItem(A_FRINOTUSE);
			Node satNotUse = attrMap.getNamedItem(A_SATNOTUSE);
			if (yearUse != null)
				obj.setYearUse(CommonUtil.toBoolean(yearUse.getNodeValue()));
			if (sunNotUse != null)
				obj.setSunNotUse(CommonUtil.toBoolean(sunNotUse.getNodeValue()));
			if (monNotUse != null)
				obj.setMonNotUse(CommonUtil.toBoolean(monNotUse.getNodeValue()));
			if (tueNotUse != null)
				obj.setTueNotUse(CommonUtil.toBoolean(tueNotUse.getNodeValue()));
			if (wedNotUse != null)
				obj.setWedNotUse(CommonUtil.toBoolean(wedNotUse.getNodeValue()));
			if (thuNotUse != null)
				obj.setThuNotUse(CommonUtil.toBoolean(thuNotUse.getNodeValue()));
			if (friNotUse != null)
				obj.setFriNotUse(CommonUtil.toBoolean(friNotUse.getNodeValue()));
			if (satNotUse != null)
				obj.setSatNotUse(CommonUtil.toBoolean(satNotUse.getNodeValue()));
		}
		
		// elements 값 설정
		
		return obj;
	}
	public static BaseObject toObject(String str) throws Exception {
		if (str == null)
			return null;
		Document doc = XmlUtil.toDocument(str);
		if (doc == null)
			return null;
		return toObject(doc.getDocumentElement(), null);
	}
	public static SwfDate[] add(SwfDate[] objs, SwfDate obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwfDate[] newObjs = new SwfDate[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwfDate[] remove(SwfDate[] objs, SwfDate obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwfDate[] newObjs = new SwfDate[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwfDate[] left(SwfDate[] objs, SwfDate obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx < 1)
			return objs;
		SwfDate[] newObjs = new SwfDate[objs.length];
		for (int i=0; i<objs.length; i++) {
			if (i == idx) {
				newObjs[i] = objs[idx-1];
				continue;
			} else if (i == idx-1) {
				newObjs[i] = objs[idx];
				continue;
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public static SwfDate[] right(SwfDate[] objs, SwfDate obj) {
		if (objs == null || objs.length == 0 || obj == null)
			return objs;
		int idx = -1;
		for (int i=0; i<objs.length; i++) {
			if (!objs[i].equals(obj))
				continue;
			idx = i;
			break;
		}
		if (idx == -1 || idx+1 == objs.length)
			return objs;
		SwfDate[] newObjs = new SwfDate[objs.length];
		for (int i=0; i<objs.length; i++) {
			if (i == idx) {
				newObjs[i] = objs[idx+1];
				continue;
			} else if (i == idx+1) {
				newObjs[i] = objs[idx];
				continue;
			}
			newObjs[i] = objs[i];
		}
		return newObjs;
	}
	public Object clone() throws CloneNotSupportedException {
		try {
			return toObject(this.toString());
		} catch (Exception e) {
			logger.warn(e, e);
			return null;
		}
	}
	public boolean isFriNotUse() {
		return friNotUse;
	}
	public void setFriNotUse(boolean friNotUse) {
		this.friNotUse = friNotUse;
	}
	public boolean isMonNotUse() {
		return monNotUse;
	}
	public void setMonNotUse(boolean monNotUse) {
		this.monNotUse = monNotUse;
	}
	public boolean isSatNotUse() {
		return satNotUse;
	}
	public void setSatNotUse(boolean satNotUse) {
		this.satNotUse = satNotUse;
	}
	public boolean isSunNotUse() {
		return sunNotUse;
	}
	public void setSunNotUse(boolean sunNotUse) {
		this.sunNotUse = sunNotUse;
	}
	public boolean isThuNotUse() {
		return thuNotUse;
	}
	public void setThuNotUse(boolean thuNotUse) {
		this.thuNotUse = thuNotUse;
	}
	public boolean isTueNotUse() {
		return tueNotUse;
	}
	public void setTueNotUse(boolean tueNotUse) {
		this.tueNotUse = tueNotUse;
	}
	public boolean isWedNotUse() {
		return wedNotUse;
	}
	public void setWedNotUse(boolean wedNotuse) {
		this.wedNotUse = wedNotuse;
	}
	public boolean isYearUse() {
		return yearUse;
	}
	public void setYearUse(boolean yearUse) {
		this.yearUse = yearUse;
	}

}