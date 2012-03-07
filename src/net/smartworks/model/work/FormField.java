package net.smartworks.model.work;

import net.smartworks.model.BaseObject;
import net.smartworks.util.SmartMessage;

public class FormField extends BaseObject{
	
	public static final String ID_STATUS = "status";
	public static final String ID_SUBJECT = "subject";
	public static final String ID_TASK_NAME = "taskName";
	public static final String ID_LAST_TASK = "lastTask";
	public static final String ID_PROCESS_TIME = "processTime";
	public static final String ID_PROCESS_TYPE = "processType";
	public static final String ID_WORK_NAME = "WorkName";
	public static final String ID_WORK_INSTANCE_NAME = "WorkInstanceName";
	public static final String ID_WORK_SPACE_NAME = "WorkSpaceName";
	public static final String ID_CATEGORY_NAME = "FileCategoryName";
	public static final String ID_FILE_NAMES = "FileNames";

	public static final String ID_OWNER = "creator";
	public static final String ID_CREATED_DATE = "createdTime";
	public static final String ID_LAST_MODIFIER = "modifier";
	public static final String ID_LAST_MODIFIED_DATE = "modifiedTime";

	public static final String TYPE_TEXT = "textInput"; //string
	public static final String TYPE_USER = "userField"; //user
	public static final String TYPE_FILE = "fileField"; //file
	public static final String TYPE_OTHER_WORK = "refFormField"; // work
	public static final String TYPE_RICHTEXT_EDITOR = "richEditor"; //string
	public static final String TYPE_NUMBER = "numberInput"; //number
	public static final String TYPE_CURRENCY = "currencyInput"; //number
	public static final String TYPE_PERCENT = "percentInput"; //number
	public static final String TYPE_COMBO = "comboBox"; // string
	public static final String TYPE_IMAGE = "imageBox"; // string
	public static final String TYPE_CHECK_BOX = "checkBox"; // boolean
	public static final String TYPE_RADIO_BUTTON = "radioButton"; // text
	public static final String TYPE_EMAIL = "emailIDInput"; // string
	public static final String TYPE_DATE = "dateChooser"; //date
	public static final String TYPE_TIME = "timeField"; //time
	public static final String TYPE_DATETIME = "dateTimeChooser"; //datetime
	public static final String TYPE_DATA_GRID = "dataGrid"; //
	public static final String[] FORM_FIELD_TYPES_ALL = new String[] {
		TYPE_TEXT, TYPE_USER, TYPE_FILE, TYPE_OTHER_WORK, TYPE_RICHTEXT_EDITOR, TYPE_NUMBER, TYPE_CURRENCY, TYPE_PERCENT,
		TYPE_COMBO, TYPE_IMAGE, TYPE_CHECK_BOX, TYPE_RADIO_BUTTON, TYPE_EMAIL, TYPE_DATE, TYPE_TIME, TYPE_DATETIME, TYPE_DATA_GRID
	};
	public static final String[] FORM_FIELD_TYPES_VARIABLE = new String[] {
		TYPE_TEXT, TYPE_USER, TYPE_FILE, TYPE_NUMBER, TYPE_CURRENCY, TYPE_PERCENT, TYPE_COMBO, TYPE_CHECK_BOX,
		TYPE_CURRENCY, TYPE_PERCENT, TYPE_RADIO_BUTTON, TYPE_EMAIL, TYPE_DATE, TYPE_TIME, TYPE_DATETIME
	};	
	private static final String PREFIX = "field.type.";
	public static final String[] FORM_FIELD_TYPE_NAMES_VARIABLE = new String[] {
		SmartMessage.getString(PREFIX+TYPE_TEXT), SmartMessage.getString(PREFIX+TYPE_USER), SmartMessage.getString(PREFIX+TYPE_FILE),
		SmartMessage.getString(PREFIX+TYPE_NUMBER), SmartMessage.getString(PREFIX+TYPE_CURRENCY), SmartMessage.getString(PREFIX+TYPE_PERCENT),
		SmartMessage.getString(PREFIX+TYPE_COMBO), SmartMessage.getString(PREFIX+TYPE_CHECK_BOX), SmartMessage.getString(PREFIX+TYPE_CURRENCY),
		SmartMessage.getString(PREFIX+TYPE_PERCENT), SmartMessage.getString(PREFIX+TYPE_RADIO_BUTTON), SmartMessage.getString(PREFIX+TYPE_EMAIL),
		SmartMessage.getString(PREFIX+TYPE_DATE), SmartMessage.getString(PREFIX+TYPE_TIME), SmartMessage.getString(PREFIX+TYPE_DATETIME)
	};

	public static final FormField FIELD_STATUS = new FormField(ID_STATUS, SmartMessage.getString("common.title.status"), TYPE_COMBO);
	public static final FormField FIELD_SUBJECT = new FormField(ID_SUBJECT, SmartMessage.getString("common.title.instance_subject"), TYPE_TEXT);
	public static final FormField FIELD_TASK_NAME = new FormField(ID_TASK_NAME, SmartMessage.getString("common.title.task_name"), TYPE_TEXT);
	public static final FormField FIELD_LAST_TASK = new FormField(ID_LAST_TASK, SmartMessage.getString("common.title.last_task"), TYPE_TEXT);
	public static final FormField FIELD_PROCESS_TIME = new FormField(ID_PROCESS_TIME, SmartMessage.getString("common.title.process_time"), TYPE_TIME);
	public static final FormField FIELD_PROCESS_TYPE = new FormField(ID_PROCESS_TYPE, SmartMessage.getString("common.title.process_type"), TYPE_COMBO);

	public static final FormField FIELD_OWNER = new FormField(ID_OWNER, SmartMessage.getString("common.title.owner"), TYPE_USER);
	public static final FormField FIELD_CREATED_DATE = new FormField(ID_CREATED_DATE, SmartMessage.getString("common.title.created_date"), TYPE_DATE);
	public static final FormField FIELD_LAST_MODIFIER = new FormField(ID_LAST_MODIFIER, SmartMessage.getString("common.title.last_modifier"), TYPE_USER);
	public static final FormField FIELD_LAST_MODIFIED_DATE = new FormField(ID_LAST_MODIFIED_DATE, SmartMessage.getString("common.title.last_modified_date"), TYPE_DATE);

	public static final FormField[] DEFAULT_PROCESS_FIELDS = new FormField[] {
		FIELD_STATUS, FIELD_SUBJECT, FIELD_TASK_NAME, FIELD_LAST_TASK, FIELD_PROCESS_TIME, FIELD_PROCESS_TYPE, 
		FIELD_OWNER, FIELD_CREATED_DATE, FIELD_LAST_MODIFIER, FIELD_LAST_MODIFIED_DATE
	};
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
		if(type.equals(TYPE_TEXT) || type.equals(TYPE_RICHTEXT_EDITOR) || type.equals(TYPE_COMBO) || type.equals(TYPE_IMAGE) || type.equals(TYPE_EMAIL) || type.equals(TYPE_RADIO_BUTTON)){
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
