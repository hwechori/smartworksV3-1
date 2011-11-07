/*	
 * $Id$
 * created by    : maninsoft
 * creation-date : 2011. 11. 2.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.organization.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.SmartObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;
import net.smartworks.server.engine.domain.model.SwdObjectCond;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class SwoObjectCond extends SmartObjectCond {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(SwoObjectCond.class);
	
	protected static final String PREFIX = "Swo";
	private static final String NAME = CommonUtil.toName(SwoObjectCond.class, PREFIX);

	public static final String A_NAME = "name";

	private String name;

	public SwoObjectCond() {
		super();
	}
	public String toString(String name, String tab){
		if(name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_NAME, name, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		SwoObjectCond obj = null;
		if (baseObj == null || !(baseObj instanceof SwoObjectCond))
			obj = new SwoObjectCond();
		else
			obj = (SwoObjectCond)baseObj;
		
		SwdObjectCond.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node name = attrMap.getNamedItem(A_NAME);
			if (name != null)
				obj.setName(name.getNodeValue());
		}
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
	public static SwoObjectCond[] add(SwoObjectCond[] objs, SwoObjectCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		SwoObjectCond[] newObjs = new SwoObjectCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static SwoObjectCond[] remove(SwoObjectCond[] objs, SwoObjectCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		SwoObjectCond[] newObjs = new SwoObjectCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static SwoObjectCond[] left(SwoObjectCond[] objs, SwoObjectCond obj) {
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
		SwoObjectCond[] newObjs = new SwoObjectCond[objs.length];
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
	public static SwoObjectCond[] right(SwoObjectCond[] objs, SwoObjectCond obj) {
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
		SwoObjectCond[] newObjs = new SwoObjectCond[objs.length];
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}