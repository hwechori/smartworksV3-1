package net.smartworks.server.engine.common.collection.model;

import java.util.Date;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.DateUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ColValueCond extends MisObjectCond{
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(ColValueCond.class);
	
	private static final String NAME = CommonUtil.toName(ColValueCond.class, PREFIX);
	public static final String A_TYPE = "type";
	public static final String A_REF = "ref";
	public static final String A_VALUE = "value";
	public static final String A_VALUELIKE = "valueLike";
	public static final String A_TYPEIN = "typeIn";
	public static final String A_TYPEINS = "typeIns";
	public static final String A_EXPIRATIONDATE = "expirationDate";
	public static final String A_EXPIRATIONDATETO = "expirationDateTo";
	
	private String type;
	private String ref;
	private String value;
	private String valueLike;
	private Date expirationDate;
	private Date expirationDateTo;

	private String[] typeIns;

	public ColValueCond() {
		super();
	}
	
	public String toString(String name, String tab){
		if(name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_TYPE, type, buf);
		appendAttributeString(A_REF, ref, buf);
		appendAttributeString(A_EXPIRATIONDATE, expirationDate, buf);
		appendAttributeString(A_EXPIRATIONDATETO, expirationDateTo, buf);
		return buf.toString();
	}
	public String toElementsString(String tab) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab));
		appendElementString(A_VALUE, getValue(), tab, buf);
		appendElementString(A_VALUELIKE, valueLike, tab, buf);
		appendElementsString(A_TYPEINS, A_TYPEIN, getTypeIns(), tab, buf);
		return buf.toString();
	}
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		ColValueCond obj = null;
		if (baseObj == null || !(baseObj instanceof ColValueCond))
			obj = new ColValueCond();
		else
			obj = (ColValueCond)baseObj;
		
		MisObjectCond.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node type = attrMap.getNamedItem(A_TYPE);
			Node ref = attrMap.getNamedItem(A_REF);
			Node expirationDate = attrMap.getNamedItem(A_EXPIRATIONDATE);
			Node expirationDateTo = attrMap.getNamedItem(A_EXPIRATIONDATETO);
			if (type != null)
				obj.setType(type.getNodeValue());
			if (ref != null)
				obj.setRef(ref.getNodeValue());
			if (expirationDate != null)
				obj.setExpirationDate(DateUtil.toDate(expirationDate.getNodeValue()));
			if (expirationDateTo != null)
				obj.setExpirationDateTo(DateUtil.toDate(expirationDateTo.getNodeValue()));
		}
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_VALUE)) {
				obj.setValue(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_VALUELIKE)) {
				obj.setValueLike(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_TYPEINS)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				String[] objs = new String[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = nodes[j].getNodeValue();
				obj.setTypeIns(objs);
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
	public static ColValueCond[] add(ColValueCond[] objs, ColValueCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		ColValueCond[] newObjs = new ColValueCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static ColValueCond[] remove(ColValueCond[] objs, ColValueCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		ColValueCond[] newObjs = new ColValueCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static ColValueCond[] left(ColValueCond[] objs, ColValueCond obj) {
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
		ColValueCond[] newObjs = new ColValueCond[objs.length];
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
	public static ColValueCond[] right(ColValueCond[] objs, ColValueCond obj) {
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
		ColValueCond[] newObjs = new ColValueCond[objs.length];
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
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValueLike() {
		return valueLike;
	}
	public void setValueLike(String valueLike) {
		this.valueLike = valueLike;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Date getExpirationDateTo() {
		return expirationDateTo;
	}
	public void setExpirationDateTo(Date expirationDateTo) {
		this.expirationDateTo = expirationDateTo;
	}
	public String[] getTypeIns() {
		return typeIns;
	}
	public void setTypeIns(String[] typeIns) {
		this.typeIns = typeIns;
	}
}
