package net.smartworks.model.notice;

import net.smartworks.model.community.info.GroupInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.instance.info.EventInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.util.LocalDate;

public class NoticeMessage{

	public final static int	TYPE_SYSTEM_NOTICE 	= 1;
	public final static int	TYPE_EVENT_ALARM 		= 2;
	public final static int	TYPE_TASK_DELAYED 		= 3;
	public final static int	TYPE_JOIN_REQUEST 		= 4;
	public final static int	TYPE_INSTANCE_CREATED 	= 5;
	
	private String			id;
	private int				type=-1;
	private UserInfo		issuer;
	private LocalDate		issuedDate;
	private InstanceInfo 	instance;
	private EventInstanceInfo	event;
	private GroupInfo			group;	
	private String			message;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public UserInfo getIssuer() {
		return issuer;
	}
	public void setIssuer(UserInfo issuer) {
		this.issuer = issuer;
	}
	public LocalDate getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}
	public InstanceInfo getInstance() {
		return instance;
	}
	public void setInstance(InstanceInfo instance) {
		this.instance = instance;
	}
	public EventInstanceInfo getEvent() {
		return event;
	}
	public void setEvent(EventInstanceInfo event) {
		this.event = event;
	}
	public GroupInfo getGroup() {
		return group;
	}
	public void setGroup(GroupInfo group) {
		this.group = group;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public NoticeMessage(){
		super();
	}
	public NoticeMessage(String id, int type, UserInfo issuer, LocalDate issuedDate){
		this.type = type;
		this.issuer = issuer;
		this.issuedDate = issuedDate;
	}
}
