package net.smartworks.server.engine.common.menuitem.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ItmMenuItem  extends MisObject implements Comparable {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(ItmMenuItem.class);

	protected static final String PREFIX = "Itm";
	private static final String NAME = CommonUtil.toName(ItmMenuItem.class, PREFIX);
	
	public ItmMenuItem() {
		super();
	}
	
	public static final String A_MENUSEQNO = "menuSeqNo";
	public static final String A_IMGPATH = "imgPath";
	public static final String A_CATEGORYID = "categoryId";
	public static final String A_PACKAGEID = "packageId";
	public static final String A_PACKAGETYPE = "packageType";
	public static final String A_FORMID = "formId";
	public static final String A_GROUPID ="groupId";
	
	private String groupId;
	private int menuSeqNo;
	private String imgPath;
	private String categoryId;
	private String packageId;
	private String packageType;
	private String formId;
	
	
	public  String toString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
			return super.toString(name, tab);
	}
	public String toAttributeString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_GROUPID, groupId, buf);
		appendAttributeString(A_MENUSEQNO, menuSeqNo, buf);
		appendAttributeString(A_IMGPATH, imgPath, buf);
		appendAttributeString(A_CATEGORYID, categoryId, buf);
		appendAttributeString(A_PACKAGEID, packageId, buf);
		appendAttributeString(A_PACKAGETYPE, packageType, buf);
		appendAttributeString(A_FORMID, formId, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		ItmMenuItem obj = null;
		if (node == null || !(baseObj instanceof ItmMenuItem))
			obj = new ItmMenuItem();
		else
			obj = (ItmMenuItem)baseObj;
		MisObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node groupId = attrMap.getNamedItem(A_GROUPID);
			Node menuSeqNo = attrMap.getNamedItem(A_MENUSEQNO);
			Node imgPath = attrMap.getNamedItem(A_IMGPATH);
			Node categoryId = attrMap.getNamedItem(A_CATEGORYID);
			Node packageId = attrMap.getNamedItem(A_PACKAGEID);
			Node packageType = attrMap.getNamedItem(A_PACKAGETYPE);
			Node formId = attrMap.getNamedItem(A_FORMID);
			if (groupId != null)
				obj.setGroupId(groupId.getNodeValue());
			if (menuSeqNo != null)
				obj.setMenuSeqNo(CommonUtil.toInt(menuSeqNo.getNodeValue()));
			if (imgPath != null)
				obj.setImgPath(imgPath.getNodeValue());
			if (categoryId != null)
				obj.setCategoryId(categoryId.getNodeValue());
			if (packageId != null)
				obj.setPackageId(packageId.getNodeValue());
			if (packageType != null)
				obj.setPackageType(packageType.getNodeValue());
			if (formId != null)
				obj.setFormId(formId.getNodeValue());
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
	public static ItmMenuItem[] add(ItmMenuItem[] objs, ItmMenuItem obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		ItmMenuItem[] newObjs = new ItmMenuItem[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static ItmMenuItem[] remove(ItmMenuItem[] objs, ItmMenuItem obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		ItmMenuItem[] newObjs = new ItmMenuItem[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static ItmMenuItem[] left(ItmMenuItem[] objs, ItmMenuItem obj) {
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
		ItmMenuItem[] newObjs = new ItmMenuItem[objs.length];
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
	public static ItmMenuItem[] right(ItmMenuItem[] objs, ItmMenuItem obj) {
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
		ItmMenuItem[] newObjs = new ItmMenuItem[objs.length];
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

	public int getMenuSeqNo() {
		return menuSeqNo;
	}
	public void setMenuSeqNo(int menuSeqNo) {
		this.menuSeqNo = menuSeqNo;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public int compareTo(Object otherObj) {
		ItmMenuItem other = (ItmMenuItem)otherObj;
		if (menuSeqNo < other.getMenuSeqNo())
			return -1;
		if (menuSeqNo > other.getMenuSeqNo())
			return 1;
		return 0;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
}
