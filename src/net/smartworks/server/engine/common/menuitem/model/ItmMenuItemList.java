package net.smartworks.server.engine.common.menuitem.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ItmMenuItemList extends MisObject {
	
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(ItmMenuItemList.class);

	protected static final String PREFIX = "Itm";
	private static final String NAME = CommonUtil.toName(ItmMenuItem.class, PREFIX);


	public static final String A_USERID = "userId";
	public static final String A_MENUITEMS = "menuItems";
	public static final String A_MENUITEM = "menuItem";
	
	private String userId;
	private ItmMenuItem[] menuItems;
	public ItmMenuItemList() {
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
		appendElementString(A_USERID, userId, tab, buf);
		if (lite) {
			appendElementsString(null, A_MENUITEM, getMenuItems(), tab, lite, buf);
		}else{
			appendElementsString(A_MENUITEMS, A_MENUITEM, getMenuItems(), tab, lite, buf);
		}
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		ItmMenuItemList obj = null;
		if (baseObj == null || !(baseObj instanceof ItmMenuItemList))
			obj = new ItmMenuItemList();
		else
			obj = (ItmMenuItemList)baseObj;
		
		MisObject.toObject(node, obj);
		
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_USERID)) {
				obj.setUserId(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_MENUITEMS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				ItmMenuItem[] objs = new ItmMenuItem[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (ItmMenuItem)ItmMenuItem.toObject(nodes[j], null);
				obj.setMenuItems(objs);
			} else if (childNode.getNodeName().equals(A_MENUITEM)) {
				obj.addMenuItem((ItmMenuItem)ItmMenuItem.toObject(childNode, null));
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
	public static ItmMenuItemList[] add(ItmMenuItemList[] objs, ItmMenuItemList obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		ItmMenuItemList[] newObjs = new ItmMenuItemList[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static ItmMenuItemList[] remove(ItmMenuItemList[] objs, ItmMenuItemList obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		ItmMenuItemList[] newObjs = new ItmMenuItemList[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static ItmMenuItemList[] left(ItmMenuItemList[] objs, ItmMenuItemList obj) {
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
		ItmMenuItemList[] newObjs = new ItmMenuItemList[objs.length];
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
	public static ItmMenuItemList[] right(ItmMenuItemList[] objs, ItmMenuItemList obj) {
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
		ItmMenuItemList[] newObjs = new ItmMenuItemList[objs.length];
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
		//if (menuItems != null)
		//	Arrays.sort(menuItems);
		return menuItems;
	}
	public void setMenuItems(ItmMenuItem[] menuItems) {
		this.menuItems = menuItems;
	}
	public void addMenuItem(ItmMenuItem menuItem) {
		if (menuItem == null)
			return;
		this.setMenuItems(ItmMenuItem.add(this.getMenuItems(), menuItem));
	}
	public void removeMenuItem(ItmMenuItem menuItem) {
		if (menuItem == null)
			return;
		this.setMenuItems(ItmMenuItem.remove(this.getMenuItems(), menuItem));
	}
	public void resetMenuItems() {
		this.menuItems = null;
	}
}
