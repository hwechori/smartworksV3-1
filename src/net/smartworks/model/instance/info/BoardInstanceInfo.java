package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.util.LocalDate;

public class BoardInstanceInfo extends WorkInstanceInfo {
		
	private String briefContent;
	private String attachment;

	public String getBriefContent() {
		return briefContent;
	}
	public void setBriefContent(String briefContent) {
		this.briefContent = briefContent;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
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