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

public class SwfNumeric extends BaseObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwfNumeric.class);
	
	protected static final String PREFIX = "Swf";
	private static final String NAME = CommonUtil.toName(SwfNumeric.class, PREFIX);

	public static final String A_MINNUMUSE = "minNumUse";
	public static final String A_MINNUM = "minNum";
	public static final String A_MAXNUMUSE = "maxNumUse";
	public static final String A_MAXNUM = "maxNum";
	public static final String A_STEPSIZE = "stepSize";
	
	private boolean minNumUse;
	private int minNum;
	private boolean maxNumUse;
	private int maxNum;
	private int stepSize;
	public SwfNumeric() {
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
		appendAttributeString(A_MINNUMUSE, minNumUse, buf);
		appendAttributeString(A_MINNUM, minNum, buf);
		appendAttributeString(A_MAXNUMUSE, maxNumUse, buf);
		appendAttributeString(A_MAXNUM, maxNum, buf);
		appendAttributeString(A_STEPSIZE, stepSize, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwfNumeric obj = null;
		if (baseObj == null || !(baseObj instanceof SwfNumeric))
			obj = new SwfNumeric();
		else
			obj = (SwfNumeric)baseObj;
		
		// 부모 attributes, elements 값 설정
		BaseObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node minNumUse = attrMap.getNamedItem(A_MINNUMUSE);
			Node minNum = attrMap.getNamedItem(A_MINNUM);
			Node maxNumUse = attrMap.getNamedItem(A_MAXNUMUSE);
			Node maxNum = attrMap.getNamedItem(A_MAXNUM);
			Node stepSize = attrMap.getNamedItem(A_STEPSIZE);
			if (minNumUse != null)
				obj.setMinNumUse(CommonUtil.toBoolean(minNumUse.getNodeValue()));
			if (minNum != null)
				obj.setMinNum(CommonUtil.toInt(minNum.getNodeValue()));
			if (maxNumUse != null)
				obj.setMaxNumUse(CommonUtil.toBoolean(maxNumUse.getNodeValue()));
			if (maxNum != null)
				obj.setMaxNum(CommonUtil.toInt(maxNum.getNodeValue()));
			if (stepSize != null)
				obj.setStepSize(CommonUtil.toInt(stepSize.getNodeValue()));
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
	public static SwfNumeric[] add(SwfNumeric[] objs, SwfNumeric obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwfNumeric[] newObjs = new SwfNumeric[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwfNumeric[] remove(SwfNumeric[] objs, SwfNumeric obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwfNumeric[] newObjs = new SwfNumeric[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwfNumeric[] left(SwfNumeric[] objs, SwfNumeric obj) {
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
		SwfNumeric[] newObjs = new SwfNumeric[objs.length];
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
	public static SwfNumeric[] right(SwfNumeric[] objs, SwfNumeric obj) {
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
		SwfNumeric[] newObjs = new SwfNumeric[objs.length];
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
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public boolean isMaxNumUse() {
		return maxNumUse;
	}
	public void setMaxNumUse(boolean maxNumUse) {
		this.maxNumUse = maxNumUse;
	}
	public int getMinNum() {
		return minNum;
	}
	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}
	public boolean isMinNumUse() {
		return minNumUse;
	}
	public void setMinNumUse(boolean minNumUse) {
		this.minNumUse = minNumUse;
	}
	public int getStepSize() {
		return stepSize;
	}
	public void setStepSize(int stepSize) {
		this.stepSize = stepSize;
	}

}