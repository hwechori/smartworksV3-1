package net.smartworks.server.engine.process.link.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LnkLink extends MisObject {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(LnkLink.class);

	protected static final String PREFIX = "Lnk";
	private static final String NAME = CommonUtil.toName(LnkLink.class, PREFIX);
	public static final String A_CORRELATION = "correlation";
	public static final String A_TYPE = "type";
	public static final String A_FROM = "from";
	public static final String A_TO = "to";
	public static final String A_CONDITION = "condition";

	private String correlation;
	private String type;
	
	private LnkObject from;
	private LnkObject to;
	private LnkCondition condition;
	
	public LnkLink() {
		super();
	}
	public Object clone() throws CloneNotSupportedException {
		try {
			return toObject(this.toString());
		} catch (Exception e) {
			logger.warn(e, e);
			return null;
		}
	}
	public static LnkLink[] add(LnkLink[] objs, LnkLink obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		LnkLink[] newObjs = new LnkLink[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static LnkLink[] remove(LnkLink[] objs, LnkLink obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		LnkLink[] newObjs = new LnkLink[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static LnkLink[] left(LnkLink[] objs, LnkLink obj) {
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
		LnkLink[] newObjs = new LnkLink[objs.length];
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
	public static LnkLink[] right(LnkLink[] objs, LnkLink obj) {
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
		LnkLink[] newObjs = new LnkLink[objs.length];
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
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		LnkLink obj = null;
		if (baseObj == null || !(baseObj instanceof LnkLink))
			obj = new LnkLink();
		else
			obj = (LnkLink)baseObj;
		
		MisObject.toObject(node, obj);
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_CORRELATION)) {
				obj.setCorrelation(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_TYPE)) {
				obj.setType(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_FROM)) {
				obj.setFrom((LnkObject)LnkObject.toObject(childNode, null));
			} else if (childNode.getNodeName().equals(A_TO)) {
				obj.setTo((LnkObject)LnkObject.toObject(childNode, null));
			} else if (childNode.getNodeName().equals(A_CONDITION)) {
				obj.setCondition((LnkCondition)LnkCondition.toObject(childNode, null));
			}
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
	public String toString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toElementsString(String tab) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab));
		appendElementString(A_CORRELATION, correlation, tab, buf);
		appendElementString(A_TYPE, type, tab, buf);
		appendElementString(A_FROM, from, tab, buf);
		appendElementString(A_TO, to, tab, buf);
		appendElementString(A_CONDITION, condition, tab, buf);
		return buf.toString();
	}
	public LnkCondition getCondition() {
		return condition;
	}
	public void setCondition(LnkCondition condition) {
		this.condition = condition;
	}
	public LnkObject getTo() {
		return to;
	}
	public void setTo(LnkObject task) {
		this.to = task;
	}
	public LnkObject getFrom() {
		return from;
	}
	public void setFrom(LnkObject from) {
		this.from = from;
	}
	public String getCorrelation() {
		return correlation;
	}
	public void setCorrelation(String correlation) {
		this.correlation = correlation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
