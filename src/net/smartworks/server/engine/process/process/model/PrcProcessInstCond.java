package net.smartworks.server.engine.process.process.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PrcProcessInstCond extends MisObjectCond {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(PrcProcessInstCond.class);
	protected static final String PREFIX = "Prc";
	
	private static final String NAME = CommonUtil.toName(PrcProcessInstCond.class, PREFIX);
	
	public static final String A_TITLE = "title";
	public static final String A_TYPE = "type";
	public static final String A_PACKAGEID = "packageId";
	public static final String A_TITLELIKE = "titleLike";
	public static final String A_PRIORITY = "priority";
	public static final String A_DIAGRAMID = "diagramId";
	public static final String A_DIAGRAMVERSION = "diagramVersion";
	public static final String A_PROCESSID = "processId";
	public static final String A_DIAGRAM = "diagram";
	public static final String A_PRIORITYIN = "priorityIn";
	public static final String A_PRIORITYINS = "priorityIns";
	public static final String A_PRIORITYNOTIN = "priorityNotIn";
	public static final String A_PRIORITYNOTINS = "priorityNotIns";
	public static final String A_OBJIDIN = "objIdIn";
	public static final String A_OBJIDINS = "objIdIns";
	public static final String A_ISSUBINSTANCE = "isSubInstance";
	public static final String A_WORKSPACEID = "workSpaceId";
	public static final String A_WORKSPACETYPE = "workSpaceType";
	public static final String A_ACCESSLEVEL = "accessLevel";
	public static final String A_ACCESSVALUE = "accessValue";
	
	private String title;
	private String type;
	private String packageId;
	private String titleLike;
	private String priority;
	private String diagramId;
	private String diagramVersion;
	private String processId;
	private String diagram;
	private String workSpaceId;
	private String workSpaceType;
	private String accessLevel;
	private String accessValue;
	
	private String[] objIdIns;
	private String[] priorityIns;
	private String[] priorityNotIns;
	private String isSubInstance;
	
	private String searchKey;
	
	public PrcProcessInstCond() {
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
		appendAttributeString(A_PACKAGEID, packageId, buf);
		appendAttributeString(A_DIAGRAMID, diagramId, buf);
		appendAttributeString(A_DIAGRAMVERSION, diagramVersion, true, buf);
		appendAttributeString(A_PROCESSID, processId, buf);
		appendAttributeString(A_ISSUBINSTANCE, isSubInstance, buf);
		appendAttributeString(A_WORKSPACEID, workSpaceId, buf);
		appendAttributeString(A_WORKSPACETYPE, workSpaceType, buf);
		appendAttributeString(A_ACCESSLEVEL, accessLevel, buf);
		appendAttributeString(A_ACCESSVALUE, accessValue, buf);
		return buf.toString();
	}
	
	public String toElementsString(String tab) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab));
		appendElementString(A_TITLE, getTitle(), tab, buf);
		appendElementString(A_TITLELIKE, getTitleLike(), tab, buf);
		appendElementString(A_DIAGRAM, getDiagram(), tab, true, buf);
		appendElementsString(A_PRIORITYINS, A_PRIORITYIN, getPriorityIns(), tab, buf);
		appendElementsString(A_PRIORITYNOTINS, A_PRIORITYNOTIN, getPriorityNotIns(), tab, buf);
		appendElementsString(A_OBJIDINS, A_OBJIDIN, getObjIdIns(), tab, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		PrcProcessInstCond obj = null;
		if (baseObj == null || !(baseObj instanceof PrcProcessInstCond))
			obj = new PrcProcessInstCond();
		else
			obj = (PrcProcessInstCond)baseObj;
		
		MisObjectCond.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node diagramId = attrMap.getNamedItem(A_DIAGRAMID);
			Node type = attrMap.getNamedItem(A_TYPE);
			Node packageId = attrMap.getNamedItem(A_PACKAGEID);
			Node diagramVersion = attrMap.getNamedItem(A_DIAGRAMVERSION);
			Node processId = attrMap.getNamedItem(A_PROCESSID);
			Node isSubInstance = attrMap.getNamedItem(A_ISSUBINSTANCE);
			Node workSpaceId = attrMap.getNamedItem(A_WORKSPACEID);
			Node workSpaceType = attrMap.getNamedItem(A_WORKSPACETYPE);
			Node accessLevel = attrMap.getNamedItem(A_ACCESSLEVEL);
			Node accessValue = attrMap.getNamedItem(A_ACCESSVALUE);
			if (diagramId != null)
				obj.setDiagramId(diagramId.getNodeValue());
			if (type != null)
				obj.setType(type.getNodeValue());
			if (packageId != null)
				obj.setPackageId(packageId.getNodeValue());
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
			if (accessLevel != null)
				obj.setAccessLevel(accessLevel.getNodeValue());
			if (accessValue != null)
				obj.setAccessValue(accessValue.getNodeValue());
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
			} else if (childNode.getNodeName().equals(A_TITLELIKE)) {
				obj.setTitleLike(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_DIAGRAM)) {
				obj.setDiagram(getNodeValue(childNode, true));
			} else if (childNode.getNodeName().equals(A_PRIORITYINS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				String[] objs = new String[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = nodes[j].getNodeValue();
				obj.setPriorityIns(objs);
			} else if (childNode.getNodeName().equals(A_PRIORITYNOTINS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				String[] objs = new String[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = nodes[j].getNodeValue();
				obj.setPriorityNotIns(objs);
			} else if (childNode.getNodeName().equals(A_OBJIDINS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				String[] objs = new String[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = nodes[j].getNodeValue();
				obj.setObjIdIns(objs);
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
	
	public static PrcProcessInstCond[] add(PrcProcessInstCond[] objs, PrcProcessInstCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		PrcProcessInstCond[] newObjs = new PrcProcessInstCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static PrcProcessInstCond[] remove(PrcProcessInstCond[] objs, PrcProcessInstCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		PrcProcessInstCond[] newObjs = new PrcProcessInstCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static PrcProcessInstCond[] left(PrcProcessInstCond[] objs, PrcProcessInstCond obj) {
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
		PrcProcessInstCond[] newObjs = new PrcProcessInstCond[objs.length];
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
	public static PrcProcessInstCond[] right(PrcProcessInstCond[] objs, PrcProcessInstCond obj) {
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
		PrcProcessInstCond[] newObjs = new PrcProcessInstCond[objs.length];
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
	public String getTitleLike() {
		return titleLike;
	}
	public void setTitleLike(String titleLike) {
		this.titleLike = titleLike;
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
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String orScanKey) {
		this.searchKey = orScanKey;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String[] getPriorityIns() {
		return priorityIns;
	}
	public void setPriorityIns(String[] priorityIns) {
		this.priorityIns = priorityIns;
	}
	public String[] getPriorityNotIns() {
		return priorityNotIns;
	}
	public void setPriorityNotIns(String[] priorityNotIns) {
		this.priorityNotIns = priorityNotIns;
	}
	public String getIsSubInstance() {
		return isSubInstance;
	}
	public void setIsSubInstance(String isSubInstance) {
		this.isSubInstance = isSubInstance;
	}
	public String[] getObjIdIns() {
		return objIdIns;
	}
	public void setObjIdIns(String[] objIdIns) {
		this.objIdIns = objIdIns;
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
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	public String getAccessValue() {
		return accessValue;
	}
	public void setAccessValue(String accessValue) {
		this.accessValue = accessValue;
	}
}
