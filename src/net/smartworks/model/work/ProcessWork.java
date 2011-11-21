package net.smartworks.model.work;

import net.smartworks.model.filter.SearchFilter;

public class ProcessWork extends SmartWork {

	private SmartDiagram diagram;
	private String helpUrl;
	private String manualFilePath;
	private String manualFileName;
	private SearchFilter[] searchFilters;
	
	public SmartDiagram getDiagram() {
		return diagram;
	}
	public void setDiagram(SmartDiagram diagram) {
		this.diagram = diagram;
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
	public SearchFilter[] getSearchFilters() {
		return searchFilters;
	}
	public void setSearchFilters(SearchFilter[] searchFilters) {
		this.searchFilters = searchFilters;
	}
	public ProcessWork(){
		super();
		super.setType(TYPE_PROCESS);
	}
	public ProcessWork(String id, String name){
		super(id, name);
		super.setType(TYPE_PROCESS);
	}
	public ProcessWork(String id, String name, String desc, WorkCategory myCategory){
		super(id, name, TYPE_PROCESS, desc, myCategory);
	}
}
