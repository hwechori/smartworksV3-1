package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.util.LocalDate;

public class PWInstanceInfo extends WorkInstanceInfo {

	public PWInstanceInfo() {
		super();
	}
	public PWInstanceInfo(String id, String subject, WorkInfo work, UserInfo owner, UserInfo lastModifier, LocalDate lastModifiedDate, TaskInstanceInfo lastTas) {
		super(id, subject, owner, lastModifier, lastModifiedDate);
		super.setWork(work);
	}
	

}
