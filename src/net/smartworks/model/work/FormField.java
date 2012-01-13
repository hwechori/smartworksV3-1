package net.smartworks.model.work;

import net.smartworks.model.BaseObject;

public class FormField extends BaseObject{
	
	public static final String ID_STATUS = "status";
	public static final String ID_SUBJECT = "subject";
	public static final String ID_TASK_NAME = "taskName";
	public static final String ID_LAST_TASK = "lastTask";
	public static final String ID_PROCESS_TIME = "processTime";
	public static final String ID_PROCESS_TYPE = "processType";

	public static final String ID_OWNER = "creator";
	public static final String ID_CREATED_DATE = "createdTime";
	public static final String ID_LAST_MODIFIER = "modifier";
	public static final String ID_LAST_MODIFIED_DATE = "modifiedTime";

	public static final String TYPE_TEXT = "textInput"; //string
	public static final String TYPE_USER = "userField"; //user
	public static final String TYPE_USERS = "usersField"; //users
	public static final String TYPE_FILE = "fileField"; //file
	public static final String TYPE_OTHER_WORK = "refFormField"; // work
	public static final String TYPE_RICHTEXT_EDITOR = "richEditor"; //string
	public static final String TYPE_NUMBER = "numberInput"; //number
	public static final String TYPE_CURRENCY = "currencyInput"; //number
	public static final String TYPE_PERCENT = "percentInput"; //number
	public static final String TYPE_COMBO = "comboBox"; // string
	public static final String TYPE_IMAGE = "imageBox"; // string
	public static final String TYPE_CHECK_BOX = "checkBox"; // boolean
	public static final String TYPE_EMAIL = "emailIDInput"; // string
	public static final String TYPE_DATE = "dateChooser"; //date
	public static final String TYPE_TIME = "timeField"; //time
	public static final String TYPE_DATETIME = "dateTimeChooser"; //datetime
	public static final String TYPE_DATA_GRID = "dataGrid"; //

	public static final FormField FIELD_STATUS = new FormField(ID_STATUS, "", TYPE_COMBO);
	public static final FormField FIELD_SUBJECT = new FormField(ID_SUBJECT, "", TYPE_TEXT);
	public static final FormField FIELD_TASK_NAME = new FormField(ID_TASK_NAME, "", TYPE_TEXT);
	public static final FormField FIELD_LAST_TASK = new FormField(ID_LAST_TASK, "", TYPE_TEXT);
	public static final FormField FIELD_PROCESS_TIME = new FormField(ID_PROCESS_TIME, "", TYPE_TIME);
	public static final FormField FIELD_PROCESS_TYPE = new FormField(ID_PROCESS_TYPE, "", TYPE_COMBO);

	public static final FormField FIELD_OWNER = new FormField(ID_OWNER, "", TYPE_USER);
	public static final FormField FIELD_CREATED_DATE = new FormField(ID_CREATED_DATE, "", TYPE_DATETIME);
	public static final FormField FIELD_LAST_MODIFIER = new FormField(ID_LAST_MODIFIER, "", TYPE_USER);
	public static final FormField FIELD_LAST_MODIFIED_DATE = new FormField(ID_LAST_MODIFIED_DATE, "", TYPE_DATETIME);

	private String type;
	private int displayOrder;
	
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public FormField(){
		super();
	}
	public FormField(String id, String name, String type){
		super(id, name);
		this.setType(type);
	}
	
	public String getPageName(){
		if(this.type == null) return null;
		if(type.equals(TYPE_TEXT) || type.equals(TYPE_RICHTEXT_EDITOR) || type.equals(TYPE_COMBO) || type.equals(TYPE_IMAGE) || type.equals(TYPE_EMAIL)){
			return "string_field";
		}else if(type.equals(TYPE_USER)){
			return "user_field";
		}else if(type.equals(TYPE_FILE)){
			return "file_field";
		}else if(type.equals(TYPE_OTHER_WORK)){
			return "work_field";
		}else if(type.equals(TYPE_NUMBER) || type.equals(TYPE_CURRENCY) || type.equals(TYPE_PERCENT)){
			return "number_field";
		}else if(type.equals(TYPE_CHECK_BOX)){
			return "boolean_field";
		}else if(type.equals(TYPE_DATE)){
			return "date_field";
		}else if(type.equals(TYPE_TIME)){
			return "time_field";
		}else if(type.equals(TYPE_DATETIME)){
			return "datetime_field";
		}
		return null;
	}
}
