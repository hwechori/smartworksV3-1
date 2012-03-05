package net.smartworks.model.instance;

import java.util.List;
import java.util.Map;

import net.smartworks.model.community.User;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;

public class BoardInstance extends WorkInstance {
		
	private String content;
	private String fileGroupId;
	private List<Map<String, String>> files;

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

	public BoardInstance(){
		super();
		super.setType(Instance.TYPE_BOARD);
	}

	public BoardInstance(String id, String subject, Work work, User owner, LocalDate lastModifiedDate){
			super(id, subject, work, owner, owner, lastModifiedDate);
			super.setType(Instance.TYPE_BOARD);
	}
}