package net.smartworks.model.instance;

import net.smartworks.model.work.FormField;

public class SortingField {
	
	private String fieldId = FormField.ID_LAST_MODIFIED_DATE;
	private boolean isAscending = false;
	
	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public boolean isAscending() {
		return isAscending;
	}

	public void setAscending(boolean isAscending) {
		this.isAscending = isAscending;
	}

	public SortingField(){
		super();
	}

}
