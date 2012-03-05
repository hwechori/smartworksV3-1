package net.smartworks.model.work;

public class SocialWork extends SmartWork {
	public final static int TYPE_MEMO		= 32;
	public final static int	TYPE_EVENT		= 33;
	public final static int	TYPE_BOARD		= 34;	
	public final static int	TYPE_FILE		= 35;
	public final static int	TYPE_IMAGE		= 36;
	public final static int	TYPE_MOVIE		= 37;
	
	public SocialWork(){
		super();
	}
	public SocialWork(String id, String name){
		super(id, name);
	}
}
