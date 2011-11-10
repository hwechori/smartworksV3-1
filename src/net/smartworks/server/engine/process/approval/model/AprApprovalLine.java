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

public class AprApprovalLine extends MisObject {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(AprApprovalLine.class);
	
	protected static final String PREFIX = "Apr";
	private static final String NAME = CommonUtil.toName(AprApprovalLine.class, PREFIX);

	public static final String A_CORRELATION = "correlation";
	public static final String A_APPROVALS = "approvals";
	public static final String A_APPROVAL = "approval";
	
	private String correlation;
	private AprApproval[] approvals;
	
	public AprApprovalLine() {
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
		appendElementString(A_CORRELATION, correlation, tab, buf);
		if (lite) {
			appendElementsString(null, A_APPROVAL, getApprovals(), tab, lite, buf);
		} else {
			appendElementsString(A_APPROVALS, A_APPROVAL, getApprovals(), tab, lite, buf);
		}
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		AprApprovalLine obj = null;
		if (baseObj == null || !(baseObj instanceof AprApprovalLine))
			obj = new AprApprovalLine();
		else
			obj = (AprApprovalLine)baseObj;
		
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
			} else if (childNode.getNodeName().equals(A_APPROVALS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				AprApproval[] objs = new AprApproval[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (AprApproval)AprApproval.toObject(nodes[j], null);
				obj.setApprovals(objs);
			} else if (childNode.getNodeName().equals(A_APPROVAL)) {
				obj.addApproval((AprApproval)AprApproval.toObject(childNode, null));
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
	public static AprApprovalLine[] add(AprApprovalLine[] objs, AprApprovalLine obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		AprApprovalLine[] newObjs = new AprApprovalLine[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static AprApprovalLine[] remove(AprApprovalLine[] objs, AprApprovalLine obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		AprApprovalLine[] newObjs = new AprApprovalLine[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static AprApprovalLine[] left(AprApprovalLine[] objs, AprApprovalLine obj) {
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
		AprApprovalLine[] newObjs = new AprApprovalLine[objs.length];
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
	public static AprApprovalLine[] right(AprApprovalLine[] objs, AprApprovalLine obj) {
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
		AprApprovalLine[] newObjs = new AprApprovalLine[objs.length];
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
	public String getCorrelation() {
		return correlation;
	}
	public void setCorrelation(String correlation) {
		this.correlation = correlation;
	}
	public AprApproval[] getApprovals() {
		return approvals;
	}
	public void setApprovals(AprApproval[] approvals) {
		this.approvals = approvals;
	}
	public void addApproval(AprApproval approval) {
		if (approval == null)
			return;
		this.setApprovals(AprApproval.add(this.getApprovals(), approval));
	}
	public void removeApproval(AprApproval approval) {
		if (approval == null)
			return;
		this.setApprovals(AprApproval.remove(this.getApprovals(), approval));
	}
}
