package net.smartworks.model.instance.info;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.FieldData;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.util.LocalDate;

public class IWInstanceInfo extends WorkInstanceInfo {

	private FieldData[] displayDatas;

	public FieldData[] getDisplayDatas() {
		return displayDatas;
	}
	public void setDisplayDatas(FieldData[] displayDatas) {
		this.displayDatas = displayDatas;
	}

	public IWInstanceInfo(){
		super();
	}	
	public IWInstanceInfo(String id, String name, WorkInfo work, UserInfo owner, UserInfo lastModifier, LocalDate lastModifiedDate){
		super(id, name, owner, lastModifier, lastModifiedDate);
		super.setWork(work);
	}
	
}
