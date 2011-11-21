package net.smartworks.model.work.info;

import net.smartworks.model.work.SmartWork;

public class SocialWorkInfo extends SmartWork {
	public final static int	TYPE_ATTACHMENT= 21;
	public final static int   TYPE_MENO		= 22;
	public final static int	TYPE_EVENT		= 23;
	public final static int	TYPE_BOARD		= 24;	
	public final static int	TYPE_FILE		= 25;
	public final static int	TYPE_PICTURE	= 26;
	public final static int	TYPE_MOVIE		= 27;
	
	public SocialWorkInfo(){
		super();
	}
	public SocialWorkInfo(String id, String name){
		super(id, name);
	}
}
