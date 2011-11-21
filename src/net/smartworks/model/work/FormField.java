package net.smartworks.model.work;

import net.smartworks.model.BaseObject;

public class FormField extends BaseObject{
	
	public static final String ID_STATUS = "status";
	public static final String ID_SUBJECT = "subject";
	public static final String ID_RUNNING_TASK = "runningTask";

	public static final String ID_OWNER = "owner";
	public static final String ID_CREATED_DATE = "createdDate";
	public static final String ID_LAST_MODIFIER = "lastModifier";
	public static final String ID_LAST_MODIFIED_DATE = "lastModifiedDate";
	
	public static final String TYPE_TEXT = "text"; //string
	public static final String TYPE_USER = "userField"; //user
	public static final String TYPE_FILE = "fileField"; //file
	public static final String TYPE_OTHER_WORK = "refFormField"; // work
	public static final String TYPE_RICHTEXT_EDITOR = "richEditor"; //string
	public static final String TYPE_NUMBER = "number"; //number
	public static final String TYPE_CURRENCY = "currencyInput"; //number
	public static final String TYPE_PERCENT = "percentInput"; //number
	public static final String TYPE_COMBO = "comboBox"; // string
	public static final String TYPE_IMAGE = "imageBox"; // string
	public static final String TYPE_CHECK_BOX = "checkBox"; // boolean
	public static final String TYPE_EMAIL = "emailIDInput"; // string
	public static final String TYPE_DATE = "dateChooser"; //date
	public static final String TYPE_TIME = "timeChooser"; //time
	public static final String TYPE_DATETIME = "date"; //datetime
	

	public static final FormField FIELD_STATUS = new FormField(ID_STATUS, "", TYPE_COMBO);
	public static final FormField FIELD_SUBJECT = new FormField(ID_SUBJECT, "", TYPE_TEXT);
	public static final FormField FIELD_RUNNING_TASK = new FormField(ID_RUNNING_TASK, "", TYPE_TEXT);

	public static final FormField FIELD_OWNER = new FormField(ID_OWNER, "", TYPE_USER);
	public static final FormField FIELD_CREATED_DATE = new FormField(ID_CREATED_DATE, "", TYPE_DATETIME);
	public static final FormField FIELD_LAST_MODIFIER = new FormField(ID_LAST_MODIFIER, "", TYPE_USER);
	public static final FormField FIELD_LAST_MODIFIED_DATE = new FormField(ID_LAST_MODIFIED_DATE, "", TYPE_DATETIME);

	private String type;
	
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
