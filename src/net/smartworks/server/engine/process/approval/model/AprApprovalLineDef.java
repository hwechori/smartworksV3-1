package net.smartworks.server.engine.process.approval.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AprApprovalLineDef extends MisObject {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(AprApprovalLineDef.class);
	
	protected static final String PREFIX = "Apr";
	private static final String NAME = CommonUtil.toName(AprApprovalLineDef.class, PREFIX);

	public static final String A_APRLINENAME = "aprLineName";
	public static final String A_APRDESCRIPTION = "aprDescription";
	public static final String A_APRLEVEL = "aprLevel";
	public static final String A_APPROVALDEFS = "approvalDefs";
	public static final String A_APPROVALDEF = "approvalDef";
	
	private String aprLineName;
	private String aprDescription;
	private String aprLevel;
	private AprApprovalDef[] approvalDefs;
	
	public AprApprovalLineDef() {
		super();
	}
	public String toString(String name, String tab){
		if(name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toLiteString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toLiteString(name, tab);
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementString(A_APRLINENAME, aprLineName, tab, buf);
		appendElementString(A_APRDESCRIPTION, aprDescription, tab, buf);
		appendElementString(A_APRLEVEL, aprLevel, tab, buf);
		if (lite) {
			appendElementsString(null, A_APPROVALDEF, getApprovalDefs(), tab, lite, buf);
		} else {
			appendElementsString(A_APPROVALDEFS, A_APPROVALDEF, getApprovalDefs(), tab, lite, buf);
		}
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		AprApprovalLineDef obj = null;
		if (baseObj == null || !(baseObj instanceof AprApprovalLineDef))
			obj = new AprApprovalLineDef();
		else
			obj = (AprApprovalLineDef)baseObj;
		
		MisObject.toObject(node, obj);
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_APRLINENAME)) {
				obj.setAprLineName(getNodeValue(childNode));
			}
			if (childNode.getNodeName().equals(A_APRDESCRIPTION)) {
				obj.setAprDescription(getNodeValue(childNode));
			}
			if (childNode.getNodeName().equals(A_APRLEVEL)) {
				obj.setAprLevel(getNodeValue(childNode));
			}else if (childNode.getNodeName().equals(A_APPROVALDEFS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				AprApprovalDef[] objs = new AprApprovalDef[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (AprApprovalDef)AprApprovalDef.toObject(nodes[j], null);
				obj.setApprovalDefs(objs);
			} else if (childNode.getNodeName().equals(A_APPROVALDEF)) {
				obj.addApprovalDef((AprApprovalDef)AprApprovalDef.toObject(childNode, null));
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
	public static AprApprovalLineDef[] add(AprApprovalLineDef[] objs, AprApprovalLineDef obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		AprApprovalLineDef[] newObjs = new AprApprovalLineDef[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static AprApprovalLineDef[] remove(AprApprovalLineDef[] objs, AprApprovalLineDef obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		AprApprovalLineDef[] newObjs = new AprApprovalLineDef[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static AprApprovalLineDef[] left(AprApprovalLineDef[] objs, AprApprovalLineDef obj) {
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
		AprApprovalLineDef[] newObjs = new AprApprovalLineDef[objs.length];
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
	public static AprApprovalLineDef[] right(AprApprovalLineDef[] objs, AprApprovalLineDef obj) {
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
		AprApprovalLineDef[] newObjs = new AprApprovalLineDef[objs.length];
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

	public String getAprLineName() {
		return aprLineName;
	}
	public void setAprLineName(String aprLineName) {
		this.aprLineName = aprLineName;
	}
	public String getAprDescription() {
		return aprDescription;
	}
	public void setAprDescription(String aprDescription) {
		this.aprDescription = aprDescription;
	}
	public String getAprLevel() {
		return aprLevel;
	}
	public void setAprLevel(String aprLevel) {
		this.aprLevel = aprLevel;
	}
	public void addApprovalDef(AprApprovalDef approvalDef) {
		if (approvalDef == null)
			return;
		this.setApprovalDefs(AprApprovalDef.add(this.getApprovalDefs(), approvalDef));
	}
	public void removeApprovalDef(AprApprovalDef approvalDef) {
		if (approvalDef == null)
			return;
		this.setApprovalDefs(AprApprovalDef.remove(this.getApprovalDefs(), approvalDef));
	}
	public AprApprovalDef[] getApprovalDefs() {
		return approvalDefs;
	}
	public void setApprovalDefs(AprApprovalDef[] approvalDefs) {
		this.approvalDefs = approvalDefs;
	}
	
	
}
