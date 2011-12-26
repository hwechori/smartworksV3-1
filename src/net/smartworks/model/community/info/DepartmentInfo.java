package net.smartworks.model.community.info;

public class DepartmentInfo extends WorkSpaceInfo {

	private String desc;
		
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public DepartmentInfo(){
		super();
	}
	public DepartmentInfo(String id, String name){
		super(id, name);
	}

}