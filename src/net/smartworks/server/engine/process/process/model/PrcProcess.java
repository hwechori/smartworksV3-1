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

public class PrcProcess extends MisObject {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(PrcProcess.class);
	protected static final String PREFIX = "Prc";
	
	private static final String NAME = CommonUtil.toName(PrcProcess.class, PREFIX);

	public static final String A_DIAGRAMID = "diagramId";
	public static final String A_DIAGRAMVERSION = "diagramVersion";
	public static final String A_PROCESSID = "processId";
	public static final String A_DIAGRAM = "diagram";
	
	private String diagramId = null;
	private String diagramVersion = null;
	private String processId = null;
	private String diagram = null;

	public PrcProcess() {
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
		appendAttributeString(A_DIAGRAMID, diagramId, buf);
		appendAttributeString(A_DIAGRAMVERSION, diagramVersion, true, buf);
		appendAttributeString(A_PROCESSID, processId, buf);
		return buf.toString();
	}
	public String toElementsString(String tab) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab));
		appendElementString(A_DIAGRAM, getDiagram(), tab, true, buf);
		return buf.toString();
	}
	
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		PrcProcess obj = null;
		if (baseObj == null || !(baseObj instanceof PrcProcess))
			obj = new PrcProcess();
		else
			obj = (PrcProcess)baseObj;
		
		MisObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node diagramId = attrMap.getNamedItem(A_DIAGRAMID);
			Node diagramVersion = attrMap.getNamedItem(A_DIAGRAMVERSION);
			Node processId = attrMap.getNamedItem(A_PROCESSID);
			if (diagramId != null)
				obj.setDiagramId(diagramId.getNodeValue());
			if (diagramVersion != null)
				obj.setDiagramVersion(diagramVersion.getNodeValue());
			if (processId != null)
				obj.setProcessId(processId.getNodeValue());
		}
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_DIAGRAMID)) {
				obj.setDiagramId(getNodeValue(childNode));
			} else 	if (childNode.getNodeName().equals(A_DIAGRAMVERSION)) {
				obj.setDiagramVersion(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_PROCESSID)) {
				obj.setProcessId(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_DIAGRAM)) {
				obj.setDiagram(getNodeValue(childNode, true));
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
	
	public static PrcProcess[] add(PrcProcess[] objs, PrcProcess obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		PrcProcess[] newObjs = new PrcProcess[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static PrcProcess[] remove(PrcProcess[] objs, PrcProcess obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		PrcProcess[] newObjs = new PrcProcess[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static PrcProcess[] left(PrcProcess[] objs, PrcProcess obj) {
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
		PrcProcess[] newObjs = new PrcProcess[objs.length];
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
	public static PrcProcess[] right(PrcProcess[] objs, PrcProcess obj) {
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
		PrcProcess[] newObjs = new PrcProcess[objs.length];
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
	public String getDiagram() {
		return diagram;
	}
	public void setDiagram(String diagram) {
		this.diagram = diagram;
	}
}
