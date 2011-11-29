package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.util.LocalDate;

public class WorkInstanceInfo extends InstanceInfo {

	public WorkInstanceInfo(){
		super();
	}	
	public WorkInstanceInfo(String id, String subject, int type, UserInfo owner, UserInfo lastModifier,
			LocalDate lastModifiedDate) {
		super(id, subject, type, owner, lastModifier, lastModifiedDate);
	}
	
	
}
