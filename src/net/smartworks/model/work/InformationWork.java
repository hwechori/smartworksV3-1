package net.smartworks.model.work;

public class InformationWork extends SmartWork {

	private SmartForm form;
	private FormField keyField;
	private FormField[] displayFields;
	private String helpUrl;
	private String manualFilePath;
	private String manualFileName;
	
	public SmartForm getForm() {
		return form;
	}
	public void setForm(SmartForm form) {
		this.form = form;
	}
	public FormField getKeyField() {
		return keyField;
	}
	public void setKeyField(FormField keyField) {
		this.keyField = keyField;
	}
	public FormField[] getDisplayFields() {
		return displayFields;
	}
	public void setDisplayFields(FormField[] displayFields) {
		this.displayFields = displayFields;
	}
	public String getHelpUrl() {
		return helpUrl;
	}
	public void setHelpUrl(String helpUrl) {
		this.helpUrl = helpUrl;
	}
	public String getManualFilePath() {
		return manualFilePath;
	}
	public void setManualFilePath(String manualFilePath) {
		this.manualFilePath = manualFilePath;
	}
	public String getManualFileName() {
		return manualFileName;
	}
	public void setManualFileName(String manualFileName) {
		this.manualFileName = manualFileName;
	}
	public InformationWork(){
		super();
		super.setType(TYPE_INFORMATION);
	}
	public InformationWork(String id, String name){
		super(id, name);
		super.setType(TYPE_INFORMATION);
	}
	public InformationWork(String id, String name, String desc, WorkCategory myCategory){
		super(id, name, TYPE_INFORMATION, desc, myCategory);
	}
}
