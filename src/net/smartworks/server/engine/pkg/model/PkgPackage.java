package net.smartworks.server.engine.pkg.model;

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

public class PkgPackage extends MisObject{
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(PkgPackage.class);

	protected static final String PREFIX = "Pkg";
	private static final String NAME = CommonUtil.toName(PkgPackage.class, PREFIX);

	public static final String STATUS_UNDER_DEVEL = "CHECKED-OUT";	
	public static final String STATUS_CHECKED_IN = "CHECKED-IN";	
	public static final String STATUS_DEPLOYED = "DEPLOYED";
	
	public static final String TYPE_PROCESS = "PROCESS";
	public static final String TYPE_SINGLE = "SINGLE";
	public static final String TYPE_GANTT = "GANTT";
	
	public static final String A_PACKAGEID = "packageId";
	public static final String A_VERSION = "version";
	public static final String A_LATESTDEPLOYEDYN = "latestDeployedYn";
	public static final String A_CATEGORYID = "categoryId";
	public static final String A_TYPE = "type";
	public static final String A_CONTENT = "content";
	public static final String A_FORMCONTENTS = "formContents";
	public static final String A_FORMCONTENT = "formContent";
	
	private String packageId;
	private int version;
	private String latestDeployedYn;
	private String categoryId;
	private String type;
	private String content;
	private String[] formContents;
	
	public PkgPackage() {
		super();
	}
	public String NAME() {
		return NAME;
	}
	public String toString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
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
		appendAttributeString(A_PACKAGEID, packageId, buf);
		appendAttributeString(A_VERSION, version, buf);
		appendAttributeString(A_LATESTDEPLOYEDYN, latestDeployedYn, buf);
		appendAttributeString(A_CATEGORYID, categoryId, buf);
		appendAttributeString(A_TYPE, type, buf);
		return buf.toString();
	}
	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab, lite));
		appendElementString(A_CONTENT, getContent(), tab, true, buf);
		appendElementsString(A_FORMCONTENTS, A_FORMCONTENT, formContents, tab, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		PkgPackage obj = null;
		if (baseObj == null || !(baseObj instanceof PkgPackage))
			obj = new PkgPackage();
		else
			obj = (PkgPackage)baseObj;
		
		MisObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node packageId = attrMap.getNamedItem(A_PACKAGEID);
			Node version = attrMap.getNamedItem(A_VERSION);
			Node latestDeployedYn = attrMap.getNamedItem(A_LATESTDEPLOYEDYN);
			Node categoryId = attrMap.getNamedItem(A_CATEGORYID);
			Node type = attrMap.getNamedItem(A_TYPE);
			if (packageId != null)
				obj.setPackageId(packageId.getNodeValue());
			if (version != null)
				obj.setVersion(CommonUtil.toInt(version.getNodeValue()));
			if (latestDeployedYn != null)
				obj.setLatestDeployedYn(latestDeployedYn.getNodeValue());
			if (categoryId != null)
				obj.setCategoryId(categoryId.getNodeValue());
			if (type != null)
				obj.setType(type.getNodeValue());
		}
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_CONTENT)) {
				obj.setContent(getNodeValue(childNode, true));
			} else if (childNode.getNodeName().equals(A_FORMCONTENTS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				String[] objs = new String[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = getNodeValue(nodes[j]);
				obj.setFormContents(objs);
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
	public static PkgPackage[] add(PkgPackage[] objs, PkgPackage obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		PkgPackage[] newObjs = new PkgPackage[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static PkgPackage[] remove(PkgPackage[] objs, PkgPackage obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		PkgPackage[] newObjs = new PkgPackage[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static PkgPackage[] left(PkgPackage[] objs, PkgPackage obj) {
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
		PkgPackage[] newObjs = new PkgPackage[objs.length];
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
	public static PkgPackage[] right(PkgPackage[] objs, PkgPackage obj) {
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
		PkgPackage[] newObjs = new PkgPackage[objs.length];
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
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLatestDeployedYn() {
		return latestDeployedYn;
	}
	public void setLatestDeployedYn(String latestDeployedYn) {
		this.latestDeployedYn = latestDeployedYn;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String[] getFormContents() {
		return formContents;
	}
	public void setFormContents(String[] formContents) {
		this.formContents = formContents;
	}
}
