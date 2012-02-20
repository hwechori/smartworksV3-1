package net.smartworks.server.engine.process.process.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PrcProcessInst extends MisObject {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(PrcProcessInst.class);
	protected static final String PREFIX = "Prc";
	
	private static final String NAME = CommonUtil.toName(PrcProcessInst.class, PREFIX);
	
	public static final String PROCESSINSTSTATUS_RUNNING = "2";
	public static final String PROCESSINSTSTATUS_COMPLETE = "3";
	
	public static final String PROCESSINSTTYPE_PROCESS = "PROCESS";
	public static final String PROCESSINSTTYPE_INFORMATION = "SINGLE";
	public static final String PROCESSINSTTYPE_SCHEDULE = "SCHEDULE";
	
	public static final String A_TITLE = "title";
	public static final String A_TYPE = "type";
	public static final String A_PACKAGEID = "packageId";
	public static final String A_PRIORITY = "priority";
	public static final String A_DIAGRAMID = "diagramId";
	public static final String A_DIAGRAMVERSION = "diagramVersion";
	public static final String A_PROCESSID = "processId";
	public static final String A_DIAGRAM = "diagram";
	public static final String A_ISSUBINSTANCE = "isSubInstance";
	public static final String A_INSTVARIABLE = "instVariable";
	public static final String A_WORKSPACEID = "workSpaceId";
	public static final String A_WORKSPACETYPE = "workSpaceType";
	
	private String title;
	private String type;
	private String packageId;
	private String priority;
	private String diagramId;
	private String diagramVersion;
	private String processId;
	private String diagram;
	private String isSubInstance;
	private String instVariable;
	private String workSpaceId;
	private String workSpaceType;

	public PrcProcessInst() {
		super();
	}
	public String toString(String name, String tab){
		if(name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toAttributesString(){
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_PRIORITY, priority, buf);
		appendAttributeString(A_TYPE, type, buf);
		appendAttributeString(A_PACKAGEID, type, buf);
		appendAttributeString(A_DIAGRAMID, packageId, buf);
		appendAttributeString(A_DIAGRAMVERSION, diagramVersion, true, buf);
		appendAttributeString(A_PROCESSID, processId, buf);
		appendAttributeString(A_ISSUBINSTANCE, isSubInstance, buf);
		appendAttributeString(A_WORKSPACEID, workSpaceId, buf);
		appendAttributeString(A_WORKSPACETYPE, workSpaceType, buf);
		return buf.toString();
	}
	public String toElementsString(String tab) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab));
		appendElementString(A_TITLE, title, tab, buf);
		appendElementString(A_DIAGRAM, diagram, tab, true, buf);
		appendElementString(A_INSTVARIABLE, getInstVariable(), tab, true, buf);
		return buf.toString();
	}
	
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		PrcProcessInst obj = null;
		if (baseObj == null || !(baseObj instanceof PrcProcessInst))
			obj = new PrcProcessInst();
		else
			obj = (PrcProcessInst)baseObj;
		
		MisObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node priority = attrMap.getNamedItem(A_PRIORITY);
			Node type = attrMap.getNamedItem(A_TYPE);
			Node packageId = attrMap.getNamedItem(A_PACKAGEID);
			Node diagramId = attrMap.getNamedItem(A_DIAGRAMID);
			Node diagramVersion = attrMap.getNamedItem(A_DIAGRAMVERSION);
			Node processId = attrMap.getNamedItem(A_PROCESSID);
			Node isSubInstance = attrMap.getNamedItem(A_ISSUBINSTANCE);
			Node workSpaceId = attrMap.getNamedItem(A_WORKSPACEID);
			Node workSpaceType = attrMap.getNamedItem(A_WORKSPACETYPE);
			if (priority != null)
				obj.setPriority(priority.getNodeValue());
			if (type != null)
				obj.setType(type.getNodeValue());
			if (packageId != null)
				obj.setPackageId(packageId.getNodeValue());
			if (diagramId != null)
				obj.setDiagramId(diagramId.getNodeValue());
			if (diagramVersion != null)
				obj.setDiagramVersion(diagramVersion.getNodeValue());
			if (processId != null)
				obj.setProcessId(processId.getNodeValue());
			if (isSubInstance != null)
				obj.setIsSubInstance(isSubInstance.getNodeValue());
			if (workSpaceId != null)
				obj.setWorkSpaceId(workSpaceId.getNodeValue());
			if (workSpaceType != null)
				obj.setWorkSpaceType(workSpaceType.getNodeValue());
		}
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_TITLE)) {
				obj.setTitle(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_DIAGRAM)) {
				obj.setDiagram(getNodeValue(childNode, true));
			} else if (childNode.getNodeName().equals(A_INSTVARIABLE)) {
				obj.setInstVariable(getNodeValue(childNode, true));
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
	
	public static PrcProcessInst[] add(PrcProcessInst[] objs, PrcProcessInst obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		PrcProcessInst[] newObjs = new PrcProcessInst[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static PrcProcessInst[] remove(PrcProcessInst[] objs, PrcProcessInst obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		PrcProcessInst[] newObjs = new PrcProcessInst[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static PrcProcessInst[] left(PrcProcessInst[] objs, PrcProcessInst obj) {
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
		PrcProcessInst[] newObjs = new PrcProcessInst[objs.length];
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
	public static PrcProcessInst[] right(PrcProcessInst[] objs, PrcProcessInst obj) {
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
		PrcProcessInst[] newObjs = new PrcProcessInst[objs.length];
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDiagram() {
		return diagram;
	}
	public void setDiagram(String diagram) {
		this.diagram = diagram;
	}
	public String getDiagramId() {
		return diagramId;
	}
	public void setDiagramId(String diagramId) {
		this.diagramId = diagramId;
	}
	public String getDiagramVersion() {
		return diagramVersion;
	}
	public void setDiagramVersion(String diagramVersion) {
		this.diagramVersion = diagramVersion;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getIsSubInstance() {
		return isSubInstance;
	}
	public void setIsSubInstance(String isSubInstance) {
		this.isSubInstance = isSubInstance;
	}
	public String getInstVariable() {
		return instVariable;
	}
	public void setInstVariable(String instVariable) {
		this.instVariable = instVariable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getWorkSpaceId() {
		return workSpaceId;
	}
	public void setWorkSpaceId(String workSpaceId) {
		this.workSpaceId = workSpaceId;
	}
	public String getWorkSpaceType() {
		return workSpaceType;
	}
	public void setWorkSpaceType(String workSpaceType) {
		this.workSpaceType = workSpaceType;
	}
}
