package net.smartworks.server.engine.process.approval.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class AprApprovalCond extends MisObjectCond {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(AprApprovalCond.class);

	protected static final String PREFIX = "Apr";
	private static final String NAME = CommonUtil.toName(AprApprovalCond.class, PREFIX);

	public static final String A_TYPE = "type";
	public static final String A_APPROVER = "approver";
	public static final String A_ISAPPROVALLINENULL = "isApprovalLineNull";
	
	private String type;
	private String approver;
	private boolean isApprovalLineNull;
	public AprApprovalCond() {
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
		appendAttributeString(A_APPROVER, approver, buf);
		appendAttributeString(A_ISAPPROVALLINENULL, isApprovalLineNull, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		AprApprovalCond obj = null;
		if (baseObj == null || !(baseObj instanceof AprApprovalCond))
			obj = new AprApprovalCond();
		else
			obj = (AprApprovalCond)baseObj;
		
		MisObjectCond.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node type = attrMap.getNamedItem(A_TYPE);
			Node approver = attrMap.getNamedItem(A_APPROVER);
			Node isApprovalLineNull = attrMap.getNamedItem(A_ISAPPROVALLINENULL);
			if (type != null)
				obj.setType(type.getNodeValue());
			if (approver != null)
				obj.setApprover(approver.getNodeValue());
			if (isApprovalLineNull != null)
				obj.setApprovalLineNull(CommonUtil.toBoolean(isApprovalLineNull.getNodeValue()));
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
	public static AprApprovalCond[] add(AprApprovalCond[] objs, AprApprovalCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		AprApprovalCond[] newObjs = new AprApprovalCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static AprApprovalCond[] remove(AprApprovalCond[] objs, AprApprovalCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		AprApprovalCond[] newObjs = new AprApprovalCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static AprApprovalCond[] left(AprApprovalCond[] objs, AprApprovalCond obj) {
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
		AprApprovalCond[] newObjs = new AprApprovalCond[objs.length];
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
	public static AprApprovalCond[] right(AprApprovalCond[] objs, AprApprovalCond obj) {
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
		AprApprovalCond[] newObjs = new AprApprovalCond[objs.length];
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
	public String getApprover() {
		return approver;
	}
	public void setApprover(String method) {
		this.approver = method;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isApprovalLineNull() {
		return isApprovalLineNull;
	}
	public void setApprovalLineNull(boolean isApprovalLineNull) {
		this.isApprovalLineNull = isApprovalLineNull;
	}
}
