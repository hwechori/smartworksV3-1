package net.smartworks.server.engine.process.link.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.model.Property;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LnkLinkCond extends MisObjectCond {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(LnkLinkCond.class);

	private static final String NAME = CommonUtil.toName(LnkLinkCond.class, PREFIX);
	public static final String A_CORRELATION = "correlation";
	public static final String A_TYPE = "type";
	public static final String A_FROMTYPE = "fromType";
	public static final String A_FROMTYPELIKE = "fromTypeLike";
	public static final String A_FROMREF = "fromRef";
	public static final String A_FROMLABELLIKE = "fromLabelLike";
	public static final String A_FROMEXPRESSION = "fromExpression";
	public static final String A_TOTYPE = "toType";
	public static final String A_TOTYPELIKE = "toTypeLike";
	public static final String A_TOREF = "toRef";
	public static final String A_TOLABELLIKE = "toLabelLike";
	public static final String A_TOEXPRESSION = "toExpression";
	public static final String A_CONDITIONTYPE = "conditionType";
	public static final String A_CONDITIONEXPRESSION = "conditionExpression";
	public static final String A_EXTENDEDPROPERTY = "extendedProperty";
	public static final String A_EXTENDEDPROPERTIES = "extendedProperties";

	private String correlation;
	private String type;
	private String fromType;
	private String fromTypeLike;
	private String fromRef;
	private String fromLabelLike;
	private String fromExpression;
	private String toType;
	private String toTypeLike;
	private String toRef;
	private String toLabelLike;
	private String toExpression;
	private String conditionType;
	private String conditionExpression;
	
	private Property[] extendedProperties;
	
	public LnkLinkCond() {
		super();
	}
	public Object clone() throws CloneNotSupportedException {
		try {
			return toObject(this.toString());
		} catch (Exception e) {
			logger.warn(e, e);
			return null;
		}
	}
	public static LnkLinkCond[] add(LnkLinkCond[] objs, LnkLinkCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		LnkLinkCond[] newObjs = new LnkLinkCond[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static LnkLinkCond[] remove(LnkLinkCond[] objs, LnkLinkCond obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		LnkLinkCond[] newObjs = new LnkLinkCond[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static LnkLinkCond[] left(LnkLinkCond[] objs, LnkLinkCond obj) {
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
		LnkLinkCond[] newObjs = new LnkLinkCond[objs.length];
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
	public static LnkLinkCond[] right(LnkLinkCond[] objs, LnkLinkCond obj) {
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
		LnkLinkCond[] newObjs = new LnkLinkCond[objs.length];
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
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		LnkLinkCond obj = null;
		if (baseObj == null || !(baseObj instanceof LnkLinkCond))
			obj = new LnkLinkCond();
		else
			obj = (LnkLinkCond)baseObj;
		
		MisObjectCond.toObject(node, obj);
				
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList == null || childNodeList.getLength() == 0)
			return obj;
		for (int i=0; i<childNodeList.getLength(); i++) {
			Node childNode = childNodeList.item(i);
			if (childNode.getNodeType() != Node.ELEMENT_NODE || childNode.getNodeName() == null)
				continue;
			if (childNode.getNodeName().equals(A_FROMTYPE)) {
				obj.setFromType(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_CORRELATION)) {
				obj.setCorrelation(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_TYPE)) {
				obj.setType(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_FROMTYPELIKE)) {
				obj.setFromTypeLike(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_FROMREF)) {
				obj.setFromRef(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_FROMLABELLIKE)) {
				obj.setFromLabelLike(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_FROMEXPRESSION)) {
				obj.setFromExpression(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_TOTYPE)) {
				obj.setToType(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_TOTYPELIKE)) {
				obj.setToTypeLike(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_TOREF)) {
				obj.setToRef(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_TOLABELLIKE)) {
				obj.setToLabelLike(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_TOEXPRESSION)) {
				obj.setToExpression(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_CONDITIONTYPE)) {
				obj.setConditionType(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_CONDITIONEXPRESSION)) {
				obj.setConditionExpression(getNodeValue(childNode));
			} else if (childNode.getNodeName().equals(A_EXTENDEDPROPERTIES)) {
				Node[] nodes = getNodes(childNode);
				if (nodes == null || nodes.length == 0)
					continue;
				Property[] objs = new Property[nodes.length];
				for (int j=0; j<nodes.length; j++)
					objs[j] = (Property)Property.toObject(nodes[j], null);
				obj.setExtendedProperties(objs);
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
	public String toString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
		return super.toString(name, tab);
	}
	public String toElementsString(String tab) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab));
		appendElementString(A_CORRELATION, correlation, tab, buf);
		appendElementString(A_TYPE, type, tab, buf);
		appendElementString(A_FROMTYPE, fromType, tab, buf);
		appendElementString(A_FROMTYPELIKE, fromTypeLike, tab, buf);
		appendElementString(A_FROMREF, fromRef, tab, buf);
		appendElementString(A_FROMLABELLIKE, fromLabelLike, tab, buf);
		appendElementString(A_FROMEXPRESSION, fromExpression, tab, buf);
		appendElementString(A_TOTYPE, toType, tab, buf);
		appendElementString(A_TOTYPELIKE, toTypeLike, tab, buf);
		appendElementString(A_TOREF, toRef, tab, buf);
		appendElementString(A_TOLABELLIKE, toLabelLike, tab, buf);
		appendElementString(A_TOEXPRESSION, toExpression, tab, buf);
		appendElementString(A_CONDITIONTYPE, conditionType, tab, buf);
		appendElementString(A_CONDITIONEXPRESSION, conditionExpression, tab, buf);
		appendElementsString(A_EXTENDEDPROPERTIES, A_EXTENDEDPROPERTY, extendedProperties, tab, buf);
		return buf.toString();
	}
	public String getConditionExpression() {
		return conditionExpression;
	}
	public void setConditionExpression(String condStatus) {
		this.conditionExpression = condStatus;
	}
	public String getFromExpression() {
		return fromExpression;
	}
	public void setFromExpression(String fromExpression) {
		this.fromExpression = fromExpression;
	}
	public String getFromRef() {
		return fromRef;
	}
	public void setFromRef(String fromRef) {
		this.fromRef = fromRef;
	}
	public String getToRef() {
		return toRef;
	}
	public void setToRef(String toRef) {
		this.toRef = toRef;
	}
	public String getToExpression() {
		return toExpression;
	}
	public void setToExpression(String toExpression) {
		this.toExpression = toExpression;
	}
	public String getFromType() {
		return fromType;
	}
	public void setFromType(String fromType) {
		this.fromType = fromType;
	}
	public String getToType() {
		return toType;
	}
	public void setToType(String toType) {
		this.toType = toType;
	}
	public String getFromLabelLike() {
		return fromLabelLike;
	}
	public void setFromLabelLike(String fromLabelLike) {
		this.fromLabelLike = fromLabelLike;
	}
	public String getFromTypeLike() {
		return fromTypeLike;
	}
	public void setFromTypeLike(String fromTypeLike) {
		this.fromTypeLike = fromTypeLike;
	}
	public String getToLabelLike() {
		return toLabelLike;
	}
	public void setToLabelLike(String toLabelLike) {
		this.toLabelLike = toLabelLike;
	}
	public String getToTypeLike() {
		return toTypeLike;
	}
	public void setToTypeLike(String toTypeLike) {
		this.toTypeLike = toTypeLike;
	}
	public Property[] getExtendedProperties() {
		return extendedProperties;
	}
	public void setExtendedProperties(Property[] extendedProperties) {
		this.extendedProperties = extendedProperties;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCorrelation() {
		return correlation;
	}
	public void setCorrelation(String correlation) {
		this.correlation = correlation;
	}
	public String getConditionType() {
		return conditionType;
	}
	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}
}