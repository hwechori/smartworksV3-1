package net.smartworks.model.instance;

public class FieldData {

	private String fieldId;
	private String fieldType;
	private String value;
	private String fileId;

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
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public FieldData(String fieldId, String fieldType, String value){
		super();
		this.fieldId = fieldId;
		this.fieldType = fieldType;
		this.value = value;
	}
}
