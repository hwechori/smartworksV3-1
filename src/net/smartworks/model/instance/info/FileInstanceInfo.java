package net.smartworks.model.instance.info;

import java.util.List;
import java.util.Map;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.util.LocalDate;

public class FileInstanceInfo extends WorkInstanceInfo {

	private String content;
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

}
