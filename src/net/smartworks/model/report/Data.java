package net.smartworks.model.report;

import java.util.Map;

public class Data{

	private String xFieldName;
	private String yFieldName;
	private String[] groupNames;
	private Map<String, Object>[] values; 
	
	
	public String getyFieldName() {
		return yFieldName;
	}
	public void setyFieldName(String yFieldName) {
		this.yFieldName = yFieldName;
	}
	public String getxFieldName() {
		return xFieldName;
	}
	public void setxFieldName(String xFieldName) {
		this.xFieldName = xFieldName;
	}
	public String[] getGroupNames() {
		return groupNames;
	}
	public void setGroupNames(String[] groupNames) {
		this.groupNames = groupNames;
	}
	public Map<String, Object>[] getValues() {
		return values;
	}
	public void setValues(Map<String, Object>[] values) {
		this.values = values;
	}
	
	public Data() {
		super();
	}	
}
