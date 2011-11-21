package net.smartworks.model.instance.info;

import java.util.Date;

import net.smartworks.model.community.User;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;

public class EventInstanceInfo extends InstanceInfo {

	private String			content;
	private UserInfo[]		relatedUsers;
	private LocalDate		start;
	private LocalDate		end;

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public UserInfo[] getRelatedUsers() {
		return relatedUsers;
	}
	public void setRelatedUsers(UserInfo[] relatedUsers) {
		this.relatedUsers = relatedUsers;
	}
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
	}
	public EventInstanceInfo(){
		super();
		super.setType(Instance.TYPE_EVENT);
	}

	public EventInstanceInfo(String id, String subject, UserInfo owner, LocalDate lastModifiedDate){
			super(id, subject, Instance.TYPE_EVENT, owner, owner, lastModifiedDate);
	}
}