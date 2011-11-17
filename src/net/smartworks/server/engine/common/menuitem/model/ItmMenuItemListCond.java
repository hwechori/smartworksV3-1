package net.smartworks.server.engine.common.menuitem.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;
import net.smartworks.server.engine.process.approval.model.AprApprovalLineDefCond;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ItmMenuItemListCond extends MisObjectCond {
	
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(ItmMenuItemListCond.class);

	protected static final String PREFIX = "Itm";
	private static final String NAME = CommonUtil.toName(ItmMenuItemListCond.class, PREFIX);

	public ItmMenuItemListCond() {
		super();
	}
	
	private static final String A_USERID = "userId";
	private static final String A_MENUITEMS = "menuItems";
	private static final String A_MENUITEM = "menuItem";
	
	private String userId;
	private ItmMenuItem[] menuItems;
	
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
		appendElementString(A_USERID, userId, tab, buf);
		appendElementString(A_MENUITEMS, menuItems, tab, buf);
		
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		ItmMenuItemListCond obj = null;
		if (baseObj == null || !(baseObj instanceof ItmMenuItemListCond))
			obj = new ItmMenuItemListCond();
		else
			obj = (ItmMenuItemListCond)baseObj;
		
		MisObjectCond.toObject(node, obj);
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_USERID)) {
				obj.setUserId(getNodeValue(childNode));
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
	public static AprApprovalLineDefCond[] add(AprApprovalLineDefCond[] objs, AprApprovalLineDefCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		AprApprovalLineDefCond[] newObjs = new AprApprovalLineDefCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static AprApprovalLineDefCond[] remove(AprApprovalLineDefCond[] objs, AprApprovalLineDefCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		AprApprovalLineDefCond[] newObjs = new AprApprovalLineDefCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static ItmMenuItemListCond[] left(ItmMenuItemListCond[] objs, ItmMenuItemListCond obj) {
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
		ItmMenuItemListCond[] newObjs = new ItmMenuItemListCond[objs.length];
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
	public static ItmMenuItemListCond[] right(ItmMenuItemListCond[] objs, ItmMenuItemListCond obj) {
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
		ItmMenuItemListCond[] newObjs = new ItmMenuItemListCond[objs.length];
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

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ItmMenuItem[] getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(ItmMenuItem[] menuItems) {
		this.menuItems = menuItems;
	}
}
