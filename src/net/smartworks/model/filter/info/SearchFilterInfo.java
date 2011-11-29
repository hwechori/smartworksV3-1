package net.smartworks.model.filter.info;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.User;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.work.FormField;
import net.smartworks.util.LocalDate;

public class SearchFilterInfo extends BaseObject{
	
	public SearchFilterInfo(){
	}

	public SearchFilterInfo(String id, String name){
		super(id, name);
	}
}
