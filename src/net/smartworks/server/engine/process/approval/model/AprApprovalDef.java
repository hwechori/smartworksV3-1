package net.smartworks.server.engine.process.approval.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class AprApprovalDef extends MisObject {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(AprApproval.class);

	protected static final String PREFIX = "Apr";
	private static final String NAME = CommonUtil.toName(AprApproval.class, PREFIX);

	public static final String A_TYPE = "type";
	public static final String A_APRNAME = "aprName";
	public static final String A_ARPPERSON = "aprPerson";
	public static final String A_DUEDATE = "dueDate";
	public static final String A_LEVEL = "level";

	private String type;
	private String aprName;
	private String aprPerson;
	private String dueDate;
	private String level;

	public AprApprovalDef() {
		super();
	}
	public String toString(String name, String tab) {
		if(name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_TYPE, type, buf);
		appendAttributeString(A_APRNAME, aprName, buf);
		appendAttributeString(A_ARPPERSON, aprPerson, buf);
		appendAttributeString(A_DUEDATE, dueDate, buf);
		appendAttributeString(A_LEVEL, level, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		AprApprovalDef obj = null;
		if (baseObj == null || !(baseObj instanceof AprApproval))
			obj = new AprApprovalDef();
		else
			obj = (AprApprovalDef)baseObj;
		
		MisObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node type = attrMap.getNamedItem(A_TYPE);
			Node aprName = attrMap.getNamedItem(A_APRNAME);
			Node aprPerson = attrMap.getNamedItem(A_ARPPERSON);
			Node dueDate = attrMap.getNamedItem(A_DUEDATE);
			Node level = attrMap.getNamedItem(A_LEVEL);
			if (type != null)
				obj.setType(type.getNodeValue());
			if (aprName != null)
				obj.setAprName(aprName.getNodeValue());
			if (aprPerson != null)
				obj.setAprPerson(aprPerson.getNodeValue());
			if (dueDate != null)
				obj.setDueDate(dueDate.getNodeValue());
			if (level != null)
				obj.setLevel(level.getNodeValue());
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
	public static AprApprovalDef[] add(AprApprovalDef[] objs, AprApprovalDef obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		AprApprovalDef[] newObjs = new AprApprovalDef[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static AprApprovalDef[] remove(AprApprovalDef[] objs, AprApprovalDef obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		AprApprovalDef[] newObjs = new AprApprovalDef[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static AprApprovalDef[] left(AprApprovalDef[] objs, AprApprovalDef obj) {
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
		AprApprovalDef[] newObjs = new AprApprovalDef[objs.length];
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
	public static AprApprovalDef[] right(AprApprovalDef[] objs, AprApprovalDef obj) {
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
		AprApprovalDef[] newObjs = new AprApprovalDef[objs.length];
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

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAprName() {
		return aprName;
	}
	public void setAprName(String aprName) {
		this.aprName = aprName;
	}
	public String getAprPerson() {
		return aprPerson;
	}
	public void setAprPerson(String aprPerson) {
		this.aprPerson = aprPerson;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

}