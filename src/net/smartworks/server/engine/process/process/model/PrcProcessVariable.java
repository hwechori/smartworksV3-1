package net.smartworks.server.engine.process.process.model;

import net.smartworks.server.engine.common.model.MisObject;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrcProcessVariable extends MisObject {

	public PrcProcessVariable() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(PrcProcessInstVariable.class);
	protected static final String PREFIX = "Prc";
	
	private static final String NAME = CommonUtil.toName(PrcProcessInstVariable.class, PREFIX);

	public static final String A_PROCESSID = "processId";
	public static final String A_TYPE = "type";
	public static final String A_INITIALVALUE = "initialValue";
	public static final String A_REQUIRED = "required";
	public static final String A_MODE = "mode";
	
	private String processId = null;
	private String type = null;
	private String initialValue = null;
	private boolean required = false;
	private String mode = null;
 	

	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInitialValue() {
		return initialValue;
	}
	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
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
}


