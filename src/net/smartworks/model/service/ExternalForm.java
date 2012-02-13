package net.smartworks.model.service;

import net.smartworks.model.BaseObject;

public class ExternalForm extends BaseObject{
	
	private String desc;
	private String url;
	private String editMethod;
	private String viewMethod;
	private Variable[] editVariables;
	private Variable[] viewVariables;
	private Variable[] returnVariables;
		
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEditMethod() {
		return editMethod;
	}
	public void setEditMethod(String editMethod) {
		this.editMethod = editMethod;
	}
	public String getViewMethod() {
		return viewMethod;
	}
	public void setViewMethod(String viewMethod) {
		this.viewMethod = viewMethod;
	}
	public Variable[] getEditVariables() {
		return editVariables;
	}
	public void setEditVariables(Variable[] editVariables) {
		this.editVariables = editVariables;
	}
	public Variable[] getViewVariables() {
		return viewVariables;
	}
	public void setViewVariables(Variable[] viewVariables) {
		this.viewVariables = viewVariables;
	}
	public Variable[] getReturnVariables() {
		return returnVariables;
	}
	public void setReturnVariables(Variable[] returnVariables) {
		this.returnVariables = returnVariables;
	}
	
	public ExternalForm(){
	}
}
