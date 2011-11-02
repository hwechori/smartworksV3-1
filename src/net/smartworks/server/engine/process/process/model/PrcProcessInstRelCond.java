package net.smartworks.server.engine.process.process.model;

import net.smartworks.server.engine.common.model.MisObjectCond;
import net.smartworks.server.engine.common.util.CommonUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrcProcessInstRelCond extends MisObjectCond {
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(PrcProcessInstRelCond.class);
	protected static final String PREFIX = "Prc";
	
	private static final String NAME = CommonUtil.toName(PrcProcessInstRelCond.class, PREFIX);

	public static final String A_TYPE = "type";
	public static final String A_INSTANCEID = "instanceId";
	public static final String A_PINSTANCEID = "pInstanceId";
	
	private String type = null;
	private String instanceId = null;
	private String pInstanceId = null;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	public String getPInstanceId() {
		return pInstanceId;
	}
	public void setPInstanceId(String instanceId) {
		pInstanceId = instanceId;
	}
}
