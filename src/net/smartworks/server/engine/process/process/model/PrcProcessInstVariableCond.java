
package net.smartworks.server.engine.process.process.model;

import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrcProcessInstVariableCond extends MisObjectCond {
	
	public PrcProcessInstVariableCond() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(PrcProcessVariableCond.class);
	protected static final String PREFIX = "Prc";
	
	private static final String NAME = CommonUtil.toName(PrcProcessVariableCond.class, PREFIX);

	public static final String A_PRCINSTID = "prcInstId";
	public static final String A_PRCVARIABLEID = "prcVariableId";
	public static final String A_TYPE = "type";
	public static final String A_REQUIRED = "required";
	public static final String A_MODE = "mode";
	public static final String A_VALUE = "value";
	
	private String prcInstId = null;
	private String prcVariableId = null;
	private String type = null;
	private boolean required = false;
	private String mode = null;
	private String value = null;

	public String getPrcInstId() {
		return prcInstId;
	}
	public void setPrcInstId(String prcInstId) {
		this.prcInstId = prcInstId;
	}
	public String getPrcVariableId() {
		return prcVariableId;
	}
	public void setPrcVariableId(String prcVariableId) {
		this.prcVariableId = prcVariableId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}