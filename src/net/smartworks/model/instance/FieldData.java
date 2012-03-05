package net.smartworks.model.instance;

import java.util.List;
import java.util.Map;

import net.smartworks.util.SmartUtil;

public class FieldData {

	public static final int SIZE_DATETIME = 16;
	public static final int SIZE_DATE = 10;
	public static final int SIZE_TIME = 5;

	private String fieldId;
	private String fieldType;
	private String value;
	private String symbol;
	private List<Map<String, String>> fileNames;

	public List<Map<String, String>> getFileNames() {
		return fileNames;
	}
	public void setFileNames(List<Map<String, String>> fileNames) {
		this.fileNames = fileNames;
	}
	public FieldData() {
		super();
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public FieldData(String fieldId, String fieldType, String value){
		super();
		this.fieldId = fieldId;
		this.fieldType = fieldType;
		this.value = value;
	}
	
	public String getFileNamesHtml(){
		if(SmartUtil.isBlankObject(this.value) || SmartUtil.isBlankObject(this.fileNames)) return "";
		return SmartUtil.getFileNamesDetailInfo(this.fileNames);
	}
}
