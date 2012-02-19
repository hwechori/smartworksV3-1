package net.smartworks.model.work;

import net.smartworks.model.BaseObject;

public class Work extends BaseObject{

	public final static int	TYPE_ASYNC_MESSAGE	= 1;
	public final static int	TYPE_NOTIFICAITON	= 2;
	public final static int	TYPE_COMMENTS		= 3;
	public final static int	TYPE_MAIL_MESSAGE	= 4;

	public static final int PROVIDED_BY_USER = 0;
	public static final int PROVIDED_BY_APPSTORE = 1;
	public static final int PROVIDED_BY_SYSTEM = 2;
	
	private int 	type=-1; 
	private int 	providedBy;
	private String 	desc;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getProvidedBy() {
		return providedBy;
	}
	public void setProvidedBy(int providedBy) {
		this.providedBy = providedBy;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Work(){
		super();
	}
	public Work(String id, String name){
		super(id, name);
	}	
	public Work(String id, String name, int type, String desc){
		super(id, name);
		this.type = type;
		this.desc = desc;
	}
}
