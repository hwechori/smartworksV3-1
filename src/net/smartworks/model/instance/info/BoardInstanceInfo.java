package net.smartworks.model.instance.info;

import java.util.List;
import java.util.Map;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.util.LocalDate;

public class BoardInstanceInfo extends WorkInstanceInfo {
		
	private String briefContent;
	private String fileGroupId;
	private List<Map<String, String>> fileNames;

	public String getFileGroupId() {
		return fileGroupId;
	}
	public void setFileGroupId(String fileGroupId) {
		this.fileGroupId = fileGroupId;
	}
	public List<Map<String, String>> getFileNames() {
		return fileNames;
	}
	public void setFileNames(List<Map<String, String>> fileNames) {
		this.fileNames = fileNames;
	}
	public String getBriefContent() {
		return briefContent;
	}
	public void setBriefContent(String briefContent) {
		this.briefContent = briefContent;
	}
	public BoardInstanceInfo(){
		super();
		super.setType(Instance.TYPE_BOARD);
	}

	public BoardInstanceInfo(String id, String subject, UserInfo owner, LocalDate lastModifiedDate){
		super(id, subject,  owner, owner, lastModifiedDate);
		super.setType(Instance.TYPE_BOARD);
	}
}