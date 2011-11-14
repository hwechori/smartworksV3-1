package net.smartworks.server.engine.process.deploy.model;

import net.smartworks.server.engine.common.model.BaseObject;
import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.XmlUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class AcpActualParameter extends MisObject {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(AcpActualParameter.class);
	protected static final String PREFIX = "Acp";
	
	private static final String NAME = CommonUtil.toName(AcpActualParameter.class, PREFIX);
	
	public static final String A_ID = "id";
	public static final String A_DATATYPE = "dataType";
	public static final String A_MODE = "mode";
	public static final String A_TARGETTYPE = "targetType";
	public static final String A_FIELDID = "fieldId";
	public static final String A_FIELDNAME = "fieldName";
	public static final String A_VALUETYPE = "valueType";
	public static final String A_EXPRESSION = "expression";
	public static final String A_VALUE = "value";
	public static final String A_EDITMODE = "editMode";
	
	private String id = null;
	private String dataType = null;
	private String mode = null;
	private String targetType = null;
	private String fieldId = null;
	private String fieldName = null;
	private String valueType = null;
	private String expression = null;
	private String value = null;
	private String editMode = null;
	//private String name = null;
	
	public AcpActualParameter() {
		super();
	}
	public  String toString(String name, String tab) {
		if (name == null || name.trim().length() == 0)
			name = NAME;
			return super.toString(name, tab);
	}
	public String toAttributesString() {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toAttributesString());
		appendAttributeString(A_ID, id, buf);
		appendAttributeString(A_DATATYPE, dataType, buf);
		appendAttributeString(A_MODE, mode, buf);
		appendAttributeString(A_EDITMODE, editMode, buf);
		appendAttributeString(A_TARGETTYPE, targetType, buf);
		appendAttributeString(A_FIELDID, fieldId, buf);
		appendAttributeString(A_FIELDNAME, fieldName, buf);
		appendAttributeString(A_VALUETYPE, valueType, buf);
		appendAttributeString(A_EXPRESSION, expression, buf);

		return buf.toString();
	}
	public String toElementsString(String tab) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.toElementsString(tab));
		appendElementString(A_VALUE, getValue(), tab, true, buf);	
		return buf.toString();
	}
	
	public static BaseObject toObject(Node node, BaseObject baseObj) throws Exception {
		if (node == null)
			return null;
		
		AcpActualParameter obj = null;
		if (node == null || !(baseObj instanceof AcpActualParameter))
			obj = new AcpActualParameter();
		else
			obj = (AcpActualParameter)baseObj;
		MisObject.toObject(node, obj);
		
		NamedNodeMap attrMap = node.getAttributes();
		if (attrMap != null) {
			Node id = attrMap.getNamedItem(A_ID);
			Node dataType = attrMap.getNamedItem(A_DATATYPE);
			Node mode = attrMap.getNamedItem(A_MODE);
			Node editMode = attrMap.getNamedItem(A_EDITMODE);
			Node targetType = attrMap.getNamedItem(A_TARGETTYPE);	
			Node fieldId = attrMap.getNamedItem(A_FIELDID);
			Node fieldName = attrMap.getNamedItem(A_FIELDNAME);
			Node valueType = attrMap.getNamedItem(A_VALUETYPE);
			Node expression = attrMap.getNamedItem(A_EXPRESSION);
			

			if (id != null)
				obj.setId(id.getNodeValue());
			if (dataType != null)
				obj.setDataType(dataType.getNodeValue());
			if (mode != null)
				obj.setMode(mode.getNodeValue());	
			if (editMode != null)
				obj.setEditMode(editMode.getNodeValue());	
			if (targetType != null)
				obj.setTargetType(targetType.getNodeValue());
			if (fieldId != null)
				obj.setFieldId(fieldId.getNodeValue());
			if (fieldName != null)
				obj.setFieldName(fieldName.getNodeValue());	
			if (valueType != null)
				obj.setValueType(valueType.getNodeValue());
			if (expression != null)
				obj.setExpression(expression.getNodeValue());
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
	public static AcpActualParameter[] add(AcpActualParameter[] objs, AcpActualParameter obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		AcpActualParameter[] newObjs = new AcpActualParameter[size+1];
		int i;
		for (i=0; i<size; i++)
			newObjs[i] = objs[i];
		newObjs[i] = obj;
		return newObjs;
	}
	public static AcpActualParameter[] remove(AcpActualParameter[] objs, AcpActualParameter obj) {
		if (obj == null)
			return objs;
		int size = 0;
		if (objs != null)
			size = objs.length;
		if (size == 0)
			return objs;
		AcpActualParameter[] newObjs = new AcpActualParameter[size-1];
		int i;
		int j = 0;
		for (i=0; i<size; i++) {
			if (objs[i].equals(obj))
				continue;
			newObjs[j++] = objs[i];
		}
		return newObjs;
	}
	public static AcpActualParameter[] left(AcpActualParameter[] objs, AcpActualParameter obj) {
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
		AcpActualParameter[] newObjs = new AcpActualParameter[objs.length];
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
	public static AcpActualParameter[] right(AcpActualParameter[] objs, AcpActualParameter obj) {
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
		AcpActualParameter[] newObjs = new AcpActualParameter[objs.length];
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getEditMode() {
		return editMode;
	}
	public void setEditMode(String editMode) {
		this.editMode = editMode;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	

}
