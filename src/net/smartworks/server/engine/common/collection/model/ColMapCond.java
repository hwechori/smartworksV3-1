package net.smartworks.server.engine.common.collection.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.ClassObjectCond;
import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ColMapCond extends MisObjectCond {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(ColMapCond.class);
	
	private static final String NAME = CommonUtil.toName(ColMapCond.class, PREFIX);
	public static final String A_OBJID = "objId";
	public static final String A_TYPE = "type";
	public static final String A_FROMTYPE = "fromType";
	public static final String A_FROMREF = "fromRef";
	public static final String A_TOTYPE = "toType";
	public static final String A_TOREF = "toRef";
	
	private String objId;
	private String type;
	private String fromType;
	private String fromRef;
	private String toType;
	private String toRef;
	
	public ColMapCond(){
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
		appendAttributeString(A_TYPE, type, buf);
		appendAttributeString(A_FROMTYPE, fromType, buf);
		appendAttributeString(A_FROMREF, fromRef, buf);
		appendAttributeString(A_TOTYPE, toType, buf);
		appendAttributeString(A_TOREF, toRef, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		ColMapCond obj = null;
		if (baseObj == null || !(baseObj instanceof ColMapCond))
			obj = new ColMapCond();
		else
			obj = (ColMapCond)baseObj;
		
		ClassObjectCond.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node type = attrMap.getNamedItem(A_TYPE);
			Node fromType = attrMap.getNamedItem(A_FROMTYPE);
			Node fromRef = attrMap.getNamedItem(A_FROMREF);
			Node toType = attrMap.getNamedItem(A_TOTYPE);
			Node toRef = attrMap.getNamedItem(A_TOREF);
			if (type != null)
				obj.setType(type.getNodeValue());
			if (fromType != null)
				obj.setFromType(fromType.getNodeValue());
			if (fromRef != null)
				obj.setFromRef(fromRef.getNodeValue());
			if (toType != null)
				obj.setToType(toType.getNodeValue());
			if (toRef != null)
				obj.setToRef(toRef.getNodeValue());
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
	public static ColMapCond[] add(ColMapCond[] objs, ColMapCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		ColMapCond[] newObjs = new ColMapCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static ColMapCond[] remove(ColMapCond[] objs, ColMapCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		ColMapCond[] newObjs = new ColMapCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static ColMapCond[] left(ColMapCond[] objs, ColMapCond obj) {
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
		ColMapCond[] newObjs = new ColMapCond[objs.length];
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
	public static ColMapCond[] right(ColMapCond[] objs, ColMapCond obj) {
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
		ColMapCond[] newObjs = new ColMapCond[objs.length];
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

	public String getFromRef() {
		return fromRef;
	}
	public void setFromRef(String fromRef) {
		this.fromRef = fromRef;
	}
	public String getFromType() {
		return fromType;
	}
	public void setFromType(String fromType) {
		this.fromType = fromType;
	}
	public String getToRef() {
		return toRef;
	}
	public void setToRef(String toRef) {
		this.toRef = toRef;
	}
	public String getToType() {
		return toType;
	}
	public void setToType(String toType) {
		this.toType = toType;
	}
	public String getObjId() {
		return objId;
	}
	public void setObjId(String objId) {
		this.objId = objId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
