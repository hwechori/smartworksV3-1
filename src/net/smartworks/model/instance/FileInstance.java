package net.smartworks.model.instance;

import java.util.List;
import java.util.Map;

import net.smartworks.model.community.User;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.work.FileCategory;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.info.FileCategoryInfo;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartUtil;

public class FileInstance extends WorkInstance {

	private int views;
	private WorkInstance workInstance;
	private FileCategory fileCategory;
	private String content;
	private String fileGroupId;
	private List<Map<String, String>> files;

	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public WorkInstance getWorkInstance() {
		return workInstance;
	}
	public void setWorkInstance(WorkInstance workInstance) {
		this.workInstance = workInstance;
	}
	public FileCategory getFileCategory() {
		return fileCategory;
	}
	public void setFileCategory(FileCategory fileCategory) {
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
	public FileInstance(){
		super();
		super.setType(Instance.TYPE_FILE);
	}

	public FileInstance(String id, String subject, Work work, User owner, LocalDate lastModifiedDate){
			super(id, subject, work, owner, owner, lastModifiedDate);
			super.setType(Instance.TYPE_FILE);
	}

	public String getFilesHtml(){
		if(SmartUtil.isBlankObject(this.fileGroupId) || SmartUtil.isBlankObject(this.files)) return "";
		return SmartUtil.getFilesDetailInfo(this.files);
	}	
}
