package net.smartworks.model.report;

import java.util.List;
import java.util.Map;

public class Data{

	private String xFieldName;
	private String yValueName;
	private String[] groupNames;
	private List<Map<String, Object>> values; 
		
	public String getyValueName() {
		return yValueName;
	}
	public void setyValueName(String yValueName) {
		this.yValueName = yValueName;
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
	public List<Map<String, Object>> getValues() {
		return values;
	}
	public void setValues(List<Map<String, Object>> values) {
		this.values = values;
	}
	public Data() {
		super();
	}	
}
