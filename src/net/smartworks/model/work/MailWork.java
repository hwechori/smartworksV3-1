package net.smartworks.model.work;

public class MailWork extends Work {

	private FormField[] displayFields = new FormField[] {
			new FormField(FormField.ID_OWNER, "from", FormField.TYPE_NUMBER),
			new FormField(FormField.ID_SUBJECT, "subject", FormField.TYPE_TEXT),
			new FormField(FormField.ID_CREATED_DATE, "date", FormField.TYPE_DATETIME),
			new FormField("mailSize", "size", FormField.TYPE_NUMBER),
			new FormField("attachments", "file", FormField.TYPE_FILE)
	};
	
	public FormField[] getDisplayFields() {
		return displayFields;
	}
	public void setDisplayFields(FormField[] displayFields) {
		this.displayFields = displayFields;
	}

	public MailWork(){
		super();
		super.setType(Work.TYPE_MAIL_MESSAGE);
	}
	public MailWork(String id, String name){
		super(id, name);
		super.setType(Work.TYPE_MAIL_MESSAGE);
	}
	public MailWork(String id, String name, String desc){
		super(id, name, Work.TYPE_MAIL_MESSAGE, desc);
	}
	
	public String getFieldNameById(String fieldId){
		for(int i=0; i < displayFields.length; i++)
			if(displayFields[i].getId().equals(fieldId))
				return displayFields[i].getName();
		return null;
	}
}
