package net.smartworks.server.engine.common.model;

import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;
import net.smartworks.server.engine.process.deploy.model.AcpActualParameter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MappingService extends MisObject {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(MappingService.class);
	protected static final String PREFIX = "Acp";
	
	private static final String NAME = CommonUtil.toName(MappingService.class, PREFIX);
	
	public static final String A_ACPACTUALPARAMETER = "ActualParmeter";
	public static final String A_ACPACTUALPARAMETERS = "actualParameters";
	public static final String A_MAPPINGSERVICE = "mappingService";
	public static final String A_MAPPINGSERVICES = "mappingServices";
	public static final String A_ID = "id";
	public static final String A_TARGETSERVICEID = "targetServiceId";
	public static final String A_EXECUTION = "Execution";
	
	private String id;
	private String targetServiceId;
	private String Execution;
	private AcpActualParameter[] actualParameters = null;
	
	public MappingService() {
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
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_ID, id, buf);
		appendAttributeString(A_TARGETSERVICEID, targetServiceId, buf);
		return buf.toString();
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
		
		MappingService obj = null;
		if (baseObj == null || !(baseObj instanceof MappingService))
			obj = new MappingService();
		else
			obj = (MappingService)baseObj;
		
		MisObject.toObject(node, obj);
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node id = attrMap.getNamedItem(A_ID);
			Node targetServiceId = attrMap.getNamedItem(A_TARGETSERVICEID);
			Node Execution = attrMap.getNamedItem(A_EXECUTION);
			if (id != null)
				obj.setId(id.getNodeValue());
			if (targetServiceId != null)
				obj.setTargetServiceId(targetServiceId.getNodeValue());
			if (Execution != null)
				obj.setExecution(Execution.getNodeValue());
		}
		// elements 값 설정
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_ACPACTUALPARAMETER)) {
				obj.addActualParameter((AcpActualParameter)AcpActualParameter.toObject(childNode, null));
//				Node[] nodes = getNodes(childNode);
//				if (nodes == null || nodes.length == 0)
//					continue;
//				AcpActualParameter[] objs = new AcpActualParameter[nodes.length];
//				for (int j=0; j<nodes.length; j++)
//					objs[j] = (AcpActualParameter)AcpActualParameter.toObject(nodes[j], null);
//				obj.setActualParameters(objs);
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
	public static MappingService[] add(MappingService[] objs, MappingService obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		MappingService[] newObjs = new MappingService[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static MappingService[] remove(MappingService[] objs, MappingService obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		MappingService[] newObjs = new MappingService[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static MappingService[] left(MappingService[] objs, MappingService obj) {
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
		MappingService[] newObjs = new MappingService[objs.length];
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
	public static MappingService[] right(MappingService[] objs, MappingService obj) {
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
		MappingService[] newObjs = new MappingService[objs.length];
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTargetServiceId() {
		return targetServiceId;
	}

	public void setTargetServiceId(String targetServiceId) {
		this.targetServiceId = targetServiceId;
	}

	public String getExecution() {
		return Execution;
	}

	public void setExecution(String execution) {
		Execution = execution;
	}


}
