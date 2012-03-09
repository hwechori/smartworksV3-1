package net.smartworks.model.instance.info;

import java.util.List;
import java.util.Map;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.work.FileCategory;
import net.smartworks.model.work.info.FileCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartUtil;

public class FileInstanceInfo extends WorkInstanceInfo {

	private WorkInstanceInfo workInstance;
	private FileCategoryInfo fileCategory;
	private String content;
	private String fileGroupId;
	private List<Map<String, String>> files;

	public WorkInstanceInfo getWorkInstance() {
		return workInstance;
	}
	public void setWorkInstance(WorkInstanceInfo workInstance) {
		this.workInstance = workInstance;
	}
	public FileCategoryInfo getFileCategory() {
		return fileCategory;
	}
	public void setFileCategory(FileCategoryInfo fileCategory) {
		this.fileCategory = fileCategory;
	}
	public String getFileGroupId() {
		return fileGroupId;
	}
	public void setFileGroupId(String fileGroupId) {
		this.fileGroupId = fileGroupId;
	}
	public List<Map<String, String>> getFiles() {
		return files;
	}
	public void setFiles(List<Map<String, String>> files) {
		this.files = files;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public FileInstanceInfo(){
		super();
		super.setType(Instance.TYPE_FILE);
	}

	public FileInstanceInfo(String id, String subject, WorkInfo work, UserInfo owner, LocalDate lastModifiedDate){
		super(id, subject, owner, owner, lastModifiedDate);
		super.setType(Instance.TYPE_FILE);
	}

	public String getFilesHtml(){
		if(SmartUtil.isBlankObject(this.fileGroupId) || SmartUtil.isBlankObject(this.files)) return "";
		return SmartUtil.getFilesDetailInfo(this.files);
	}
	
}
