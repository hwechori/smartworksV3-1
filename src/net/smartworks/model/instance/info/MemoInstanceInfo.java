package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.util.LocalDate;

public class MemoInstanceInfo extends WorkInstanceInfo {

	private String content;
		
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public MemoInstanceInfo(){
		super();
		super.setType(Instance.TYPE_MEMO);
	}

	public MemoInstanceInfo(String id, String subject, WorkInfo work, UserInfo owner, LocalDate lastModifiedDate){
		super(id, subject, Instance.TYPE_MEMO, owner, owner, lastModifiedDate);
	}

}
