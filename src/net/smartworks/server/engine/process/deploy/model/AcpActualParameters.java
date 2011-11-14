package net.smartworks.server.engine.process.deploy.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AcpActualParameters extends MisObject {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(AcpActualParameters.class);
	protected static final String PREFIX = "Acp";
	
	private static final String NAME = CommonUtil.toName(AcpActualParameters.class, PREFIX);
	
	public static final String A_ACPACTUALPARAMETER = "actualParameter";
	public static final String A_ACPACTUALPARAMETERS = "actualParameters";
	
	private AcpActualParameter[] actualParameters = null;
	
	public AcpActualParameters() {
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
	
	public String toElementsString(String tab) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab));
		appendElementsString(null, A_ACPACTUALPARAMETER, getActualParameters(), tab, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		AcpActualParameters obj = null;
		if (baseObj == null || !(baseObj instanceof AcpActualParameters))
			obj = new AcpActualParameters();
		else
			obj = (AcpActualParameters)baseObj;
		
		MisObject.toObject(node, obj);
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_ACPACTUALPARAMETERS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				AcpActualParameter[] objs = new AcpActualParameter[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (AcpActualParameter)AcpActualParameter.toObject(nodes[j], null);
				obj.setActualParameters(objs);
			} else if (childNode.getNodeName().equals(A_ACPACTUALPARAMETER)) {
				obj.addActualParameter((AcpActualParameter)AcpActualParameter.toObject(childNode, null));
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
	public static AcpActualParameters[] add(AcpActualParameters[] objs, AcpActualParameters obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		AcpActualParameters[] newObjs = new AcpActualParameters[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static AcpActualParameters[] remove(AcpActualParameters[] objs, AcpActualParameters obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		AcpActualParameters[] newObjs = new AcpActualParameters[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static AcpActualParameters[] left(AcpActualParameters[] objs, AcpActualParameters obj) {
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
		AcpActualParameters[] newObjs = new AcpActualParameters[objs.length];
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
	public static AcpActualParameters[] right(AcpActualParameters[] objs, AcpActualParameters obj) {
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
		AcpActualParameters[] newObjs = new AcpActualParameters[objs.length];
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
	public void addActualParameter(AcpActualParameter actualParameter) {
		if (actualParameter == null)
			return;
		this.setActualParameters(AcpActualParameter.add(this.getActualParameters(), actualParameter));
	}

	public AcpActualParameter[] getActualParameters() {
		return actualParameters;
	}

	public void setActualParameters(AcpActualParameter[] actualParameters) {
		this.actualParameters = actualParameters;
	}

}
