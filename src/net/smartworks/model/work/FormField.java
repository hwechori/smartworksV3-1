package net.smartworks.model.work;

import net.smartworks.model.BaseObject;

public class FormField extends BaseObject{
	
	public static final String ID_OWNER = "owner";
	public static final String ID_CREATED_DATE = "createdDate";
	public static final String ID_LAST_MODIFIER = "lastModifier";
	public static final String ID_LAST_MODIFIED_DATE = "lastModifiedDate";
	
	public static final String TYPE_TEXT = "text";
	public static final String TYPE_USER = "user";
	public static final String TYPE_FILE = "file";
	public static final String TYPE_OTHER_WORK = "work";
	public static final String TYPE_RICHTEXT_EDITOR = "editor";
	public static final String TYPE_NUMBER = "number";
	public static final String TYPE_CURRENCY = "currency";
	public static final String TYPE_COMBO = "combo";
	public static final String TYPE_IMAGE = "image";
	public static final String TYPE_EMAIL = "email";
	public static final String TYPE_DATE = "date";
	

	public static final FormField FIELD_OWNER = new FormField(ID_OWNER, "", TYPE_USER);
	public static final FormField FIELD_CREATED_DATE = new FormField(ID_CREATED_DATE, "", TYPE_DATE);
	public static final FormField FIELD_LAST_MODIFIER = new FormField(ID_LAST_MODIFIER, "", TYPE_USER);
	public static final FormField FIELD_LAST_MODIFIED_DATE = new FormField(ID_LAST_MODIFIED_DATE, "", TYPE_DATE);

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
}
