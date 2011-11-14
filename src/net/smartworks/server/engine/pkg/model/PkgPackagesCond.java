package net.smartworks.server.engine.pkg.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PkgPackagesCond extends MisObjectCond {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(PkgPackagesCond.class);
	
	protected static final String PREFIX = "Swp";
	private static final String NAME = CommonUtil.toName(PkgPackagesCond.class, PREFIX);

	public static final String A_PKG = "pkg";
	public static final String A_PKGS = "pkgs";
	
	private PkgPackage[] pkgs;
	
	public PkgPackagesCond() {
		super();
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

	public String toElementsString(String tab, boolean lite) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab));
		appendElementsString(null, A_PKGS, getPkgs(), tab, lite, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		PkgPackagesCond obj = null;
		if (baseObj == null || !(baseObj instanceof PkgPackagesCond))
			obj = new PkgPackagesCond();
		else
			obj = (PkgPackagesCond)baseObj;
		
		MisObjectCond.toObject(node, obj);
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_PKGS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				PkgPackage[] objs = new PkgPackage[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (PkgPackage)PkgPackage.toObject(nodes[j], null);
				obj.setPkgs(objs);
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
	public static PkgPackagesCond[] add(PkgPackagesCond[] objs, PkgPackagesCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		PkgPackagesCond[] newObjs = new PkgPackagesCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static PkgPackagesCond[] remove(PkgPackagesCond[] objs, PkgPackagesCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		PkgPackagesCond[] newObjs = new PkgPackagesCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static PkgPackagesCond[] left(PkgPackagesCond[] objs, PkgPackagesCond obj) {
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
		PkgPackagesCond[] newObjs = new PkgPackagesCond[objs.length];
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
	public static PkgPackagesCond[] right(PkgPackagesCond[] objs, PkgPackagesCond obj) {
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
		PkgPackagesCond[] newObjs = new PkgPackagesCond[objs.length];
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
	public void addPackage(PkgPackage pkg) {
		if (pkg == null)
			return;
		this.setPkgs(PkgPackage.add(this.getPkgs(), pkg));
	}
	public PkgPackage[] getPkgs() {
		return pkgs;
	}
	public void setPkgs(PkgPackage[] pkgs) {
		this.pkgs = pkgs;
	}

}
