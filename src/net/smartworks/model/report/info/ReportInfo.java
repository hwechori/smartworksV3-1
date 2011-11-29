package net.smartworks.model.report.info;

import net.smartworks.model.BaseObject;
import net.smartworks.model.KeyMap;
import net.smartworks.model.community.User;
import net.smartworks.model.community.WorkSpace;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.work.Work;
import net.smartworks.util.LocalDate;

public class ReportInfo extends BaseObject {

	public ReportInfo() {
		super();
	}
	
	public ReportInfo(String id, String name){
		super(id, name);
	}
}
